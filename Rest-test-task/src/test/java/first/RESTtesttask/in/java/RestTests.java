package first.RESTtesttask.in.java;


import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RestTests {
    @Test(dataProvider = "url")
    public void Test1(String url) throws IOException {
        HttpHelper client = new HttpHelper(url);
        HttpResponse response = client.sentGetRequest();
        Assert.assertTrue(response.getStatusLine().getStatusCode() == 200);
        String contentType = client.getContentType(response);
        Assert.assertTrue(contentType.equals("application/json;charset=utf-8"));
        Set<ResponseModel> responseModels = client.deserialize(response);
         
    }

    @DataProvider
    public Iterator<Object[]> url() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"http://restcountries.eu/rest/v1/"});
        return list.iterator();
    }
}
