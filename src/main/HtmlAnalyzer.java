import javax.naming.directory.InvalidAttributesException;


public class HtmlAnalyzer {
    private static final String URL_CONNECTION_ERROR_MESSAGE = "URL connection error";
    private static final String MALFORMED_HTML_MESSAGE = "malformed HTML";

    public static void main(String[] args){
        String url = args[0];

        try {
            String html = Conn.getContentFromUrl(url);
            if (!Validation.checkHTMLStructure(html))
                throw new InvalidAttributesException();

            System.out.println(DeepText.find(html));

        } catch (InvalidAttributesException e) {
            System.out.println(MALFORMED_HTML_MESSAGE);
        } catch (Exception e) {
            System.out.println(URL_CONNECTION_ERROR_MESSAGE);
        }
    }
}