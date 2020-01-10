package robotturtle;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Cases{

    public int numero,positionXDepart,positionYDepart;
    public char direction;
    public Deck defausse,mainDujoueur,deck,programme;
    public Deck[] listeMurs; //Deck[0] : glaces, Deck[1] : pierre

    public void setDirection(char direction) {
        this.direction = direction;
    }
    public int getNumero() {
        return numero;
    }
    public Joueur(int pNumero, int pPositionXDepart, int pPositionYDepart){

        this.positionXDepart = pPositionXDepart;
        this.positionYDepart = pPositionYDepart;
        this.numero = pNumero;
        this.direction = 'S';
        this.listeMurs = new Deck[2];
        this.listeMurs[0].creerListeMurs();
        this.listeMurs[1].creerListeMurs();
        this.deck.créerDeck();
        this.defausse = new Deck();
        this.mainDujoueur = new Deck();

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
        System.out.println("Il se retourne");
    }
    public void est(){
        Main.plateau[this.positionY][this.positionX+1].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionX=this.positionX+1;
    }
    public void retourCaseDepart(){
        if(Main.plateau[this.positionYDepart][this.positionXDepart].getType() == 'J'){
            Joueur autreJoueur = Main.plateau[this.positionYDepart][this.positionXDepart].getJoueur();
            autreJoueur.retourCaseDepart();
        }
        this.setDirection('S');
        Main.plateau[this.positionYDepart][this.positionXDepart].setJoueur(this);
        Main.plateau[this.positionY][this.positionX].setType('V');
        this.positionX=this.positionXDepart;
        this.positionY=this.positionYDepart;
    }
    public void avancer(){
        //C'est fait en fonction du nombre de joueur reste plus qu'à changer la place du joueur dans le tableau
        if(this.direction=='N'){
            if(this.positionY==1){
                retourCaseDepart();
            }
            else{
                Main.plateau[this.positionY-1][this.positionX].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionY=this.positionY-1;
            }
        }
        else if(this.direction=='E' && Main.nombreDeJoueurs==4){
            if(this.positionX==8){
                retourCaseDepart();
            }
            else{
                est();
            }
        }
        else if(this.direction=='E'){
            if(this.positionX==7){
                retourCaseDepart();
            }
            else{
                est();
            }
        }
        else if(this.direction=='S'){
            if(this.positionY==8){
                retourCaseDepart();
            }
            else{
                Main.plateau[this.positionY+1][this.positionX].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionY=this.positionY+1;
            }
        }
        else if(this.direction=='O'){
            if(this.positionX==1){
                retourCaseDepart();
            }
            else{
                Main.plateau[this.positionY][this.positionX-1].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionX=this.positionX-1;
            }
        }
    }
    public void test(){
        // Si vide avancer, si joueur, les deux reculent, si mur, reculer, si joyaux gagner
        //plateau[y][x]
        if(this.direction=='N'){
            char typeCaseDirection = Main.plateau[this.positionY-1][this.positionX].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY-1][this.positionX];
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
            else if(typeCaseDirection == 'G'
                    || Main.plateau[this.positionY-1][this.positionX].getType() == 'P'){
                System.out.println("J"+this.numero+" se retourne");
                this.demiTour();
            }
            else if(typeCaseDirection == 'J'){
                Joueur autreJoueur = Main.plateau[this.positionY-1][this.positionX].getJoueur();
                autreJoueur.retourCaseDepart();
                this.retourCaseDepart();
            }
            else if(typeCaseDirection == 'B'){
                this.pousser();
            }
        }
        else if(this.direction=='E'){
            char typeCaseDirection = Main.plateau[this.positionY][this.positionX+1].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY][this.positionX+1];
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
            else if(typeCaseDirection == 'G'
                    || Main.plateau[this.positionY-1][this.positionX].getType() == 'P'){
                System.out.println("J"+this.numero+" se retourne");
                this.demiTour();
            }
            else if(typeCaseDirection == 'J'){
                Joueur autreJoueur = Main.plateau[this.positionY-1][this.positionX].getJoueur();
                autreJoueur.retourCaseDepart();
                this.retourCaseDepart();
            }
            else if(typeCaseDirection == 'B'){
                this.pousser();
            }
        }
        else if(this.direction=='S'){
            char typeCaseDirection = Main.plateau[this.positionY+1][this.positionX].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY+1][this.positionX];
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
            else if(typeCaseDirection == 'G'
                    || Main.plateau[this.positionY-1][this.positionX].getType() == 'P'){
                System.out.println("J"+this.numero+" se retourne");
                this.demiTour();
            }
            else if(typeCaseDirection == 'J'){
                Joueur autreJoueur = Main.plateau[this.positionY-1][this.positionX].getJoueur();
                autreJoueur.retourCaseDepart();
                this.retourCaseDepart();
            }
            else if(typeCaseDirection == 'B'){
                this.pousser();
            }
        }
        else if(this.direction=='O'){
            char typeCaseDirection = Main.plateau[this.positionY][this.positionX-1].getType();
            Cases casesJoueur = Main.plateau[this.positionY][this.positionX];
            Cases caseDirection = Main.plateau[this.positionY][this.positionX-1];
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
            else if(typeCaseDirection == 'G'
                    || Main.plateau[this.positionY-1][this.positionX].getType() == 'P'){
                System.out.println("J"+this.numero+" se retourne");
                this.demiTour();
            }
            else if(typeCaseDirection == 'J'){
                Joueur autreJoueur = Main.plateau[this.positionY-1][this.positionX].getJoueur();
                autreJoueur.retourCaseDepart();
                this.retourCaseDepart();
            }
            else if(typeCaseDirection == 'B'){
                this.pousser();
            }
        }

    }
    public void pousser(){
        //C'est fait en fonction du nombre de joueur reste plus qu'à changer la place du joueur dans le tableau
        if(this.direction=='N'){
            if(Main.plateau[this.positionY-2][this.positionX].getType() != 'V'){// test si la case en face du bois est vide
                Main.plateau[this.positionY-2][this.positionX].setType('B');
                Main.plateau[this.positionY-1][this.positionX].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionY=this.positionY-1;
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }
        else if(this.direction=='E'){
            if(Main.plateau[this.positionY][this.positionX+2].getType() != 'V'){
                Main.plateau[this.positionY][this.positionX+2].setType('B');
                Main.plateau[this.positionY][this.positionX+1].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionX=this.positionX+1;
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }

        else if(this.direction=='S'){
            if(Main.plateau[this.positionY+2][this.positionX].getType() != 'V'){
                Main.plateau[this.positionY+2][this.positionX].setType('B');
                Main.plateau[this.positionY+1][this.positionX].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionY=this.positionY+1;
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }
        else if(this.direction=='O'){
            if(Main.plateau[this.positionY][this.positionX-2].getType() != 'V'){
                Main.plateau[this.positionY][this.positionX-2].setType('B');
                Main.plateau[this.positionY][this.positionX-1].setJoueur(this);
                Main.plateau[this.positionY][this.positionX].setType('V');
                this.positionX=this.positionX-1;
                System.out.println("ça pousse");
            }
            else{
                this.demiTour();
            }
        }
    }

    public void Programme() {

        ArrayList<Card> à_éxécuter = new ArrayList<Card>();
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
    }

}

