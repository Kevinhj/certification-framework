package dataproviders;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.CustomerData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CustomersDataProviders {

    @DataProvider(name = "getCustomerDataFromJson")
    private Object[] getCustomerDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/datafiles/CustomerData.json"));
        JsonElement customersDataSet = jsonData.getAsJsonObject().get("dataset");

        List<CustomerData> usersData = new Gson().fromJson(customersDataSet, new TypeToken<List<CustomerData>>(){}.getType());

        Object[][] returnValue = new Object[usersData.size()][1];

        int index = 0;
        for (Object[] each: returnValue){
            each[0] = usersData.get(index++);
        }
        return returnValue;
    }
}
