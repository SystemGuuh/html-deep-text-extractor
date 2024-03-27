import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//treat InvalidUrlException throw by URL class
class InvalidUrlException extends Exception {
    private static final String MALFORMED_URL_MESSAGE = "malformed url, please try again";

    public InvalidUrlException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Conn {
    static String getContentFromUrl(String urlString) throws IOException, InvalidUrlException {
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();

            //try-with-resources to close 'in' when not used
            try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }
            }

            return sb.toString();
        } catch (IOException e) {
            throw new IOException("Error while fetching content from URL: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new InvalidUrlException("malformed url, please try again: " + e.getMessage(), e);
        }
    }
}
