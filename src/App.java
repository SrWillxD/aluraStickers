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
        String url = "https://imdb-api.com/en/API/Top250Movies/" + System.getenv("API_KEY");
        var uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();


        // Extract only important fields (title, poster, rating)
        var parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body);


        // Manipulate and show data
        var maker = new StickerGenerator();
        var dir = new File("output/");
        dir.mkdir();
        for(Map<String, String> movie : movieList){

            String urlImage = movie.get("image");
            String title = movie.get("title");


            InputStream inputStream = new URL(urlImage).openStream();
            String fileName ="output/" + title + ".png";


            maker.make(inputStream, fileName);

            System.out.println("\u001b[1mTittle:\u001b[m "+movie.get("title"));
            System.out.println("\u001b[1mPoster:\u001b[m "+movie.get("image"));
            double classification = Double.parseDouble(movie.get("imDbRating"));
            int stars = (int) classification;

            for (int i = 0; i <stars; i++) {
                System.out.print("⭐");
            }
            System.out.println(" ");
        }
    }
}
