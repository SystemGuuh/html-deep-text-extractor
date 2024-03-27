public final class DeepText {
    public static String find(String html) {
        String deepestText = "";
        int deepestLevel = -1;
        int currentLevel = 0;
        boolean foundAtMaxDepth = false;

        // Removing comments and splitting tags by '<'
        String[] tags = html.replaceAll("(?s)<!--.*?-->", "").split("<");

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
                currentLevel--;
            }

            if (!tagContent.isEmpty()) {
                if (currentLevel == deepestLevel) {
                    String text = tagContent.replaceAll("(?s)<[^<>]+>", "").trim();
                    if (!text.isEmpty() && !foundAtMaxDepth) {
                        deepestText = text;
                        foundAtMaxDepth = true;
                    }
                }
            }
        }
        if (currentLevel != 0) return "malformed HTML";
        else return deepestText;
    }
}