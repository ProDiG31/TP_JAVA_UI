import better.domain.*;
import better.service.Personnel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControlleur implements ActionListener {

    private View vue;
    public Personnel personnel;

    public ViewControlleur(View vue) {

        this.personnel = new Personnel();
        this.vue = vue;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        JPanel newPanel;

        switch (source.getText()){

            case ("Add employes"):
                System.out.println("Add detected");
                MAJview(new AddPanel(this));
                break;

            case ("Display employes"):
                System.out.println("Display detected");
                MAJview(new DisplayPanel(this));
                break;

            case ("Back"):
                System.out.println("Back detected");
                MAJview(new MainPanel(this));
                break;
            case ("Submit"):
                if (addEmploye()){
                    MAJview(new MainPanel(this));
                }
                break;
            default :
                break;
        }
    }

    public void MAJview(JPanel newPanel){
        this.vue.getContentPane().removeAll();
        this.vue.getContentPane().add(newPanel);
        this.vue.panel = newPanel;
        this.vue.revalidate();
        this.vue.repaint();
    }

    public boolean addEmploye(){
        AddPanel content = (AddPanel) this.vue.panel;

        String role = String.valueOf(content.roleCombo.getSelectedItem());
        String prenom =  content.nameTextField.getText();
        String nom = content.lastnameTextField.getText();
        int age = (int) content.ageSpinner.getValue();
        String anneeEntre = String.valueOf(content.yearSpinner.getValue());
        int unite = (int) content.uniteSpinner.getValue();
        Employee e;
        System.out.println("role = "+role);
        switch (role) {
            case ("Manutention"):
                e = new Manutentionnaire(prenom,nom,age,anneeEntre,unite);
                break;
            case ("Manutention A Risque"):
                e = new ManutARisque(prenom,nom,age,anneeEntre,unite);
                break;
            case ("Production"):
                e = new Technicien(prenom,nom,age,anneeEntre,unite);
                break;
            case ("Production A Risque"):
                e = new TechnARisque(prenom,nom,age,anneeEntre,unite);
                break;
            case ("Representant"):
                e = new Representant(prenom,nom,age,anneeEntre,unite);
                break;
            default:
                return false;
        }
        System.out.println(e.getName()+" est enregistré au registre du personnel.");
        personnel.ajouterEmploye(e);
        return true;
    };
}
