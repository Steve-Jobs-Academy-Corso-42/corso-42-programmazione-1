package OOP.Completi.Ereditarietà;

public class Admin extends User {
    Admin(String name, String surname, int age) {
        super(name, surname, age, "admin");
    }

    void login() {
        System.out.println("Admin " + name + " logged in");
    }

    @Override
    void print() {
        super.print();
        System.out.println("Admin printed!");
    }
}
