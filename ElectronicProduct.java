public class ElectronicProduct extends Product {
  // attributes
  // productID, name, price from "Product" class
  private String brand;
  private int warrantyPeriod;// positive else take absolute

  // methods

  // constructor
  public ElectronicProduct(int productID, String name, float price, String brand, int warrantyPeriod) {
    super(productID, name, price);
    this.brand = brand;
    this.warrantyPeriod = Math.abs(warrantyPeriod);
  }

  // getter & setter
  // + getter and setter from "Product" class
  public String getBrand() {
    return brand;
  }
  public int getWarrantyPeriod() {
    return warrantyPeriod;
  }

  public void setBrand(String newBrand) {
    brand = newBrand;
  }
  public void setWarrantyPeriod(int newWarrantyPeriod) {
    warrantyPeriod = Math.abs(newWarrantyPeriod);
  }
}
