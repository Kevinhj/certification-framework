package pojo;

public class ProductCurrencyData {
    private String usDollar;
    private String euro;
    private String poundSterling;

    public ProductCurrencyData(String usDollar, String euro, String poundSterling){
        this.usDollar = usDollar;
        this.euro = euro;
        this.poundSterling = poundSterling;
    }

    public String getUsDollar(){
        return this.usDollar;
    }

    public String getEuro(){
        return this.euro;
    }

    public String getPoundSterling(){
        return this.poundSterling;
    }
}
