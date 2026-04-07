package OOP.Completi.Ereditarietà;

public class Business extends User {
    String businessName;
    String pIva;
    String address;
    String phone;

    Business(String name, String surname, int age, String businessName, String pIva, String address, String phone) {
        super(name, surname, age, "business");
        this.businessName = businessName;
        this.pIva = pIva;
        this.address = address;
        this.phone = phone;
    }

    void login(){
        System.out.println("Business " + businessName + " logged in");
    }

}
