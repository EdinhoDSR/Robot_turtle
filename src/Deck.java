import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {

    // création de la liste Deck

    private ArrayList<String> cards;


    public Deck() {
        this.cards = new ArrayList<String>();
    }

    // création des cartes du jeu
    public void createFullDeck() {


        // création des cartes avancer
        for (int i =0; i<19 ; i++) {
            //
            this.cards.add("Avancer");
        }

        // création des cartes tourner à droite

        for(int j= 1; j<9; j++)
        {
            this.cards.add("Droite");


            // création des cartes tourner à gauche
        }
        for(int k= 1; k<9; k++) {
            this.cards.add("Gauche");
        }

        // creation des cartes laser
        for(int l= 1; l<4; l++) {
            this.cards.add("Laser");
        }
    }


    // fonction qui mélange le deck

    public void shuffle() {

        Collections.shuffle(this.cards);

    }

    // création de la fonction pour enlever une carte d'un deck

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    // fonction qui retourne une carte d'un deck
    public Card getCard(int i) {
        return this.cards.get(i);
    }

    // fonction qui ajoute une carte dans un deck
    public void addCard(String addCard) {
        this.cards.add(addCard);
    }



    //  Fonction qui pioche les cartes
    public void draw (Deck provenance) {
        // prends
        this.cards.add(provenance.getCard(0));
        provenance.removeCard(0);


    }



}

