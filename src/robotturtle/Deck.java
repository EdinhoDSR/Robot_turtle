package robotturtle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    // création de la liste Deck

    public ArrayList<Card> cards;


    public Deck() {
        this.cards = new ArrayList<>();
    }

    // création des cartes du jeu

    public void créerDeck() {

        // création des cartes avancer
        for (int i =0; i<18 ; i++) {
            //
            this.cards.add(new Card(Valeurs.avancer ));
        }

        // création des cartes tourner à droite

        for(int j= 1; j<9; j++)
        {
            this.cards.add(new Card(Valeurs.tournerD ));
        }


        // création des cartes tourner à gauche
        for(int k= 1; k<9; k++) {
            this.cards.add(new Card(Valeurs.tournerG));
        }

        // creation des cartes laser
        for(int l= 1; l<4; l++) {
            this.cards.add(new Card(Valeurs.LASER ));
        }

        // creation des cartes bugs

        /*this.cards.add(new Card(Valeurs.BUG));
        this.cards.add(new Card(Valeurs.BUG));*/

    }
    public int TailleDeck() {
        return this.cards.size();
    }

    public void mélanger() {

        // création d'un deck temporaire

        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex ;

        int sizedeck = this.cards.size();
        for (int i = 0; i<sizedeck; i++) {

            // génération d'indice aléatoire
            randomCardIndex = random.nextInt((this.cards.size()-1 -0 )+1)+ 0;

            // on prends des cartes au hasard du deck pour les mettres dans le deck temporaire
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
        // prends ajoute une carte du deck dans un autre deck et supprime cette carte de ce deck
        this.cards.add(provenance.getCard(0));
        provenance.removeCard(0);
    }

    public String toString() {

        String cardListOutput ="";
        for (Card aCard: this.cards) {
            cardListOutput += "\n-" + aCard.toString();		}

        return cardListOutput;
    }

    public void créer_main(Deck main_joueur,Deck provenance) { //mainJoueuer est alors vide et provenance est le De k du jueuer


        for (int i=0; i<5; i++) {
            System.out.println(provenance.getCard(0));
            main_joueur.draw(provenance);
        }
    }

    public void Defausse(Deck provenance, Deck defausse, int i) {
        defausse.addCard(provenance.getCard(i));
        provenance.removeCard(i);
    }

    public void creerListeMursPierre(){
        for(int i=0; i<3;i++){
            this.addCard(new Card(Valeurs.Mdp));
        }

    }
    public void creerListeMursGlace(){
        for(int i=0; i<2;i++){
            this.addCard(new Card(Valeurs.Mdg));
        }
    }

    public void ajouter_programme(Deck provenance, int i) {
        this.cards.add(provenance.getCard(i));
        provenance.removeCard(i);
    }

    public void vider() {
        this.cards.clear();
    }
}


}


