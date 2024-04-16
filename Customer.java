public class Customer {
  // attributes
  private int customerID; // positive else take absolute
  private String name;
  private String address;

  // methods

  // constructor
  public Customer(int customerID, String name, String address) {
    this.customerID = Math.abs(customerID);
    this.name = name;
    this.address = address;
  }

  // getter & setter
  public int getCustomerId() {
    return customerID;
  }
  public String getName() {
    return name;
  }
  public String getAddress() {
    return address;
  }

  public void setCustomerId(int newId) {
    customerID = Math.abs(newId);
  }
  public void setName(String newName) {
    name = newName;
  }
  public void setAddress(String newAddress) {
    address = newAddress;
  }
}
