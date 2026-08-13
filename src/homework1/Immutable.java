package homework1;

public class Immutable {
    private final Changeable changeable;

    Immutable() {
        this.changeable = new Changeable("Some string");
    }

    Immutable(Changeable changeable) {
        this.changeable = new Changeable(changeable.getString());
    }

    public String getString() {
        return this.changeable.getString();
    }
}