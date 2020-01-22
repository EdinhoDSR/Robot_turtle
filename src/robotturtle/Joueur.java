package robotturtle;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Joueur extends Cases{


    public int numero,positionXDepart,positionYDepart;
    public char direction;
    public Deck defausse,mainDujoueur,deck,programme,mursGlace,mursPierre;
    public JLabel imageElement;
    public String[] listeImages;
     //Deck[0] : glaces, Deck[1] : pierre

    public void setDirection(char direction) {
        this.direction = direction;
    }
    public int getNumero() {
        return numero;
    }


    public Joueur(int pNumero, int pPositionXDepart, int pPositionYDepart, String[] nomsFichiersImages)  {

        this.type = 'J';
        this.positionXDepart = pPositionXDepart;
        this.positionYDepart = pPositionYDepart;
        this.positionX = pPositionXDepart;
        this.positionY = pPositionYDepart;
        this.numero = pNumero;
        this.direction = 'S';

        this.mursGlace = new Deck();
        this.mursPierre = new Deck();
        this.mursGlace.creerListeMursGlace();
        this.mursPierre.creerListeMursPierre();

        this.deck = new Deck();
        this.deck.créerDeck();
        deck.mélanger();
        this.defausse = new Deck();
        this.mainDujoueur = new Deck();
        this.programme = new Deck();
//        this.programme.addCard(new Card(Valeurs.avancer));

        Main.remplissageMain(this);
        this.imageElement = new JLabel(new ImageIcon(nomsFichiersImages[3]));
        this.listeImages = nomsFichiersImages;


    }
    public void laser(){
        if (this.direction == 'N'){// Cas où le joueur regarde vers le nord
            for (int i = 1;i<this.getPositionY();i++){
                Cases caseEnCours = Main.plateau[this.getPositionY()-i][this.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    Main.fenetre.remove(caseEnCours.imageGlace);
                    Main.fenetre.repaint();
                    break;
                }
                if (caseEnCours.type == 'J'){

                    if (Main.listeDeJoueur.size() == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.listeDeJoueur.size() >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart();
                        caseEnCours.joueur.retourCaseDepart();
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart();
                    break;
                }
            }
        }
        if (this.direction == 'S'){// Cas où le joueur regarde vers le Sud
            for (int i = this.getPositionY()+1;i<Main.plateau.length;i++){
                Cases caseEnCours = Main.plateau[i][this.getPositionX()];
                if (caseEnCours.type == 'G'){
                    System.out.println("coucou");
                    caseEnCours.setType('V');
                    Main.fenetre.remove(caseEnCours.imageGlace);
                    Main.fenetre.repaint();
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.listeDeJoueur.size() == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.listeDeJoueur.size() >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart();
                        caseEnCours.joueur.retourCaseDepart();
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart();
                    break;
                }
            }
        }
        if (this.direction == 'E'){// Cas où le joueur regarde vers l'Est
            for (int i = this.getPositionX()+1;i<Main.plateau.length;i++){
                Cases caseEnCours = Main.plateau[this.getPositionY()][i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    Main.fenetre.remove(caseEnCours.imageGlace);
                    Main.fenetre.repaint();
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.listeDeJoueur.size() == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.listeDeJoueur.size() >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart();
                        caseEnCours.joueur.retourCaseDepart();
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart();
                    break;
                }
            }
        }
        if (this.direction == 'O'){// Cas où le joueur regarde vers l'ouest
            for (int i = 1;i<this.getPositionX();i++){
                Cases caseEnCours = Main.plateau[this.getPositionY()][this.getPositionX()-i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    Main.fenetre.remove(caseEnCours.imageGlace);
                    Main.fenetre.repaint();
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.listeDeJoueur.size() == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.listeDeJoueur.size() >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart();
                        caseEnCours.joueur.retourCaseDepart();
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart();
                    break;
                }
            }
        }
    }
    public void tournerD(){

        if(this.direction=='N'){
            this.direction='E';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[2]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();

        }
        else if(
                this.direction=='E'){this.direction='S';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[3]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        else if(
                this.direction=='S'){this.direction='O';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[1]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        else if(this.direction=='O'){
            this.direction='N';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[0]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    public void tournerG(){

        if(this.direction=='N'){
            this.direction='O';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[1]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        else if(this.direction=='O'){
            this.direction='S';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[3]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        else if(this.direction=='S'){
            this.direction='E';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[2]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        else if(this.direction=='E'){
            this.direction='N';
            Main.fenetre.remove(this.imageElement);
            this.imageElement = new JLabel(new ImageIcon(this.listeImages[0]));
            Main.fenetre.deplacerJoueur(this,this.positionX,this.positionY);
            Main.fenetre.remove(Main.plateauVisu);
            Main.fenetre.add(this.imageElement);
            Main.fenetre.add(Main.plateauVisu);
            Main.fenetre.repaint();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    public void demiTour(){
        this.tournerG();
        this.tournerG();
    }
    public void est(){
        Main.plateau[this.positionY][this.positionX+1].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionX=this.positionX+1;
    }
    public void nord(){
        Main.plateau[this.positionY-1][this.positionX].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionY=this.positionY-1;
    }
    public void sud(){
        Main.plateau[this.positionY+1][this.positionX].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionY=this.positionY+1;
    }
    public void ouest(){
        Main.plateau[this.positionY][this.positionX-1].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionX=this.positionX-1;
    }
    public void retourCaseDepart(){
        if(Main.plateau[this.positionYDepart][this.positionXDepart].getType() == 'J'){

            Joueur autreJoueur = Main.plateau[this.positionYDepart][this.positionXDepart].getJoueur();
            Main.plateau[this.positionYDepart][this.positionXDepart].setType('V');
            Main.plateau[this.positionYDepart][this.positionXDepart].setJoueur(autreJoueur);
        }
        this.setDirection('S');
        Main.plateau[this.positionYDepart][this.positionXDepart].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionX=this.positionXDepart;
        this.positionY=this.positionYDepart;
        Main.fenetre.remove(this.imageElement);
        this.imageElement = new JLabel(new ImageIcon(this.listeImages[3]));
        Main.fenetre.remove(Main.plateauVisu);
        Main.fenetre.add(this.imageElement);
        Main.fenetre.add(Main.plateauVisu);
        Main.fenetre.repaint();
    }

    public void avancer(){
        if(this.direction=='N'){
            nord();
        }
        else if(this.direction=='S'){
            sud();
        }
        else if(this.direction=='E'){
            est();
        }
        else if(this.direction=='O'){
            ouest();
        }
        Main.fenetre.deplacerJoueur(this,this.getPositionX(),this.getPositionY());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }


    public void actionJoueur(char typeCaseDirection,Cases casesJoueur,Cases caseDirection){
        if(typeCaseDirection == 'j'){
            caseDirection.setType('V');
            casesJoueur.setType('V');
            System.out.println("J"+this.numero+" a gagné");
            Main.listeDeJoueurs.remove(this);
            Main.fenetre.remove(caseDirection.imageJoyau);
            Main.fenetre.remove(this.imageElement);
            Main.fenetre.repaint();
        }
        else if(typeCaseDirection == 'V'){
            this.avancer();
            System.out.println("J"+this.numero+" avance");
        }
        else if(typeCaseDirection == 'G' || typeCaseDirection == 'P'){
            System.out.println("J"+this.numero+" se retourne");
            this.demiTour();
        }
        else if(typeCaseDirection == 'J'){
            caseDirection.joueur.retourCaseDepart();
            System.out.println("J"+caseDirection.joueur.numero+" retourne au départ");
            this.retourCaseDepart();
            System.out.println("J"+this.numero+" retourne au départ");
        }
        else if(typeCaseDirection == 'H'){
            this.retourCaseDepart();
            System.out.println("Le joueur sort du plateau."+"J"+this.numero+" retourne au départ");
            System.out.println("J"+this.numero+" retourne au départ");
        }
    }
    public void test() {
        // Si vide avancer, si joueur, les deux reculent, si mur, reculer, si joyaux gagner
        //plateau[y][x]
        if (this.direction == 'N') {
            char typeCaseDirection = Main.plateau[this.positionY - 1][this.positionX].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY - 1][this.positionX];
            actionJoueur(typeCaseDirection, casesJoueur, caseDirection);

        } else if (this.direction == 'E') {
            char typeCaseDirection = Main.plateau[this.positionY][this.positionX + 1].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY][this.positionX + 1];
            actionJoueur(typeCaseDirection, casesJoueur, caseDirection);
        } else if (this.direction == 'S') {
            char typeCaseDirection = Main.plateau[this.positionY + 1][this.positionX].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY + 1][this.positionX];
            actionJoueur(typeCaseDirection, casesJoueur, caseDirection);

        } else if (this.direction == 'O') {
            char typeCaseDirection = Main.plateau[this.positionY][this.positionX - 1].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY][this.positionX - 1];
            actionJoueur(typeCaseDirection, casesJoueur, caseDirection);
        }
    }
    public void pousser(){
        //C'est fait en fonction du nombre de joueur reste plus qu'à changer la place du joueur dans le tableau
        if(this.direction=='N'){
            if(Main.plateau[this.positionY-2][this.positionX].getType() != 'V'){// test si la case en face du bois est vide
                Main.plateau[this.positionY-2][this.positionX].setType('B');
                nord();
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }
        else if(this.direction=='E'){
            if(Main.plateau[this.positionY][this.positionX+2].getType() != 'V'){
                Main.plateau[this.positionY][this.positionX+2].setType('B');
                est();
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }

        else if(this.direction=='S'){
            if(Main.plateau[this.positionY+2][this.positionX].getType() != 'V'){
                Main.plateau[this.positionY+2][this.positionX].setType('B');
                sud();
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }
        else if(this.direction=='O'){
            if(Main.plateau[this.positionY][this.positionX-2].getType() != 'V'){
                Main.plateau[this.positionY][this.positionX-2].setType('B');
                ouest();
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }
    }
    public void affichage(){
        this.mainDujoueur.TailleDeck();
        if(this.mainDujoueur.TailleDeck()==0){System.out.println("Il n'y a pas de cartes dans votre main");}
        else{
            for(int i=0; i<this.mainDujoueur.TailleDeck(); i++){
                System.out.println(this.mainDujoueur.getCard(i).toString());
            }
        }


    }
    public void executionProgramme() {

        ArrayList<Card> à_éxécuter = new ArrayList<>();
        Card a;
        int taille = this.programme.cards.size();

        for(int i=0; i< taille ; i++) {
//            System.out.println("la carte traitée est " + this.programme.cards.get(i));
            a= this.programme.cards.get(i);
            switch (a.getvaleurs()) {

                case avancer:
                    this.test();
                    break;
                case tournerG:
                    this.tournerG();
                    break;
                case tournerD:
                    this.tournerD();
                    break;
                case LASER :
                    this.laser();
                    break;
                /*
                case BUG :
                    à_éxécuter.add(new Card(Valeurs.BUG ));
                    break;

                 */
            }
        }
        for (int i=0;i<programme.TailleDeck();i++){
            this.defausse.addCard(this.programme.getCard(i));
        }
        this.programme.vider();

    }
}

