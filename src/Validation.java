import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {
    public static boolean CheckHTMLStructure(String html) {
        //Regex to catch: opened tags + closed tags + text + end of html archive
        String regex = "(<[a-zA-Z0-9]+>|<\\s*a\\s+[^>]*>)"+"|(<\\/[a-zA-Z0-9]+>)"+"|((?<=>)[^<]+(?=<))"+"|(<\\/html>)";

        Matcher matcher = Pattern.compile(regex).matcher(html);
        return CheckOpenedClosedTags(matcher);
    }

    private static boolean CheckOpenedClosedTags(Matcher matcher) {
        Stack<String> tagStack = new Stack<>();

        while (matcher.find()) {
            String match = matcher.group();

            //Regex to catch: opened tags + closed tags
            Matcher matcherLine = Pattern.compile("(<[a-zA-Z0-9]+>|<\\s*a\\s+[^>]*>)|(<\\/[a-zA-Z0-9]+>)").matcher(match);
            while (matcherLine.find()) {
                String tag = matcherLine.group(1);

                if (tag != null && tag.startsWith("</")) {
                    String closingTagName = tag.substring(2, tag.length() - 1);
                    String lastOpenedTag = tagStack.pop();
                    String openedTagName = lastOpenedTag.substring(1, lastOpenedTag.length() - 1);

                    if (!openedTagName.contains(closingTagName)) {
                        return false;
                    }
                } else {
                    tagStack.push(tag);
                }
            }
        }
        return true;
    }
}