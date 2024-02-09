package week02.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;

public class JSON {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {

    }

    public static Customer[] getAccounts(){
        Customer[] customers = null;
        try(FileReader reader = new FileReader("file:///Users/hannisalman/Desktop/Skole/IntelliJ/3Semester/3sem-assignments-template/week02/task2/account.json")){
            customers = gson.fromJson(reader, Customer[].class);
        }catch(Exception e){

        }
        return customers;
    }
}

class Customer {
    private String firstname;
    private String lastname;
    private String birthdate;
    private Address address;
    private Account account;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public Account getAccount() {
        return account;
    }
}

class Address {
    private String address;
    private String city;
    private String zipcode;

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}

class Account {
    private String id;
    private String balance;
    private boolean isActive;

    public String getId() {
        return id;
    }

    public String getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }
}

