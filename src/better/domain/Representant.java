package better.domain;

public class Representant extends Seller {

    public Representant(String firstname, String lastname, int age, String entryYear, double turnover) {
        super(firstname, lastname, age, entryYear, turnover);
    }

    @Override
    public String getPosition() {
        return "Représentant";
    }

    @Override
    protected double getBonus() {
        return 800;
    }
}
