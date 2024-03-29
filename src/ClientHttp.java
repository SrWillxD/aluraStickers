import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {
    public String searchData(String url){

        try {
            var uri = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch (IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }
}
