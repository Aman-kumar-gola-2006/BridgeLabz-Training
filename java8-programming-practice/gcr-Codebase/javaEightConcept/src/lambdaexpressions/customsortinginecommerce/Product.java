package lambdaexpressions.customsortinginecommerce;

public class Product {
	int id;
	String name;
	int price;
	double rating;
	double discount;

	public Product(int id, String name, int price, double rating, double discount) {
			this.id=id;
			this.name=name;
			this.price=price;
			this.rating=rating;
			this.discount=discount;
	}
	
	@Override
	public String toString() {
		  return name + " | Price: " + price +
	               " | Rating: " + rating +
	               " | Discount: " + discount;
	    }
	
}

