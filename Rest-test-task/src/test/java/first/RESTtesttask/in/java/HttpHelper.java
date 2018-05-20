package first.RESTtesttask.in.java;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class HttpHelper {
    String url;
    HttpClient client;

    public HttpHelper(String url) {
        this.url = url;
        this.client = HttpClientBuilder.create().build();
    }

    public HttpResponse sentGetRequest() throws IOException {
        HttpGet request = new HttpGet(url);
        return client.execute(request);
    }

    public String getContentType(HttpResponse response){
        Header header = response.getEntity().getContentType();
        return header.getValue();
    }

    public Set<ResponseModel> deserialize(HttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String jsonValue = rd.readLine();
        Gson json = new Gson();
        return json.fromJson(jsonValue, new TypeToken<Set<ResponseModel>>() {}.getType());
    }
}
