public class Product {
  // attributes
  int productID; // positive else take absolute
  String name;
  float price; // positive else take absolute
  
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

  public boolean setProductId(int newId) {
    productID = Math.abs(newId);
    return true;
  }
  public boolean setName(String newName) {
    name = newName;
    return true;
  }
  public boolean setPrice(float newPrice) {
    price = Math.abs(newPrice);
    return true;
  }
}
