import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.Reader;
import java.util.Scanner;

public class MainGUI implements ActionListener{
    public JTextField textField;
    public JTextField textField2;

    public MainGUI(){
        JFrame frame = new JFrame();

        JLabel label = new JLabel("Admin Panel");
        JLabel label2 = new JLabel("Admin UserName:");
        JLabel label3 = new JLabel("Admin Password:");
        textField = new JTextField();
        textField2 = new JTextField();

        JPanel AdminPanel = new JPanel();
        AdminPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        AdminPanel.setLayout(new GridLayout(0,1));
        AdminPanel.add(label);
        AdminPanel.add(label2);
        AdminPanel.add(textField);
        AdminPanel.add(label3);
        AdminPanel.add(textField2);


        frame.add(AdminPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("COMP2000 Assessment");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new MainGUI();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
