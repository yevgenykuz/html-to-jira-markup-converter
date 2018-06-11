import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

class HtmlToJiraMarkupConverterTests {

    @Test
    @DisplayName("Basic HTML to Jira Markup Conversion")
    void testBasicHtmlIsProperlyConverted() {
        String htmlText = "<b>bold</b> text, <em>emphasized</em> text";
        HtmlToJiraMarkupConverter htmlToJiraMarkupConverter = new HtmlToJiraMarkupConverterImpl();
        String jiraMarkupText = htmlToJiraMarkupConverter.convert(htmlText);
        assertEquals("*bold* text, _emphasized_ text", jiraMarkupText);
    }

    @Test
    @DisplayName("Complex HTML to Jira Markup Conversion")
    void testComplexHtmlIsProperlyConverted() {
        String htmlText = "<h2>A Nested List</h2>\n" +
                "\n" +
                "<ul>\n" +
                "  <li>Coffee</li>\n" +
                "  <li>Tea\n" +
                "    <ul>\n" +
                "    <li>Black tea</li>\n" +
                "    <li>Green tea\n" +
                "      <ul>\n" +
                "      <li>China</li>\n" +
                "      <li>Africa</li>\n" +
                "      </ul>\n" +
                "    </li>\n" +
                "    </ul>\n" +
                "  </li>\n" +
                "  <li>Milk</li>\n" +
                "</ul>";
        HtmlToJiraMarkupConverter htmlToJiraMarkupConverter = new HtmlToJiraMarkupConverterImpl();
        String jiraMarkupText = htmlToJiraMarkupConverter.convert(htmlText);
        assertEquals("h2. A Nested List\n" +
                "\n" +
                "* Coffee\n" +
                "* Tea\n" +
                "** Black tea\n" +
                "** Green tea\n" +
                "*** China\n" +
                "*** Africa\n" +
                "* Milk", jiraMarkupText);
    }
}
