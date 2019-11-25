import java.util.ArrayList;
import java.util.Random;

public class Deck {

    // création de la liste Deck

    private ArrayList<Card> cards;


    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    // création des cartes du jeu
    public void createFullDeck() {


        // création des cartes avancer
        for (int i =0; i<19 ; i++) {
            //
            this.cards.add(new Card(Valeurs.TOUT_DROIT ));
        }

        // création des cartes tourner à droite

        for(int j= 1; j<9; j++)
        {
            this.cards.add(new Card(Valeurs.DROITE ));


            // création des cartes tourner à gauche
        }
        for(int k= 1; k<9; k++) {
            this.cards.add(new Card(Valeurs.GAUCHE ));
        }

        // creation des cartes laser
        for(int l= 1; l<4; l++) {
            this.cards.add(new Card(Valeurs.LASER ));
        }
    }


    // fonction qui mélange le deck

    public void shuffle() {

        // création d'un deck temporaire

        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;

        int sizedeck = this.cards.size();
        for (int i = 0; i<sizedeck; i++) {

            // génération d'indice aléatoire

            randomCardIndex = random.nextInt((this.cards.size()-1 -0 )+1)+ 0;

            // on prends des cartes au hazard du deck pour les mettres dans le deck temporaire
            tmpDeck.add(this.cards.get(randomCardIndex));

            // enlèvement des cartes placées dans le deck temporaire

            this.cards.remove(randomCardIndex);


        }

        // le deck temporaire devient le deck principal

        this.cards= tmpDeck;
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
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }



    //  Fonction qui pioche les cartes
    public void draw (Deck provenance) {
        // prends
        this.cards.add(provenance.getCard(0));
        provenance.removeCard(0);


    }



    public String toString() {

        String cardListOutput ="";
        for (Card aCard: this.cards) {
            cardListOutput += "\n-" + aCard.toString();		}

        return cardListOutput;

    }

    public int cardsValur() {
        int totalvalue=0;
        return totalvalue;

    }


}

