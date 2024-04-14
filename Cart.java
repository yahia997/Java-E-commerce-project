public class Cart {
  public int customerId, nProducts, lastIndex = 0;
  public Product[] products;

  public Cart(int customerId, int nProducts) {
    this.customerId = customerId;
    this.nProducts = nProducts;
    products = new Product[nProducts];
  }

  public int getCustomerId() {
    return customerId;
  }
  public int getNProducts() {
    return nProducts;
  }
  public Product[] getProducts() {
    return products;
  }
  
  public boolean setCustomerId(int newCustomerId) {
    customerId = newCustomerId;
    return true;
  }
  public boolean setNProducts(int newNProducts) {
    nProducts = newNProducts;
    return true;
  }
  public boolean setProducts(Product[] newProducts) {
    products = newProducts;
    return true;
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
