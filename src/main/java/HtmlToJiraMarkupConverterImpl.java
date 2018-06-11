import com.atlassian.renderer.wysiwyg.converter.DefaultWysiwygConverter;

public class HtmlToJiraMarkupConverterImpl implements HtmlToJiraMarkupConverter {

    public String convert(String htmlText) {
        DefaultWysiwygConverter converter = new DefaultWysiwygConverter();
        return converter.convertXHtmlToWikiMarkup(htmlText);
    }
}
