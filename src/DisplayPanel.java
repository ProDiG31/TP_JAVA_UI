import better.domain.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayPanel extends JPanel{

    public DisplayPanel(ViewControlleur Controlleur){

        int nbEmp =  Integer.valueOf(Controlleur.personnel.getNbEmploye());

        Object[][] donnees = new Object[nbEmp+1][];
        this.setLayout(new BorderLayout());

        ArrayList<Employee> employees = Controlleur.personnel.getEmployees();
        int salaireTotal = 0;
        int i = 0;
        for (Employee e : employees) {
            donnees[i] = (new Object[]{e.getPosition(),
                    e.getName(),
                    String.valueOf(e.getAge()),
                    e.getAnneeEntree(),
                    String.valueOf(e.calculerSalaire())}
            );
            salaireTotal += e.calculerSalaire();
            i++;
        }

        donnees[i]= (new Object[]{"Salaire Moyen","","","",Controlleur.personnel.salaireMoyen()});

        String[] entetes = {"Role", "Employe", "Age", "Année d'entrée", "Salaire"};
        JTable tableau = new JTable(donnees, entetes);

        JPanel j1 = new JPanel();

        j1.add(new JLabel("Totals des Salaires de l'entreprise : "));
        j1.add(new JTextField(String.valueOf(salaireTotal)));

        this.add(tableau.getTableHeader(), BorderLayout.NORTH);
        this.add(tableau, BorderLayout.CENTER);
        this.add(j1,BorderLayout.SOUTH);
    }
}
