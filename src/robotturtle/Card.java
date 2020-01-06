package robotturtle;

public class Card {
    private Valeurs valeurs;


    public Card (Valeurs valeurs) {
        this.valeurs = valeurs;
    }

    public String toString() {

        return this.valeurs.toString();

    }

    public Valeurs getvaleurs() {
        return this.valeurs;

    }
}
