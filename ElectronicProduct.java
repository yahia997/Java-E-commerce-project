public class ElectronicProduct extends Product {
  // attributes
  // productID, name, price from "Product" class
  String brand;
  int warrantyPeriod;// positive else take absolute

  // methods

  // constructor
  public ElectronicProduct(int productID, String name, float price, String brand, int warrantyPeriod) {
    super(productID, name, price);
    this.brand = brand;
    this.warrantyPeriod = warrantyPeriod;
  }

  // getter & setter
  // + getter and setter from "Product" class
  public String getBrand() {
    return brand;
  }
  public int getWarrantyPeriod() {
    return warrantyPeriod;
  }

  public boolean setBrand(String newBrand) {
    brand = newBrand;
    return true;
  }
  public boolean setWarrantyPeriod(int newWarrantyPeriod) {
    warrantyPeriod = Math.abs(newWarrantyPeriod);
    return true;
  }
}
