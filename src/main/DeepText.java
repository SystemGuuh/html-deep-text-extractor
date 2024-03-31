import java.util.regex.Pattern;

public final class DeepText {
    public static String find(String html) {
        String deepestText = "";
        int deepestLevel = -1;
        int currentLevel = 0;
        boolean foundAtMaxDepth = false;
        int totalClosingTags = Pattern.compile("(?s)<\\/[a-zA-Z0-9]+>").matcher(html).groupCount();
        int currentClosedTags = 0;

        String htmlNoCommented = html.replaceAll("(?s)<!--.*?-->", "");
        String[] tags = htmlNoCommented.split("<");
        String[] tagsCompleteContent = htmlNoCommented.split("(?s)<[^<>]+>");

        for (String tag : tags) {
            if (tag.isEmpty()) continue;

            htmlTag htmlTag = new htmlTag(tag);
            String[] tagParts = tag.split(">", 2);
            String tagContent = tagParts[1];

            //checkTagLevel
            if (htmlTag.isOpeningTag()) {
                currentLevel++;
                if (currentLevel > deepestLevel) {
                    deepestLevel = currentLevel;
                    foundAtMaxDepth = false;
                }
            } else {
                currentClosedTags++;
                currentLevel--;
            }

            //checkTagContent
            if (!tagContent.isEmpty()) {
                if (currentLevel == deepestLevel) {
                    String text = tagContent.replaceAll("(?s)<[^<>]+>", "").trim();
                    if (!text.isEmpty() && !foundAtMaxDepth) {
                        deepestText = tagsCompleteContent[currentLevel].replaceAll("^\\s*", "");
                        foundAtMaxDepth = true;
                        if(currentClosedTags>=(totalClosingTags/2)) return deepestText;
                    }
                }
            }
        }

        if (currentLevel != 0) return "malformed HTML";
        else return deepestText;
    }
}