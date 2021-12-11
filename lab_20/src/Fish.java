public class Fish extends Animal{
    public Fish() {
        super("blub", false, false, true, "Fish");
    }
    
    @Override
    public void breatheUnderwater() {
        System.out.println("A fish can breathe under water");
    }

    @Override
    public int numberOfLegs() {
        throw new RuntimeException("Fish don't have legs!");
    }

    @Override
    public int numberOfWings() {
        throw new RuntimeException("Fish don't have wings!");
    }
}
