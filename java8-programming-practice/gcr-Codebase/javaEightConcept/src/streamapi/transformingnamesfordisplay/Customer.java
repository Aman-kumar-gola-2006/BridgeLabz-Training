package streamapi.transformingnamesfordisplay;

public class Customer {

    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for customer id
    public int getId() {
        return id;
    }

    // Getter for customer name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }
}
