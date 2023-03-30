import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.net.URL;
import java.io.File;

public class App {
    public static void main(String[] args)throws Exception{
        // Make a https connection and grab the top 250 movies

//        String url = "https://imdb-api.com/en/API/Top250Movies/" + System.getenv("API_KEY");
//        ContentExtractor extractor = new ImdbContentExtractor();

        String url = "https://api.nasa.gov/planetary/apod?api_key=5mBDGFbUpodug0xoRNkSGyoxkAROTI6DGNXrhnTT&start_date=2022-06-12&end_date=2022-06-14";
        ContentExtractor extractor = new NasaContentExtractor();

        var http = new ClientHttp();
        String json = http.searchData(url);

        // Manipulate and show data

        List<Content> contents=  extractor.extractContent(json);

        var maker = new StickerGenerator();
        var dir = new File("output/");
        dir.mkdir();
        for(int i =0; i<3; i++ ){
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName ="output/" + content.getTitle() + ".png";

            maker.make(inputStream, fileName);

            System.out.println(content.getTitle());
        }
    }
}
