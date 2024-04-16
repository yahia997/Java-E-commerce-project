import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Order {

  // attributes
  private int customerId;
  private float totalPrice;
  private Product[] products;

  // order id is starting from 1 and increases by one when you place an order to be unique
  private static int orderId = 1;

  // for GUI
  JFrame detailsFrame;

  // methods

  // constructor
  public Order(int customerId, float totalPrice, Product[] products) {
    this.customerId = Math.abs(customerId);
    this.totalPrice = Math.abs(totalPrice);
    this.products = products;

    // open new window with order details
    detailsFrame = new JFrame("Order detials");

    // show details once you click place order button
    printOrderInfo();

    detailsFrame.setVisible(true);
    detailsFrame.pack();
  }

  // loads all details of order to GUI
  public void printOrderInfo() {
    JPanel detailsPanel = new JPanel();
    JPanel productsPanel = new JPanel();
    productsPanel.setLayout(new GridLayout(products.length, 1, 10, 10));
    productsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    detailsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

    JLabel title = new JLabel("Here is your order's summary : ");

    // order id is starting from 1 and increases by one when you place an order to be unique
    JLabel id = new JLabel("Order ID : " + (orderId++));

    JLabel customer = new JLabel("Customer ID : " + customerId);

    detailsPanel.add(title);
    detailsPanel.add(id);
    detailsPanel.add(customer);

    detailsPanel.add(new JLabel("Products : "));

    for(int i = 0; i < products.length; i++) {

      if(products[i] != null) {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));

        p.add(new JLabel(products[i].getName()));
        p.add(new JLabel("$ " + products[i].getPrice()));

        productsPanel.add(p);
      }

    }
    detailsPanel.add(productsPanel);

    JLabel totalPriceLabel = new JLabel("Total Price : $ " + totalPrice);
    detailsPanel.add(totalPriceLabel);

    detailsFrame.add(detailsPanel);
  }
}
