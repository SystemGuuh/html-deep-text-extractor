package test;
import test.HtmlAnalyzerTest;
import main.HtmlAnalyzer;
import org.junit.Test;
import java.io.IOException;
import javax.naming.directory.InvalidAttributesException;
import javax.naming.directory.NoSuchAttributeException;

import static org.junit.Assert.*;

public class HtmlAnalyzerTest {

    @Test
    public void testValidHtml() throws NoSuchAttributeException {
        // Arrange
        String validHtml = "<html><body><h1>Title</h1><p>Content</p></body></html>";

        // Act
        String result = HtmlAnalyzer.analyzeHtml(validHtml);

        // Assert
        assertEquals("Title", result);
    }

    @Test(expected = NoSuchAttributeException.class)
    public void testNoUrlProvided() throws NoSuchAttributeException {
        // Act
        HtmlAnalyzer.analyzeHtml(null);
    }

    @Test
    public void testMalformedHtml() throws NoSuchAttributeException {
        // Arrange
        String malformedHtml = "<html><body><h1>Title</h1><p>Content</body></html>";

        // Act
        String result = HtmlAnalyzer.analyzeHtml(malformedHtml);

        // Assert
        assertEquals("malformed HTML", result);
    }

    @Test
    public void testIOException() throws NoSuchAttributeException {
        // Arrange
        String url = "invalid_url";

        // Act
        String result = HtmlAnalyzer.analyzeHtml(url);

        // Assert
        assertEquals("URL connection error", result);
    }
}
