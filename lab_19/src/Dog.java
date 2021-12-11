public class Dog extends Animal {
    
    public Dog() {
        super("woof", true, false, false);
    }
    
    @Override
    public void breatheUnderwater() {
        throw new RuntimeException( "Dogs can't breathe under water!");
    }

    @Override
    public int numberOfLegs() {
        return 4;
    }

    @Override
    public int numberOfWings() {
        throw new RuntimeException("Dogs don't have wings!");
    }
}