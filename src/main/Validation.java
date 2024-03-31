import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {
    public static boolean checkHTMLStructure(String html) {
        String regex = "(?s)(<[a-zA-Z0-9]+>|<\\s*[a|div|html]+\\s+[^<>]*>)|(<\\/(?!br\\b)[a-zA-Z0-9]+>)";
        Matcher matcher = Pattern.compile(regex).matcher(html);
        return checkOpenedClosedTags(matcher);
    }

    private static boolean checkOpenedClosedTags(Matcher matcher) {
        Stack<String> tagStack = new Stack<>();
        while (matcher.find()) {
            String tag = matcher.group();
            if (tag.startsWith("</")) {
                if (!validateClosingTag(tag, tagStack)) {
                    return false;
                }
            } else {
                tagStack.push(tag);
            }
        }
        return true;
    }

    private static boolean validateClosingTag(String closingTag, Stack<String> tagStack) {
        String closingTagName = closingTag.substring(2, closingTag.length() - 1);
        String lastOpenedTag = tagStack.pop();
        String openedTagName = lastOpenedTag.substring(1, lastOpenedTag.length() - 1);
        return openedTagName.contains(closingTagName);
    }
}
