public class Customer {
  // attributes
  int customerID; // positive else take absolute
  String name;
  String address;

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

  public boolean setCustomerId(int newId) {
    customerID = Math.abs(newId);
    return true;
  }
  public boolean setName(String newName) {
    name = newName;
    return true;
  }
  public boolean setAddress(String newAddress) {
    address = newAddress;
    return true;
  }
}
