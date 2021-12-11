import javax.swing.text.AbstractDocument.LeafElement;

public class Table implements HasLegs {
    int _legs;
    
    public int getLegs() {
        return _legs;
    }

    public void setLegs(int legs) {
        _legs = legs;
    }

    public Table(int legs) {
        _legs = legs;
    }

    @Override
    public int getNumberOfLegs() {
        return getLegs();
    }

    @Override
    public String toString() {
        return "I am a table.";
    }
}
