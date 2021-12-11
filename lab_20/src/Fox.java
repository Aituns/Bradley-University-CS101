public class Fox extends Animal {
    public Fox() {
        super("Ring-ding-ding-dingeringeding", true, false, false, "Fox");
    }
    
    @Override
    public void breatheUnderwater() {
        throw new RuntimeException( "Foxes can't breathe under water!");
    }

    @Override
    public int numberOfLegs() {
        return 4;
    }

    @Override
    public int numberOfWings() {
        throw new RuntimeException("Foxes don't have wings!");
    }
}
