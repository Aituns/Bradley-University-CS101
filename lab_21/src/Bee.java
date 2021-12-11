public class Bee implements HasWings {
    int _wings;

    public int getWings() {
        return _wings;
    }

    public void setWings(int wings) {
        _wings = wings;
    }

    public Bee(int wings) {
        _wings = wings;
    }

    @Override
    public int getNumberOfWings() {
        return getWings();
    }

    @Override
    public String toString() {
        return "I am a bee.";
    }
}
