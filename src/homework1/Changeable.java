package homework1;

public class Changeable {
    private String string;

    Changeable(String string) {
        this.string = string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}