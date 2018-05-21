package first.RESTtesttask.in.java;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RestTests {
    @Test(dataProvider = "getCountries")
    public void verifyContriesBoders(String fistsContryName, String secondCountryAllias) throws IOException {
        HttpHelper client = new HttpHelper();
        HttpResponse response = client.sentGetRequest();
        Assert.assertTrue(response.getStatusLine().getStatusCode() == 200);
        String contentType = client.getContentType(response);
        Assert.assertTrue(contentType.equals(client.jsonType));
        Set<ResponseModel> responseModels = client.deserialize(response);
        Assert.assertTrue(client.verifyTheCountriesHaveBorders
                        (responseModels, fistsContryName, secondCountryAllias),
                String.format("%s and %s should have borders", fistsContryName, secondCountryAllias));
    }

    @Test(dataProvider = "getContryAndArea")
    public void verifyArea(String fistsContryName, String area) throws IOException {
        HttpHelper client = new HttpHelper();
        HttpResponse response = client.sentGetRequest();
        Assert.assertTrue(response.getStatusLine().getStatusCode() == 200);
        String contentType = client.getContentType(response);
        Assert.assertTrue(contentType.equals(client.jsonType));
        Set<ResponseModel> responseModels = client.deserialize(response);
        ResponseModel model = client.getModelByName(responseModels, fistsContryName);
        Double actualContryArea = Double.parseDouble(model.getArea());
        Assert.assertTrue(actualContryArea > Double.parseDouble(area),
                String.format("%s should have area more than %s and it has %s "
                        , fistsContryName, area, actualContryArea));


        List<List<String>> list = new ArrayList<>();
        list.add(model.getBorders());
        ArrayList secondList = new ArrayList<String>();
        secondList.add(model.getName());
        secondList.add(model.getCapital());
        secondList.add(model.getRegion());
        secondList.add(model.getPopulation().toString());
        list.add(secondList);
        list.forEach(x -> x.forEach(c -> System.out.println(c)));
    }

    @DataProvider
    public Iterator<Object[]> getContryAndArea() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Ukraine", "500000.0"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> getCountries() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Latvia", "EST"});
        list.add(new Object[]{"Estonia", "LVA"});
        return list.iterator();
    }
}
