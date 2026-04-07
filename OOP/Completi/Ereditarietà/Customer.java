package OOP.Completi.Ereditarietà;

public class Customer extends User {
    public Customer(String name, String surname, int age) {
        super(name, surname, age, "customer");
    }

    void login() {
        System.out.println("Customer " + name + " logged in");
    }
}