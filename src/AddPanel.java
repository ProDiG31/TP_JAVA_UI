import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {

    private String[] roleListe = {
            "Manutention",
            "Manutention A Risque",
            "Production",
            "Production A Risque",
            "Representant"
    };

    public JComboBox<String> roleCombo;
    public JTextField nameTextField;
    public JTextField lastnameTextField;
    public JSpinner ageSpinner;
    public JSpinner yearSpinner;
    public JSpinner uniteSpinner;

    public AddPanel(ViewControlleur Controlleur){

        this.setLayout(new GridLayout(7,2));

        roleCombo = new JComboBox(roleListe);
        JLabel roleLabel = new JLabel("Rôle");
        nameTextField = new JTextField();
        JLabel nameLabel = new JLabel("Prenom");
        lastnameTextField = new JTextField();
        JLabel LastnameLabel = new JLabel("Nom");
        ageSpinner = new JSpinner();
        JLabel ageLabel = new JLabel("Age");
        yearSpinner = new JSpinner();
        JLabel yearLabel = new JLabel("Année d'entrée");
        uniteSpinner = new JSpinner();
        JLabel UniteLabel = new JLabel("Unite");
        JButton backButton = new JButton("Back");
        JButton submitButton = new JButton("Submit");

        backButton.addActionListener(Controlleur);
        submitButton.addActionListener(Controlleur);

        this.add(roleLabel);
        this.add(roleCombo);

        this.add(nameLabel);
        this.add(nameTextField);

        this.add(LastnameLabel);
        this.add(lastnameTextField);

        this.add(ageLabel);
        this.add(ageSpinner);

        this.add(yearLabel);
        this.add(yearSpinner);

        this.add(UniteLabel);
        this.add(uniteSpinner);

        this.add(backButton);
        this.add(submitButton);

    }
}
