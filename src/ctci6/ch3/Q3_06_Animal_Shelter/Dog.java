package ctci6.ch3.Q3_06_Animal_Shelter;

public class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }

    public String name() {
        return "Dog: " + name;
    }
}
