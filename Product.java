public class Product {
  // attributes
  private int productID; // positive else take absolute
  private String name;
  private float price; // positive else take absolute
  
  // methods

  // constructor
  public Product(int productID, String name, float price) {
    this.productID = Math.abs(productID);
    this.name = name;
    this.price = Math.abs(price);
  }

  // getter & setter
  public int getProductId() {
    return productID;
  }
  public String getName() {
    return name;
  }
  public float getPrice() {
    return price;
  }

  public void setProductId(int newId) {
    productID = Math.abs(newId);
  }
  public void setName(String newName) {
    name = newName;
  }
  public void setPrice(float newPrice) {
    price = Math.abs(newPrice);
  }
}
