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
    public JTextField textField;
    public JTextField textField2;
    public JTextField OrderIDInput;
    public JTextField OrderAmountInput;


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


        frame.add(AdminPanel, BorderLayout.WEST);
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
