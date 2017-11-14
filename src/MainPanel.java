import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public JButton showButton;
    public JButton addButton;

    public MainPanel(ViewControlleur Controlleur){

        this.setLayout(new GridLayout(2,1));

        addButton  = new JButton("Add employes");
        showButton = new JButton("Display employes");

        addButton.addActionListener(Controlleur);
        showButton.addActionListener(Controlleur);

        this.add(addButton);
        this.add(showButton);

    }
}
