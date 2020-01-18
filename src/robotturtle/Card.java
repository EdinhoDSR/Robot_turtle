package robotturtle;

import javax.swing.*;

public class Card {
    private Valeurs valeurs;
    private JLabel image;


    public Card (Valeurs valeurs) {
        this.valeurs = valeurs;
    }

    public Card (JLabel image) {this.image=image;}

    public String toString() {

        return this.valeurs.toString();

    }

    public JLabel getJlabel() {
        return this.image;
    }

    public Valeurs getvaleurs() {
        return this.valeurs;

    }
}
