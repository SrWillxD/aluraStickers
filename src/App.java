import java.util.List;
import java.io.InputStream;
import java.net.URL;
import java.io.File;

public class App {
    public static void main(String[] args)throws Exception{
        // Make a https connection and grab the top 250 movies

        String url = System.getenv("IMDB-KEY");
        ContentExtractor extractor = new ImdbContentExtractor();

//        String url = System.getenv("NASA-URL");
//        ContentExtractor extractor = new NasaContentExtractor();

//        String url = "http://localhost:8080/linguagens";
//        ContentExtractor extractor = new ImdbContentExtractor();

        var http = new ClientHttp();
        String json = http.searchData(url);

        // Manipulate and show data

        List<Content> contents=  extractor.extractContent(json);

        var maker = new StickerGenerator();
        var dir = new File("output/");
        dir.mkdir();
        for(int i =0; i<250; i++ ){
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName ="output/" + content.getTitle() + ".png";

            maker.make(inputStream, fileName);

            System.out.println(i);
            System.out.println(content.getTitle());
        }
    }
}
