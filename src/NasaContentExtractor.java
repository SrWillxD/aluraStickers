import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json){

        // Extract only important fields (title, poster, rating
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // Populate the list of contents
        for (Map<String, String> attributes: attributesList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url");

            var content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}
