import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

// -------------------------------------------
// Custom Annotation
// -------------------------------------------
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface DeveloperInfo {
    String developer();
    String version();
}

// -------------------------------------------
// Interfaces
// -------------------------------------------
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// -------------------------------------------
// Base Class - Bird
// -------------------------------------------
@DeveloperInfo(developer = "EcoWing Dev Team", version = "1.0")
class Bird {
    private String id;
    private String name;
    private String species;

    public Bird(String id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public String getId() { return id; }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public String getDetails() {
        return "ID: " + id + " | Name: " + name + " | Species: " + species;
    }
}

// -------------------------------------------
// Bird Sub-Classes
// -------------------------------------------
class Eagle extends Bird implements Flyable {
    public Eagle(String id, String name) {
        super(id, name, "Eagle");
    }
    public void fly() {
        System.out.println("Eagle soars high in the sky.");
    }
}

class Sparrow extends Bird implements Flyable {
    public Sparrow(String id, String name) {
        super(id, name, "Sparrow");
    }
    public void fly() {
        System.out.println("Sparrow flutters quickly.");
    }
}

class Duck extends Bird implements Flyable, Swimmable {
    public Duck(String id, String name) {
        super(id, name, "Duck");
    }
    public void fly() { System.out.println("Duck flies short distance."); }
    public void swim() { System.out.println("Duck swims smoothly."); }
}

class Penguin extends Bird implements Swimmable {
    public Penguin(String id, String name) {
        super(id, name, "Penguin");
    }
    public void swim() {
        System.out.println("Penguin swims fast underwater.");
    }
}

class Seagull extends Bird implements Flyable, Swimmable {
    public Seagull(String id, String name) {
        super(id, name, "Seagull");
    }
    public void fly() { System.out.println("Seagull glides above ocean."); }
    public void swim() { System.out.println("Seagull floats on the water."); }
}

class Ostrich extends Bird {
    public Ostrich(String id, String name) {
        super(id, name, "Ostrich");
    }
}

// -------------------------------------------
// Main Sanctuary System
// -------------------------------------------
public class BirdSanctuary {

    static ArrayList<Bird> sanctuary = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        printDeveloperInfo();

        while (true) {
            System.out.println("\n--- EcoWing Bird Sanctuary ---");
            System.out.println("1. Add Bird");
            System.out.println("2. Display All Birds");
            System.out.println("3. Display Flying Birds");
            System.out.println("4. Display Swimming Birds");
            System.out.println("5. Display Both (Fly + Swim)");
            System.out.println("6. Delete Bird by ID");
            System.out.println("7. Sanctuary Report");
            System.out.println("8. Reflection Demo: Dynamic Method Call");
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 9) break;

            switch (ch) {
                case 1: addBird(); break;
                case 2: showAll(); break;
                case 3: showFlying(); break;
                case 4: showSwimming(); break;
                case 5: showBoth(); break;
                case 6: deleteBird(); break;
                case 7: sanctuaryReport(); break;
                case 8: reflectionDemo(); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // Add a new bird
    static void addBird() {
        System.out.println("Choose Bird Type:");
        System.out.println("1. Eagle\n2. Sparrow\n3. Duck\n4. Penguin\n5. Seagull\n6. Ostrich");
        int t = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Bird ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Bird Name: ");
        String name = sc.nextLine();

        Bird b = null;

        switch (t) {
            case 1: b = new Eagle(id, name); break;
            case 2: b = new Sparrow(id, name); break;
            case 3: b = new Duck(id, name); break;
            case 4: b = new Penguin(id, name); break;
            case 5: b = new Seagull(id, name); break;
            case 6: b = new Ostrich(id, name); break;
        }

        sanctuary.add(b);
        System.out.println("Bird added successfully.");
    }

    static void showAll() {
        for (Bird b : sanctuary) {
            System.out.println(b.getDetails());
        }
    }

    static void showFlying() {
        for (Bird b : sanctuary) {
            if (b instanceof Flyable) {
                System.out.println(b.getDetails());
                ((Flyable) b).fly();
            }
        }
    }

    static void showSwimming() {
        for (Bird b : sanctuary) {
            if (b instanceof Swimmable) {
                System.out.println(b.getDetails());
                ((Swimmable) b).swim();
            }
        }
    }

    static void showBoth() {
        for (Bird b : sanctuary) {
            if (b instanceof Flyable && b instanceof Swimmable) {
                System.out.println(b.getDetails());
            }
        }
    }

    static void deleteBird() {
        System.out.print("Enter Bird ID to delete: ");
        String id = sc.nextLine();

        sanctuary.removeIf(b -> b.getId().equals(id));
        System.out.println("Bird deleted if ID existed.");
    }

    static void sanctuaryReport() {
        int flyers = 0, swimmers = 0, both = 0, neither = 0;

        for (Bird b : sanctuary) {
            boolean f = b instanceof Flyable;
            boolean s = b instanceof Swimmable;

            if (f && s) both++;
            else if (f) flyers++;
            else if (s) swimmers++;
            else neither++;
        }

        System.out.println("Flyers: " + flyers);
        System.out.println("Swimmers: " + swimmers);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + neither);
    }

    // -------------------------------------------
    // Reflection + Annotation Demo
    // -------------------------------------------
    static void printDeveloperInfo() {
        try {
            Class<?> cls = Bird.class;
            DeveloperInfo info = cls.getAnnotation(DeveloperInfo.class);

            System.out.println("=== Bird Sanctuary Metadata ===");
            System.out.println("Developer: " + info.developer());
            System.out.println("Version: " + info.version());
            System.out.println("===============================");
        } catch (Exception e) { }
    }

    static void reflectionDemo() {
        try {
            System.out.println("Running Reflection Demo... Calling eat() dynamically");

            if (sanctuary.isEmpty()) {
                System.out.println("No birds available.");
                return;
            }

            System.out.print("Enter Bird Index: ");
            int idx = sc.nextInt();
            Bird b = sanctuary.get(idx);

            Method m = b.getClass().getMethod("eat");
            m.invoke(b);

        } catch (Exception e) {
            System.out.println("Reflection Error: " + e.getMessage());
        }
    }
}
