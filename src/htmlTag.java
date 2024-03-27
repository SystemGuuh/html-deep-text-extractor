public class htmlTag {
    private String tagName;
    private boolean isOpeningTag;

    public htmlTag(String tag) {
        if (tag.startsWith("/")) {
            tagName = tag.substring(1);
            isOpeningTag = false;
        } else {
            tagName = tag;
            isOpeningTag = true;
        }
    }

    public String getTagName() {
        return tagName;
    }

    public boolean isOpeningTag() {
        return isOpeningTag;
    }
}