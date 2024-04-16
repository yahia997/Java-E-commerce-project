public class Cart {
  // attributes
  private int customerId, nProducts;
  private Product[] products;

  // constructor
  public Cart(int customerId, int nProducts) {
    this.customerId = Math.abs(customerId); // to take absolute value 
    this.nProducts = Math.abs(nProducts); // to take absolute value 
    products = new Product[nProducts];
  }

  // getters and setters
  public int getCustomerId() {
    return customerId;
  }
  public int getNProducts() {
    return nProducts;
  }
  public Product[] getProducts() {
    return products;
  }
  
  public void setCustomerId(int newCustomerId) {
    customerId = Math.abs(newCustomerId);
  }
  public void setNProducts(int newNProducts) {
    nProducts = Math.abs(newNProducts);
  }
  public void setProducts(Product[] newProducts) {
    products = newProducts;
  }

  public void addProduct(Product p) {

    // add new product to the first null value
    for(int i = 0; i < products.length; i++) {

      if(products[i] == null) {
        products[i] = p;

        return; // to stop the function after adding the product
      }

    }
  }

  public void removeProduct(int index) {
    
    // to check if index in in the right range
    if(index < nProducts && index >= 0) {
      products[index] = null;
    }
  }

  public float calculatePrice() {
    float sum = 0;

    for(Product p : products) {
      if(p != null) {
        sum += p.getPrice();
      }
    }

    return sum;
  }

  public void placeOrder() {
    // place this order
    new Order(customerId, calculatePrice(), products);
  }
}
