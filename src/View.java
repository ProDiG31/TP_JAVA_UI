import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    public JPanel panel;
    public ViewControlleur Controlleur;

    public View(){

        this.setTitle("Manage Employes");
        this.Controlleur = new ViewControlleur(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MainPanel(this.Controlleur);

        this.getContentPane().add(panel);

        this.pack();
        this.setSize(400,600);
        this.setVisible(true);
    }


}
