package homework1;

public class Main {
    static void main() {
        Changeable changeable = new Changeable("Hello");

        Immutable immutable1 = new Immutable();
        System.out.println(immutable1.getString());

        Immutable immutable2 = new Immutable(changeable);
        changeable.setString("New string");
        System.out.println(immutable2.getString());
    }
}