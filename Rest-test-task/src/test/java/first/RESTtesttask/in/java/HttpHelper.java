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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class HttpHelper {
    String url ="http://restcountries.eu/rest/v1/";
    String jsonType = "application/json;charset=utf-8";
    HttpClient client;

    public HttpHelper() {
        this.client = HttpClientBuilder.create().build();
    }
    public void dispose(HttpResponse response) throws IOException {
        if( response.getEntity() != null ) {
            response.getEntity().getContent().close();
        }
    }

    public HttpResponse sentGetRequest() throws IOException {
        HttpGet request = new HttpGet(url);
        return client.execute(request);
    }

    public String getContentType(HttpResponse response) {
        Header header = response.getEntity().getContentType();
        return header.getValue();
    }

    public Set<ResponseModel> deserialize(HttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String jsonValue = rd.readLine();
        Gson json = new Gson();
        return json.fromJson(jsonValue, new TypeToken<Set<ResponseModel>>() {
        }.getType());
    }

    public ResponseModel getModelByName(Set<ResponseModel> responseModels, String countryName) {
        return responseModels.stream().filter(responseModel -> responseModel.getName().contains(countryName))
                .collect(Collectors.toList()).get(0);
    }

    public boolean verifyTheCountriesHaveBorders(Set<ResponseModel> responseModels, String firstContryName, String secondContryAlias) {
        ResponseModel model = getModelByName(responseModels, firstContryName);
        return model.getBorders().stream().filter(x -> x.contains(secondContryAlias)).collect(Collectors.toList()).size() == 1;
    }
}
