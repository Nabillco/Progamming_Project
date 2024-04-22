package Oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField idd,namme,adree,numm;
    private JButton coo;

    public Main() {
        setTitle("Welcome to the E-Commerce System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 5, 5));

        panel.add(new JLabel("ID:"));
        idd = new JTextField();
        panel.add(idd);

        panel.add(new JLabel("Name:"));
        namme = new JTextField();
        panel.add(namme);

        panel.add(new JLabel("Address:"));
        adree = new JTextField();
        panel.add(adree);

        panel.add(new JLabel("Number of Orders:"));
        numm = new JTextField();
        panel.add(numm);

        coo = new JButton("Continue");
        coo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idd.getText());
                String name = namme.getText();
                String address = numm.getText();
                int cntr = Integer.parseInt(numm.getText());
                showin(id, name, address, cntr);
            }
        });
        panel.add(coo);

        add(panel);
        setVisible(true);
    }
    private void showin(int id, String name, String adre, int n) {
        JFrame ans = new JFrame("Shopping Cart");
        ans.setSize(600, 400);
        ans.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        Cart cart = new Cart(id);
        for (int i = 0; i < n; i++) {
            String t = (String) JOptionPane.showInputDialog(ans, "Select product type:", "Product Selection", JOptionPane.PLAIN_MESSAGE, null,new String[]{"Smartphone", "Clothes", "Book"}, "Smartphone");

            if (t!=null) {
                if(t=="Smartphone")
                {
                    String br = JOptionPane.showInputDialog("Enter brand:");
                    int proid = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    double pri = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));
                    int warr = Integer.parseInt(JOptionPane.showInputDialog("Enter warranty period:"));
                    Elecprod elecc = new Elecprod(proid, "Smartphone", pri, br, warr);
                    cart.addProd(elecc);
                }
                else if(t=="Clothes")
                {
                    String nnnn = JOptionPane.showInputDialog("Enter name:"),
                            sz = JOptionPane.showInputDialog("Enter size:"),
                            fab = JOptionPane.showInputDialog("Enter fabric:");
                    int proid = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    double pri = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));
                    Clothprod clott=new Clothprod(proid, nnnn, pri, sz, fab);
                    cart.addProd(clott);
                }
                else if(t=="Book")
                {
                    String aut = JOptionPane.showInputDialog("Enter author:"),
                            publi = JOptionPane.showInputDialog("Enter publisher:");
                    int proid = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    double pri = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));
                    Bookprod boopr = new Bookprod(proid, "Book", pri, aut, publi);
                    cart.addProd(boopr);
                }
            }
        }

        if (cart.getProd() > 0) {
            double cntr = cart.calc();
            int t = JOptionPane.showConfirmDialog(ans, "Would you like to place the order?", "Place Order", JOptionPane.YES_NO_OPTION);

            if (t == JOptionPane.YES_OPTION) {
                String ss = cart.gerord(name, adre, cntr);
                JOptionPane.showMessageDialog(ans, ss);
                JOptionPane.showMessageDialog(ans, "Thank you!");
            }
            else {
                int x=JOptionPane.showConfirmDialog(ans,"Would you like to add a new order?","Add New Order",JOptionPane.YES_NO_OPTION);
                if (x==JOptionPane.YES_OPTION)showin(id, name, adre, n);
            }
        }
        else JOptionPane.showMessageDialog(ans, "No products added to the cart.");


        ans.add(panel);

    }

    public static void main(String[] args) {
        new Main();
    }
}
