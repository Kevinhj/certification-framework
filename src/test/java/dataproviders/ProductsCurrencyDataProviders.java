package dataproviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.ProductCurrencyData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsCurrencyDataProviders {

    @DataProvider(name = "getProductsCurrencyFromJson")
    private Object[] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/datafiles/ProductsCurrencyData.json"));
        JsonElement productCurrencyDataSet = jsonData.getAsJsonObject().get("dataset");

        List<ProductCurrencyData> productCurrencyData = new Gson().fromJson(productCurrencyDataSet, new TypeToken<List<ProductCurrencyData>>(){}.getType());

        Object[][] returnValue = new Object[productCurrencyData.size()][1];

        int index = 0;
        for (Object[] each: returnValue){
            each[0] = productCurrencyData.get(index++);
        }
        return returnValue;
    }
}
