abstract class Mammal extends Animal implements IWarmBlooded {
    
    private int _bodyTemp;
    public abstract void callSound(); // We don't know what ALL mammals sound like
    public abstract int move(); // Some mammals run, others walk, some swim, and some do all of the above.
    public int currentBodyTemperature() {
        return _bodyTemp;
    }

    public int isOverheated() {
        return _bodyTemp = 98; // This can be overridden based on the child class if needed
    }
}