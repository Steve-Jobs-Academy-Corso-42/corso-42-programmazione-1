package OOP.Completi.Ereditarietà;

abstract public class User {
    String name;
    String surname;
    int age;

    String role;

    abstract void login();

    void print() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);
    }

    User(String name, String surname, int age, String role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.role = role;
    }
}
