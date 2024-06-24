import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorExchanges {
    public Exchanges converterExchanges(String base_code, String target_code, String value) {
        String url_str = "https://v6.exchangerate-api.com/v6/cf3387ead7187b348ab07774//pair/"+base_code+"/"+target_code+"/"+value;

        URI webAddress = URI.create(url_str);
        System.out.println("URL=" + webAddress);

        HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(webAddress)
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Exchanges.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
