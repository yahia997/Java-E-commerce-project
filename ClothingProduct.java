public class ClothingProduct extends Product {
  // attributes
  private String size, fabric;

  // constructor
  public ClothingProduct(int productID, String name, float price, String size, String fabric) {
    super(productID, name, price);
    this.size = size;
    this.fabric = fabric;
  }

  // getters and setters
  public String getSize() {
    return size;
  }
  public String getFabric() {
    return fabric;
  }

  public void setSize(String newSize) {
    size = newSize;
  }
  public void setFabric(String newFabric) {
    fabric = newFabric;
  }
}
