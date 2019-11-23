import java.util.Collections;
import java.util.List;

public class Deck {
    String nomDuDeck;
    Joueur joueur;
    List<Carte> listeCartes;

    public Deck(String nomDuDeck,Joueur joueur,List<Carte> listeCartes){
        this.nomDuDeck = nomDuDeck;
        this.joueur = joueur;
        this.listeCartes = listeCartes;
    }

    public void addCarte(Carte carte){
        this.listeCartes.add(carte);
    }

    public void melangerDeck(){
        Collections.shuffle(this.listeCartes);
    }



}
