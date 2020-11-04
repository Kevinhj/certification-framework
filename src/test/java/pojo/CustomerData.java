package pojo;

public class CustomerData {
    private String fistName;
    private String lastName;
    private String phone;
    private String password;
    private String passwordConfirmation;

    public CustomerData(String fistName, String lastName, String phone, String password, String passwordConfirmation){
        this.fistName = fistName;
        this.lastName = lastName;
        this.phone= phone;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getFistName(){
        return this.fistName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPasswordConfirmation(){
        return this.passwordConfirmation;
    }
}
