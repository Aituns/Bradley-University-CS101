public class ScubaDiver implements BreathesUnderwater {
    Boolean _breathesUnderwater;

    public Boolean getbreatheUnderwater() {
        return _breathesUnderwater;
    }

    public void getbreatheUnderwater(Boolean breathesUnderwater) {
        _breathesUnderwater = breathesUnderwater;
    }

    public ScubaDiver(Boolean breathesUnderwater) {
        _breathesUnderwater = breathesUnderwater;
    }

    @Override
    public void breatheUnderwater() {
    }

    @Override
    public String toString() {
        return "I am a Scuba Diver.";
    }
}