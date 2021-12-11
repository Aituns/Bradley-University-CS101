public class Bird extends Animal {
    public Bird() {
        super("tweet", true, true, false, "Bird");
    }
    
    @Override
    public void breatheUnderwater() {
        throw new RuntimeException( "Birds can't breathe under water!");
    }

    @Override
    public int numberOfLegs() {
        return 2;
    }

    @Override
    public int numberOfWings() {
        return 2;
    }
}
