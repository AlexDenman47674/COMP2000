import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



public class MainGUI implements ActionListener{

    //List of public accessable variables and elements within the GUI
    public Admin Admin1 = new Admin();
    public StockDatabase Stock = new StockDatabase();
    public Product Product1 = new Product();
    public Product Product2 = new Product();
    public Product Product3 = new Product();
    public JTextField textField;
    public JTextField textField2;
    public JTextField OrderIDInput;
    public JTextField OrderAmountInput;
    public JList StockID;
    public JList StockAmount;
    public JTextField StockControlID;
    public JTextField StockControlAmount;
    public JTextField ProductIDInput;
    public JTextArea ShoppingCart;
    public JTextField Total;
    public double TotalCost;
    public JTextArea ReceiptItems;
    public Receipt Receipt1 = new Receipt();
    public JTextField ReceiptTotal;
    public JLabel ReceiptPaymentMethod;
    public JLabel ReceiptDate;
    public JLabel ReceiptChange;


    //GUI Method
    public MainGUI(){
        try{
            //Reads Admin details from text file at destination Assessment 1 : Admin.txt
            File AdminDetails = new File("C:\\Users\\Alex\\Desktop\\COMP2000\\Assessment1\\Admin.txt");
            Scanner myReader = new Scanner(AdminDetails);

            //Stores Admin details in the Admin Class
            Admin1.setLoginName(myReader.nextLine());
            Admin1.setPassword(myReader.nextLine());
            Admin1.setID(myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException x){
            System.out.println("An error occurred");
            x.printStackTrace();
        }

        try{
            //Reads Stock data from the Database file
            File StockDatabase = new File("D:\\Github\\COMP2000\\COMP2000Assessment\\SRC\\StockDatabase.txt");
            Scanner myReader = new Scanner(StockDatabase);
            for (int i = 0; i < 2; i++) {
                Stock.setProductID(myReader.nextLine(), i);
                Stock.setProductRemaining(myReader.nextLine(), i);
            }

            myReader.close();
        } catch (FileNotFoundException x){
            System.out.println("An error occurred");
            x.printStackTrace();
        }
        try{
            //Reads Product data
            File Products = new File("D:\\Github\\COMP2000\\COMP2000Assessment\\SRC\\Products.txt");
            Scanner myReader = new Scanner(Products);
            //Stores Product data in three hard coded Product Classes, if more Products were to be added, more classes would be needed
            Product1.setID(myReader.nextLine());
            Product1.setName(myReader.nextLine());
            Product1.setPrice(Double.parseDouble(myReader.nextLine()));
            Product2.setID(myReader.nextLine());
            Product2.setName(myReader.nextLine());
            Product2.setPrice(Double.parseDouble(myReader.nextLine()));
            Product3.setID(myReader.nextLine());
            Product3.setName(myReader.nextLine());
            Product3.setPrice(Double.parseDouble(myReader.nextLine()));


            myReader.close();
        } catch (FileNotFoundException x){
            System.out.println("An error occurred");
            x.printStackTrace();
        }


        //Creates the frame for the GUI to be built upon
        JFrame frame = new JFrame();

        //Declaring elements for the Admin Panel of the GUI
        JLabel label = new JLabel("Admin Panel");
        JLabel label2 = new JLabel("Admin UserName:");
        JLabel label3 = new JLabel("Admin Password:");
        JLabel label4 = new JLabel("Send Order");
        JLabel OrderID = new JLabel("Product ID");
        JLabel OrderAmount = new JLabel("Amount");
        textField = new JTextField(Admin1.LoginName);
        textField2 = new JTextField(Admin1.Password);
        OrderIDInput = new JTextField();
        OrderAmountInput = new JTextField();
        JButton Order = new JButton("Place Order");
        //Adds an Action Listener that runs a section of code when the Order Button is pressed
        Order.addActionListener(this);

        //Formats the elements on the Admin Panel
        JPanel AdminPanel = new JPanel();
        AdminPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        AdminPanel.setLayout(new GridLayout(0,1));
        AdminPanel.add(label);
        AdminPanel.add(label2);
        AdminPanel.add(textField);
        AdminPanel.add(label3);
        AdminPanel.add(textField2);
        AdminPanel.add(label4);
        AdminPanel.add(OrderID);
        AdminPanel.add(OrderIDInput);
        AdminPanel.add(OrderAmount);
        AdminPanel.add(OrderAmountInput);
        AdminPanel.add(Order);

        //Declaring elements for the Stock Database Panel of the GUI
        JLabel label5 = new JLabel("Stock Database Panel");
        JLabel IDLabel = new JLabel("Product ID");
        JLabel AmountLabel = new JLabel("Product Amount");
        JLabel label6 = new JLabel("Controls");
        StockID = new JList(Stock.getProductID());
        StockAmount = new JList(Stock.getProductRemaining());
        JScrollPane StockIDScroll = new JScrollPane(StockID);
        StockIDScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollPane StockAmountScroll = new JScrollPane(StockAmount);
        StockAmountScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JButton AddToStock = new JButton("Add");
        JButton RemoveFromStock = new JButton("Remove");
        JButton EditStock = new JButton("Edit");
        JLabel label7 = new JLabel("Product ID");
        JLabel label8 = new JLabel("Product Amount");
        StockControlAmount = new JTextField();
        StockControlID = new JTextField();


        //Formats the elements on the Stock Panel
        JPanel StockPanel = new JPanel();
        StockPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        StockPanel.setLayout(new GridLayout(0,1));
        StockPanel.add(label5);
        StockPanel.add(IDLabel);
        StockPanel.add(StockIDScroll);
        StockPanel.add(AmountLabel);
        StockPanel.add(StockAmountScroll);
        StockPanel.add(label6);
        StockPanel.add(label7);
        StockPanel.add(StockControlID);
        StockPanel.add(label8);
        StockPanel.add(StockControlAmount);
        StockPanel.add(AddToStock);
        StockPanel.add(RemoveFromStock);
        StockPanel.add(EditStock);


        //Declares elements for the Kiosk Panel
        JLabel label9 = new JLabel("Kiosk Panel");
        JLabel ItemIDLabel = new JLabel("Scan item ID");
        ProductIDInput = new JTextField();
        JLabel ShoppingListLabel = new JLabel("Current Items");
        ShoppingCart = new JTextArea();
        JScrollPane ShoppingScroll = new JScrollPane(ShoppingCart);
        ShoppingScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JButton AddToCart = new JButton("Add to Cart");
        JLabel FinalTotalLabel = new JLabel("Final Total");
        Total = new JTextField();
        JButton CheckoutButtonCash = new JButton("Checkout with Cash");
        JButton CheckoutButtonCard = new JButton("Checkout with Card");


        //Formats the elements on the Kiosk Panel
        JPanel KioskPanel = new JPanel();
        KioskPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        KioskPanel.setLayout(new GridLayout(0,1));
        KioskPanel.add(label9);
        KioskPanel.add(ProductIDInput);
        KioskPanel.add(ItemIDLabel);
        KioskPanel.add(AddToCart);
        KioskPanel.add(ShoppingListLabel);
        KioskPanel.add(ShoppingScroll);
        KioskPanel.add(FinalTotalLabel);
        KioskPanel.add(Total);
        KioskPanel.add(CheckoutButtonCash);
        KioskPanel.add(CheckoutButtonCard);


        //Declares elements for the Receipt Panel
        JLabel label10 = new JLabel("Receipt Panel");
        JLabel ReceiptCompanyName = new JLabel("Less-Co. Superstores");
        ReceiptDate = new JLabel("Current Date Here");
        ReceiptItems = new JTextArea();
        JScrollPane ReceiptScroll = new JScrollPane(ReceiptItems);
        ReceiptScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ReceiptTotal = new JTextField();
        ReceiptPaymentMethod = new JLabel("Payment Method");
        ReceiptChange = new JLabel("Change Owed");

        //Formats the elements on the Receipt Panel
        JPanel ReceiptPanel = new JPanel();
        ReceiptPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        ReceiptPanel.setLayout(new GridLayout(0,1));
        ReceiptPanel.add(label10);
        ReceiptPanel.add(ReceiptCompanyName);
        ReceiptPanel.add(ReceiptDate);
        ReceiptPanel.add(ReceiptScroll);
        ReceiptPanel.add(ReceiptTotal);
        ReceiptPanel.add(ReceiptPaymentMethod);
        ReceiptPanel.add(ReceiptChange);

        //Action Listener connected to the Checkout with Card Button
        CheckoutButtonCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creates a popup message that the user must agree to to proceed
                int input = JOptionPane.showConfirmDialog(null, "This is an automated message from the Bank of ******. Are you sure you wish to use card?");
                // 0=yes, 1=no, 2=cancel
                System.out.println(input);
                if (input==0){
                    //Proceed to checkout
                    Receipt1.setPaymentMethod("Card");
                    Checkout();
                }
            }
        });

        //Action Listener connected to the Checkout With Cash Button
        CheckoutButtonCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receipt1.setPaymentMethod("Cash");
                //Calculates change based on common British Notes (5,10,20,50, etc.)
                if (TotalCost < 5){
                    Receipt1.setChangeOwed(5-TotalCost);
                } else if (TotalCost <10 & TotalCost >5){
                    Receipt1.setChangeOwed(10-TotalCost);
                }else if (TotalCost <20 & TotalCost >10){
                    Receipt1.setChangeOwed(20-TotalCost);
                }else if (TotalCost <50 & TotalCost >20){
                    Receipt1.setChangeOwed(50-TotalCost);
                }else if (TotalCost <100 & TotalCost >50){
                    Receipt1.setChangeOwed(100-TotalCost);
                }else{
                    Receipt1.setChangeOwed(200-TotalCost);
                }
                Checkout();
            }
        });

        //Action Listener connected to the Add to Cart Button
        AddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CurrentProductID;
                CurrentProductID = ProductIDInput.getText();
                //Depending on the Product being added, appropriate data is input into the Shopping Cart
                if (CurrentProductID.equals("1")){
                    TotalCost = TotalCost + Product1.getPrice();
                    ShoppingCart.setText(ShoppingCart.getText() + Product1.getName() + " : " + Product1.getPrice() + "\n");

                } else if (CurrentProductID.equals("2")){
                    TotalCost = TotalCost + Product2.getPrice();
                    ShoppingCart.setText(ShoppingCart.getText() + Product2.getName() + " : " + Product2.getPrice() + "\n");
                }else if (CurrentProductID.equals("3")){
                    TotalCost = TotalCost + Product3.getPrice();
                    ShoppingCart.setText(ShoppingCart.getText() + Product3.getName() + " : " + Product3.getPrice() + "\n");
                }

                String T = String.valueOf(TotalCost);
                Total.setText(T);
            }
        });

        //Action Listener connected to the Add to Stock Button
        AddToStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] OldProductID;
                String[] OldProductAmounts;
                OldProductID=Stock.getProductID();
                OldProductAmounts=Stock.getProductRemaining();
                try{
                    //The Current items are rewritten into  the file and then followed by the latest item after the loop has ended
                    FileWriter myWriter = new FileWriter("StockDatabase.txt");
                    for (int i = 0; i < OldProductID.length; i++) {
                        myWriter.write(OldProductID[i] + "\r");
                        myWriter.write(OldProductAmounts[i] + "\r");
                    }
                    myWriter.write(StockControlID.getText() + "\r");
                    myWriter.write(StockControlAmount.getText());

                    myWriter.close();
                }catch (IOException y){
                    System.out.println("An error occurred");
                    y.printStackTrace();
                }
            }
        });

        //Action Listener connected to the Remove from Stock Button
        RemoveFromStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] OldProductID;
                String[] OldProductAmounts;
                OldProductID=Stock.getProductID();
                OldProductAmounts=Stock.getProductRemaining();
                try{
                    FileWriter myWriter = new FileWriter("StockDatabase.txt");
                    for (int i = 0; i < OldProductID.length; i++) {
                        //An IF statement is used to detect the removed Product using Product ID's
                        if(OldProductID[i].equals(StockControlID.getText()) || OldProductAmounts[i].equals(StockControlAmount.getText())){
                            System.out.println("Stock Removed");
                        } else {
                            myWriter.write(OldProductID[i] + "\r");
                            myWriter.write(OldProductAmounts[i] + "\r");
                        }

                    }

                    myWriter.close();
                }catch (IOException y){
                    System.out.println("An error occurred");
                    y.printStackTrace();
                }
            }
        });

        //Action Listener connected to the Edit Stock Button
        EditStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] OldProductID;
                String[] OldProductAmounts;
                OldProductID=Stock.getProductID();
                OldProductAmounts=Stock.getProductRemaining();
                try{
                    FileWriter myWriter = new FileWriter("StockDatabase.txt");
                    for (int i = 0; i < OldProductID.length; i++) {
                        if(OldProductID[i].equals(StockControlID.getText())){
                            myWriter.write(OldProductID[i] + "\r");
                            myWriter.write(StockControlAmount.getText() + "\r");
                        } else {
                            myWriter.write(OldProductID[i] + "\r");
                            myWriter.write(OldProductAmounts[i] + "\r");
                        }

                    }

                    myWriter.close();
                }catch (IOException y){
                    System.out.println("An error occurred");
                    y.printStackTrace();
                }
            }
        });


        //The panels are each added to the frame and formatted with a location.
        frame.add(AdminPanel, BorderLayout.WEST);
        frame.add(StockPanel, BorderLayout.CENTER);
        frame.add(KioskPanel, BorderLayout.EAST);
        frame.add(ReceiptPanel,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("COMP2000 Assessment");
        frame.pack();
        frame.setVisible(true);
    }

    //Private method that produces the Receipt
    private void Checkout() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime CurrentTime = LocalDateTime.now();
        ReceiptDate.setText(String.valueOf(CurrentTime));
        Receipt1.setTotal(TotalCost);
        ReceiptTotal.setText(String.valueOf(Receipt1.Total));
        ReceiptChange.setText(String.valueOf(Receipt1.getChangeOwed()));
        ReceiptPaymentMethod.setText(Receipt1.getPaymentMethod());
        ReceiptItems.setText(ShoppingCart.getText());

    }

    public static void main(String[] args){
        new MainGUI();


    }


    //Action Listener connected to the Order Button
    public void actionPerformed(ActionEvent e) {
        try{
            FileWriter myWriter = new FileWriter("Orders.txt");
            myWriter.write(OrderIDInput.getText() + "\r");
            myWriter.write(OrderAmountInput.getText());
            myWriter.close();
        }catch (IOException y){
            System.out.println("An error occurred");
            y.printStackTrace();
        }
    }
}
