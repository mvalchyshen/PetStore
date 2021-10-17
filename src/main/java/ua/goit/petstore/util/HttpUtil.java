package ua.goit.petstore.util;

import com.google.gson.Gson;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil<E> {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final CloseableHttpClient DEFAULT = HttpClients.createDefault();
    private static final ResponseHandler<String> handler = new BasicResponseHandler();

    public static final Gson GSON = new Gson();

    public static HttpRequest sendGet(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }

    public static HttpRequest sendDelete(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();
    }

    public static <E> HttpRequest sendRequestWithBody(String url, String method, E entity) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .method(method, HttpRequest.BodyPublishers.ofString(GSON.toJson(entity)))
                .build();
    }

    public static HttpResponse<String> getResponse(HttpRequest httpRequest) throws IOException, InterruptedException {
        return CLIENT.send(httpRequest,HttpResponse.BodyHandlers.ofString());
    }


}
