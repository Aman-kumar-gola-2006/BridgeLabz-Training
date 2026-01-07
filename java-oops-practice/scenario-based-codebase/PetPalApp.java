// PetPal – Virtual Pet Care App
// All classes and interface are written inside one file for easy execution

// Interface for common actions for all pets
interface IInteractable {
    void feed();
    void play();
    void sleep();
}

// Parent Pet class
abstract class Pet implements IInteractable {

    String name;
    String type;
    int age;

    // Private values for encapsulation
    private int hunger;
    private int mood;
    private int energy;

    // Constructor with random starting values
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

        // Random mood, hunger, energy
        this.hunger = (int)(Math.random() * 50) + 20;
        this.mood   = (int)(Math.random() * 50) + 20;
        this.energy = (int)(Math.random() * 50) + 20;
    }

    // Getter methods
    public int getHunger() { return hunger; }
    public int getMood()   { return mood; }
    public int getEnergy() { return energy; }

    // Setter methods for internal use only
    protected void setHunger(int val) { hunger += val; }
    protected void setMood(int val)   { mood += val; }
    protected void setEnergy(int val) { energy += val; }

    // To be overridden by each pet
    abstract void makeSound();

    // Feed method
    @Override
    public void feed() {
        System.out.println(name + " is eating...");
        setHunger(-20);
        setMood(+10);
        setEnergy(+5);
    }

    // Play method
    @Override
    public void play() {
        System.out.println(name + " is playing...");
        setMood(+20);
        setEnergy(-15);
        setHunger(+10);
    }

    // Sleep method
    @Override
    public void sleep() {
        System.out.println(name + " is sleeping...");
        setEnergy(+30);
        setHunger(+5);
    }

    // Show current status
    public void showStatus() {
        System.out.println("-------- Pet Status --------");
        System.out.println("Name   : " + name);
        System.out.println("Type   : " + type);
        System.out.println("Age    : " + age);
        System.out.println("Hunger : " + hunger);
        System.out.println("Mood   : " + mood);
        System.out.println("Energy : " + energy);
        System.out.println("----------------------------");
    }
}

// Dog class
class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Woof Woof!");
    }
}

// Cat class
class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Meow Meow!");
    }
}

// Bird class
class Bird extends Pet {
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Tweet Tweet!");
    }
}

// Main class
public class PetPalApp {
    public static void main(String[] args) {

        // Creating pets
        Pet dog = new Dog("Rocky", 2);
        Pet cat = new Cat("Simba", 3);
        Pet bird = new Bird("Mithu", 1);

        // Dog demo
        dog.showStatus();
        dog.makeSound();
        dog.feed();
        dog.play();
        dog.sleep();
        dog.showStatus();

        System.out.println();

        // Cat demo
        cat.showStatus();
        cat.makeSound();

        System.out.println();

        // Bird demo
        bird.showStatus();
        bird.makeSound();
    }
}
