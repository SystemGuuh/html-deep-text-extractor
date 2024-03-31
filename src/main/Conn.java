import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Conn {
    static String getContentFromUrl(String urlString) throws IOException {
        StringBuilder sb = new StringBuilder();
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
    }
}
