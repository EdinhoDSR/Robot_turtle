package robotturtle;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Cases{

    public int numero,positionXDepart,positionYDepart;
    public char direction;
    public Deck defausse,mainDujoueur,deck,programme,mursGlace,mursPierre;
     //Deck[0] : glaces, Deck[1] : pierre

    public void setDirection(char direction) {
        this.direction = direction;
    }
    public int getNumero() {
        return numero;
    }

    public Joueur(int pNumero, int pPositionXDepart, int pPositionYDepart){

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

        Main.remplissageMain(this);


    }
    private void laser(){
        if (this.direction == 'N'){// Cas où le joueur regarde vers le nord
            for (int i = 0;i<Main.plateau.length-this.getPositionY();i++){
                Cases caseEnCours = Main.plateau[this.getPositionY()-i][this.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
            for (int i = joueur.getPositionY();i<Main.plateau.length;i++){
                Cases caseEnCours = Main.plateau[i][joueur.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
        if (joueur.direction == 'E'){// Cas où le joueur regarde vers l'Est
            for (int i = joueur.getPositionX();i<Main.plateau.length;i++){
                Cases caseEnCours = Main.plateau[joueur.getPositionY()][i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
        if (joueur.direction == 'O'){// Cas où le joueur regarde vers l'ouest
            for (int i = 0;i<Main.plateau.length-joueur.getPositionX();i++){
                Cases caseEnCours = Main.plateau[joueur.getPositionY()][joueur.getPositionX()-i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (Main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (Main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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

        if(this.direction=='N'){this.direction='E';}
        else if(this.direction=='E'){this.direction='S';}
        else if(this.direction=='S'){this.direction='O';}
        else if(this.direction=='O'){this.direction='N';}
    }
    public void tournerG(){

        if(this.direction=='N'){this.direction='O';}
        else if(this.direction=='O'){this.direction='S';}
        else if(this.direction=='S'){this.direction='E';}
        else if(this.direction=='E'){this.direction='N';}
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

    }
    public void jaipasdenom(char typeCaseDirection,Cases casesJoueur,Cases caseDirection){
        if(typeCaseDirection == 'j'){
            caseDirection.setType('V');
            casesJoueur.setType('V');
            System.out.println("J"+this.numero+" a gagné");
            Main.listeDeJoueur.remove(this);
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
    }
    public void test() {
        // Si vide avancer, si joueur, les deux reculent, si mur, reculer, si joyaux gagner
        //plateau[y][x]
        if (this.direction == 'N') {
            char typeCaseDirection = Main.plateau[this.positionY - 1][this.positionX].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY - 1][this.positionX];
            jaipasdenom(typeCaseDirection, casesJoueur, caseDirection);

        } else if (this.direction == 'E') {
            char typeCaseDirection = Main.plateau[this.positionY][this.positionX + 1].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY][this.positionX + 1];
            jaipasdenom(typeCaseDirection, casesJoueur, caseDirection);
        } else if (this.direction == 'S') {
            char typeCaseDirection = Main.plateau[this.positionY + 1][this.positionX].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY + 1][this.positionX];
            jaipasdenom(typeCaseDirection, casesJoueur, caseDirection);

        } else if (this.direction == 'O') {
            char typeCaseDirection = Main.plateau[this.positionY][this.positionX - 1].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY][this.positionX - 1];
            jaipasdenom(typeCaseDirection, casesJoueur, caseDirection);
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
            System.out.println("la carte traitée est " + this.programme.cards.get(i));
            a= this.programme.cards.get(i);
            switch (a.getvaleurs()) {

                case avancer:
                    this.avancer();
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
            this.programme.Defausse(this.programme,this.defausse,0);
        }
    }

}

