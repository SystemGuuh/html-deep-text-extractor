import java.io.IOException;
import javax.naming.directory.InvalidAttributesException;
import javax.naming.directory.NoSuchAttributeException;


public class HtmlAnalyzer {
    private static final String INVALID_ARGUMENTS_MESSAGE = "invalid arguments error";
    private static final String URL_CONNECTION_ERROR_MESSAGE = "URL connection error";
    private static final String MALFORMED_HTML_MESSAGE = "malformed HTML";
    private static final String NO_ATTRIBUTE_MESSAGE = "please, use a valid attribute as input";

    public static void main(String[] args) throws NoSuchAttributeException {
        if (args.length < 1)
            throw new NoSuchAttributeException(NO_ATTRIBUTE_MESSAGE);

        String url = args[0];

        try {
            String html = Conn.getContentFromUrl(url);
            if (!Validation.CheckHTMLStructure(html))
                throw new InvalidAttributesException(MALFORMED_HTML_MESSAGE);

            System.out.println(DeepText.find(html));

        } catch (IOException e) {
            System.out.println(URL_CONNECTION_ERROR_MESSAGE);
        } catch (InvalidAttributesException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_ARGUMENTS_MESSAGE);
        } catch (InvalidUrlException e) {
            throw new RuntimeException(e);
        }
    }
}