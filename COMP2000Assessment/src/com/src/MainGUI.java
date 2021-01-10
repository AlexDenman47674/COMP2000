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



public class MainGUI implements ActionListener{
    public Admin Admin1 = new Admin();
    public StockDatabase Stock = new StockDatabase();
    public JTextField textField;
    public JTextField textField2;
    public JTextField OrderIDInput;
    public JTextField OrderAmountInput;
    public JList StockID;
    public JList StockAmount;
    public JTextField StockControlID;
    public JTextField StockControlAmount;


    public MainGUI(){
        try{
            File AdminDetails = new File("C:\\Users\\Alex\\Desktop\\COMP2000\\Assessment1\\Admin.txt");
            Scanner myReader = new Scanner(AdminDetails);
            Admin1.setLoginName(myReader.nextLine());
            Admin1.setPassword(myReader.nextLine());
            Admin1.setID(myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException x){
            System.out.println("An error occurred");
            x.printStackTrace();
        }

        try{
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


        JFrame frame = new JFrame();

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
        Order.addActionListener(this);

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

        JLabel label5 = new JLabel("Stock Database Panel");
        JLabel IDLabel = new JLabel("Product ID");
        JLabel AmountLabel = new JLabel("Product Amount");
        JLabel label6 = new JLabel("Controls");
        StockID = new JList(Stock.getProductID());
        StockAmount = new JList(Stock.getProductRemaining());
        JButton AddToStock = new JButton("Add");
        JButton RemoveFromStock = new JButton("Remove");
        JButton EditStock = new JButton("Edit");
        JLabel label7 = new JLabel("Product ID");
        JLabel label8 = new JLabel("Product Amount");
        StockControlAmount = new JTextField();
        StockControlID = new JTextField();


        JPanel StockPanel = new JPanel();
        StockPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        StockPanel.setLayout(new GridLayout(0,1));
        StockPanel.add(label5);
        StockPanel.add(IDLabel);
        StockPanel.add(StockID);
        StockPanel.add(AmountLabel);
        StockPanel.add(StockAmount);
        StockPanel.add(label6);
        StockPanel.add(label7);
        StockPanel.add(StockControlID);
        StockPanel.add(label8);
        StockPanel.add(StockControlAmount);
        StockPanel.add(AddToStock);
        StockPanel.add(RemoveFromStock);
        StockPanel.add(EditStock);

        AddToStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] OldProductID;
                String[] OldProductAmounts;
                OldProductID=Stock.getProductID();
                OldProductAmounts=Stock.getProductRemaining();
                try{
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


        frame.add(AdminPanel, BorderLayout.WEST);
        frame.add(StockPanel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("COMP2000 Assessment");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new MainGUI();


    }


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
