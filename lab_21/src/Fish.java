public class Fish implements BreathesUnderwater {
    Boolean _breathesUnderwater;

    public Boolean getbreatheUnderwater() {
        return _breathesUnderwater;
    }

    public void getbreatheUnderwater(Boolean breathesUnderwater) {
        _breathesUnderwater = breathesUnderwater;
    }

    public Fish(Boolean breathesUnderwater) {
        _breathesUnderwater = breathesUnderwater;
    }

    @Override
    public void breatheUnderwater() {
    }

    @Override
    public String toString() {
        return "I am a fish.";
    }
}
