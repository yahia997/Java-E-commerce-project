public class BookProduct extends Product {
  String author, publisher;

  public BookProduct(int productID, String name, float price, String author, String publisher) {
    super(productID, name, price);
    this.author = author;
    this.publisher = publisher;
  }

  public String getAuthor() {
    return author;
  }
  public String getPublisher() {
    return publisher;
  }

  public void setAuthor(String newAuthor) {
    author = newAuthor;
  }
  public void setPublisher(String newPublisher) {
    publisher = newPublisher;
  }
}
