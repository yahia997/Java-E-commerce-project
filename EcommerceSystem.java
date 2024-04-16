// This file contains most of GUI and objects

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EcommerceSystem implements ActionListener {
  // content for GUI (to make it global as we can access it in any function in the class)

  // Frames
  JFrame starterFrame, contentFrame;

  // Panels
  JPanel createUser, electronic, book, clothing, cartPanel, cartProductsPanel;
  
  // TextFields
  JTextField NameField, idField, addressField, nProduct;

  //buttons
  JButton createBtn;

  // titles
  JLabel title;

  // to store all customers data
  ArrayList<Customer> customers = new ArrayList<>();
  static Cart cart;

  // products arrays
  ElectronicProduct[] eProducts = {
    new ElectronicProduct(0, "Laptop", 20000, "Asus", 2),
    new ElectronicProduct(1, "Headphone", 500, "", 1),
    new ElectronicProduct(2, "mouse", 100, "hp", 1),
    new ElectronicProduct(3, "I phone 12", 30000, "I phone", 2),
  };
  BookProduct[] bProducts = {
    new BookProduct(4, "البداية و النهاية", 2500, "ابن كثير", "دار النشر 1"),
    new BookProduct(5, "زاد المعاد فى هدى خير العباد", 1500, "ابن القيم", "دار النشر 1"),
    new BookProduct(6, "صيد الخاطر", 200, "ابن الجوزيّ", "دار النشر 1"),
    new BookProduct(7, "منهاج المسلم", 200, "أبو بكر الجزائري", "دار النشر 1"),
  };
  ClothingProduct[] cProducts = {
    new ClothingProduct(8, "السبايدر", 100.001f, "M", "قطن"),
    new ClothingProduct(9, "T_Shirt polo", 400.99f, "L", "قطن"),
    new ClothingProduct(10, "Jeans", 600.5f, "34", "jeans"),
    new ClothingProduct(11, "socks", 99.99f, "44", "cotton"),
  };

  // constructor (initalizes GUI)
  public EcommerceSystem() {
    // create customer window GUI
    createUser = new JPanel();
    createUser.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    createUser.setPreferredSize(new Dimension(300, 400));
    createUser.setBackground(Color.LIGHT_GRAY);

    // title
    title = new JLabel("Welcome to E-commerce System !");
    title.setFont(new Font("Arial", Font.PLAIN, 16));

    // id textflied and its label
    JPanel idPanel = new JPanel();
    idPanel.setBackground(Color.LIGHT_GRAY);
    idPanel.setPreferredSize(new Dimension(300, 50));
    JLabel idLabel = new JLabel("ID :        ");
    idField = new JTextField("",17);
    idPanel.add(idLabel);
    idPanel.add(idField);

    // name textfield and its label
    JPanel namePanel = new JPanel();
    namePanel.setBackground(Color.LIGHT_GRAY);
    namePanel.setPreferredSize(new Dimension(300, 50));
    JLabel nameLabel = new JLabel("Name :   ");
    NameField = new JTextField("",17);
    namePanel.add(nameLabel);
    namePanel.add(NameField);

    // address textfield and its label
    JPanel addressPanel = new JPanel();
    addressPanel.setBackground(Color.LIGHT_GRAY);
    addressPanel.setPreferredSize(new Dimension(300, 50));
    JLabel addressLabel = new JLabel("Address : ");
    addressField = new JTextField("",17);
    addressPanel.add(addressLabel);
    addressPanel.add(addressField);

    // number of products textfield and its label
    JPanel nPanel = new JPanel();
    nPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    nPanel.setBackground(Color.LIGHT_GRAY);
    nPanel.setPreferredSize(new Dimension(300, 50));
    JLabel nLabel = new JLabel("How many products you want to add to your cart ?");
    nProduct = new JTextField("",17);
    nPanel.add(nLabel);
    nPanel.add(nProduct);

    // create customer button
    createBtn = new JButton("Create");
    createBtn.addActionListener(this);
    createBtn.setBackground(Color.DARK_GRAY);
    createBtn.setForeground(Color.white);

    // add components to the panel and frame
    createUser.add(title);
    createUser.add(idPanel);
    createUser.add(namePanel);
    createUser.add(addressPanel);
    createUser.add(nPanel);
    createUser.add(createBtn);

    starterFrame = new JFrame();
    starterFrame.add(createUser, BorderLayout.CENTER);
  
    starterFrame.pack();  
    starterFrame.setResizable(false);
    starterFrame.setVisible(true); 

    /////////////////////////////////////////////////////////////////////

    // products window
    contentFrame = new JFrame("Products");
    contentFrame.setLayout(new GridLayout(1, 4, 15, 0));

    // electronic products panel
    electronic = new JPanel();
    electronic.setLayout(new GridLayout(8, 1, 10, 10));
    JLabel eTitle = new JLabel("Electronic products");
    eTitle.setFont(new Font("Arial", Font.BOLD, 16));
    electronic.add(eTitle);

    // book products panel
    book = new JPanel();
    book = new JPanel(new GridLayout(8, 1, 10, 10));
    JLabel bTitle = new JLabel("Book products");
    bTitle.setFont(new Font("Arial", Font.BOLD, 16));
    book.add(bTitle);

    // clothing products panel
    clothing = new JPanel();
    clothing = new JPanel(new GridLayout(8, 1, 10, 10));
    JLabel cTitle = new JLabel("Clothing products");
    cTitle.setFont(new Font("Arial", Font.BOLD, 16));
    clothing.add(cTitle);

    // shopping cart panel
    cartPanel = new JPanel();
    cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
    
    // adding panels to the the frame
    contentFrame.add(electronic);
    contentFrame.add(book);
    contentFrame.add(clothing);
    contentFrame.add(cartPanel);
    contentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
    contentFrame.setVisible(false); // to make it hidden untill we create new customer
    

    // add proudtcs UI (electronic)
    for(ElectronicProduct p : eProducts) {
      JLabel labelName = new JLabel(p.getName());
      JLabel labelPrice = new JLabel(p.getPrice() + " $");
      JLabel labelId = new JLabel("#" + p.getProductId());

      JPanel product = new JPanel();
      product.setLayout(new GridLayout(2, 2));
      product.setBackground(Color.lightGray);
      product.setBorder(new EmptyBorder(0, 5, 0, 0));

      // what will happen when user clicks Add button
      JButton addToOrder = new JButton(new AbstractAction("Add") {
        @Override
        public void actionPerformed( ActionEvent e ) {
          cart.addProduct(p);
          updateCart(); // to update the cart UI
        } 
      });
      
      addToOrder.setBackground(Color.DARK_GRAY);
      addToOrder.setForeground(Color.white);

      // add content to product panel and then add this panel to main
      product.add(labelId);
      product.add(labelName);
      product.add(labelPrice);
      product.add(addToOrder);
      electronic.add(product);
    }


    // add proudtcs UI (books)
    for(BookProduct p : bProducts) {
      JLabel labelName = new JLabel(p.getName());
      JLabel labelPrice = new JLabel(p.getPrice() + " $");
      JLabel labelId = new JLabel("#" + p.getProductId());

      JPanel product = new JPanel();
      product.setLayout(new GridLayout(2, 2));
      product.setBackground(Color.lightGray);
      product.setBorder(new EmptyBorder(0, 5, 0, 0));

      // what will happen when user clicks Add button
      JButton addToOrder = new JButton(new AbstractAction("Add") {
        @Override
        public void actionPerformed( ActionEvent e ) {
          cart.addProduct(p);
          updateCart(); // to update the cart UI
        }
      });

      addToOrder.setBackground(Color.DARK_GRAY);
      addToOrder.setForeground(Color.white);

      // add content to product panel and then add this panel to main
      product.add(labelId);
      product.add(labelName);
      product.add(labelPrice);
      product.add(addToOrder);
      book.add(product);
    }

    // add proudtcs UI (clothing)
    for(ClothingProduct p : cProducts) {
      JLabel labelName = new JLabel(p.getName());
      JLabel labelPrice = new JLabel(p.getPrice() + " $");
      JLabel labelId = new JLabel("#" + p.getProductId());

      JPanel product = new JPanel();
      product.setLayout(new GridLayout(2, 2));
      product.setBackground(Color.lightGray);
      product.setBorder(new EmptyBorder(0, 5, 0, 0));

      // what will happen when user clicks Add button
      JButton addToOrder = new JButton(new AbstractAction("Add") {
        @Override
        public void actionPerformed( ActionEvent e ) {
          cart.addProduct(p);
          updateCart(); // to update the cart UI
        }
      });

      addToOrder.setBackground(Color.DARK_GRAY);
      addToOrder.setForeground(Color.white);

      // add content to product panel and then add this panel to main
      product.add(labelId);
      product.add(labelName);
      product.add(labelPrice);
      product.add(addToOrder);
      clothing.add(product);
    }
  }

  public static void main(String[] args) {

    // all appiclation starts from this point
    new EcommerceSystem();

  }

  // all button actions is here
  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == createBtn) {
      // create new customer, open products window and close create user window
      Customer newC = new Customer(Integer.parseInt(idField.getText()), NameField.getText(), addressField.getText());

      // add this customer to customers ArrayList
      customers.add(newC);

      // create new cart for this customer with specified number of products   
      cart = new Cart(newC.getCustomerId(), Integer.parseInt(nProduct.getText()));

      // to render cart content
      updateCart(); 

      // opens products page
      contentFrame.setVisible(true);

      // closes create customer page
      starterFrame.dispose();
    }
  }

  // renders cart UI
  public void updateCart() {
    // to remove old UI
    cartPanel.removeAll(); 

    // adding all new UI to cart component
    JLabel cartTile = new JLabel("Shopping Cart");
    cartTile.setFont(new Font("Arial", Font.BOLD, 16));
    cartPanel.add(cartTile);

    JLabel cartSize = new JLabel("Your cart size is " + cart.getNProducts());
    cartSize.setFont(new Font("Arial", Font.BOLD, 17));
    cartPanel.add(cartSize);

    cartProductsPanel = new JPanel();
    // to make it as grid layout with number of rows = number of products chosen by customer
    cartProductsPanel.setLayout(new GridLayout(cart.getNProducts(), 1, 10, 10));

    Product[] products = cart.getProducts();

    for(int i = 0; i < products.length; i++) {

      // to check if product is not removed from cart
      if(products[i] != null) {

        final int index = i; // as to not generate an error

        JPanel product = new JPanel();
        product.setLayout(new GridLayout(2, 2));
        product.setBackground(Color.lightGray);
        product.setBorder(new EmptyBorder(0, 5, 0, 0));

        JLabel pName = new JLabel(products[i].getName());
        JLabel pPrice = new JLabel(products[i].getPrice() + " $");
        JLabel pId = new JLabel("#" + products[i].getProductId());

        JButton delete = new JButton(new AbstractAction("remove") {
          @Override
          public void actionPerformed( ActionEvent e ) {

            // to remove product by its index from the cart
            cart.removeProduct(index);

            // update the new UI
            updateCart();
          }
        });

        delete.setBackground(Color.red);
        delete.setForeground(Color.white);
        
        product.add(pId);
        product.add(pName);
        product.add(pPrice);
        product.add(delete);
        cartProductsPanel.add(product);
      }
    }
    cartPanel.add(cartProductsPanel);

    // add total price GUI
    JLabel totalPriceLabel = new JLabel("Total price is " + cart.calculatePrice() + " $");
    totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 17));
    cartPanel.add(totalPriceLabel);

    // place order button
    JButton placeOrder = new JButton(new AbstractAction("placeOrder") {
      @Override
      public void actionPerformed( ActionEvent e ) {

        // will create object from class Order and open new window which contains all details
        cart.placeOrder(); 
      }
    });
    placeOrder.setBackground(Color.GREEN);
    cartPanel.add(placeOrder);

    // required to refresh the content
    cartPanel.revalidate();
    cartPanel.repaint();
  }
}