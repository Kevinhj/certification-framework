package dataproviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.ProductData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsDataProviders {

    @DataProvider(name = "getProductsFromJson")
    private Object[] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/datafiles/ProductsData.json"));
        JsonElement productDataSet = jsonData.getAsJsonObject().get("dataset");

        List<ProductData> productData = new Gson().fromJson(productDataSet, new TypeToken<List<ProductData>>(){}.getType());

        Object[][] returnValue = new Object[productData.size()][1];

        int index = 0;
        for (Object[] each: returnValue){
            each[0] = productData.get(index++);
        }
        return returnValue;
    }
}
