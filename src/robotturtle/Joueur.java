package robotturtle;

import java.util.List;

public class Joueur extends Cases{

    public int numero,positionXDepart,positionYDepart;
    public char direction;
    public List<String> defausse,mainDujoueur,deck,programme;
    public boolean gagnant;

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
        this.gagnant = false;

    }
    private void laser(){
        if (this.direction == 'N'){// Cas où le joueur regarde vers le nord
            for (int i = 0;i<main.plateau.length-this.getPositionY();i++){
                Cases caseEnCours = main.plateau[this.getPositionY()-i][this.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
            for (int i = joueur.getPositionY();i<main.plateau.length;i++){
                Cases caseEnCours = main.plateau[i][joueur.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
            for (int i = joueur.getPositionX();i<main.plateau.length;i++){
                Cases caseEnCours = main.plateau[joueur.getPositionY()][i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
            for (int i = 0;i<main.plateau.length-joueur.getPositionX();i++){
                Cases caseEnCours = main.plateau[joueur.getPositionY()][joueur.getPositionX()-i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (main.nombreDeJoueurs == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (main.nombreDeJoueurs >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
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
        main.plateau[this.positionY][this.positionX+1].setJoueur(this);
        main.plateau[this.positionY][this.positionX].setType('V');
        this.positionX=this.positionX+1;
    }
    public void retourCaseDepart(){
        this.setDirection('S');
        main.plateau[this.positionYDepart][this.positionXDepart].setJoueur(this);
        main.plateau[this.positionY][this.positionX].setType('V');
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
                main.plateau[this.positionY-1][this.positionX].setJoueur(this);
                main.plateau[this.positionY][this.positionX].setType('V');
                this.positionY=this.positionY-1;
            }
        }
        else if(this.direction=='E' && main.nombreDeJoueurs==4){
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
                main.plateau[this.positionY+1][this.positionX].setJoueur(this);
                main.plateau[this.positionY][this.positionX].setType('V');
                this.positionY=this.positionY+1;
            }
        }
        else if(this.direction=='O'){
            if(this.positionX==1){
                retourCaseDepart();
            }
            else{
                main.plateau[this.positionY][this.positionX-1].setJoueur(this);
                main.plateau[this.positionY][this.positionX].setType('V');
                this.positionX=this.positionX-1;
            }
        }
    }
    public void test(){
        // Si vide avancer, si joueur, les deux reculent, si mur, reculer, si joyaux gagner
        //plateau[y][x]
        if(this.direction=='N'){
            if(main.plateau[this.positionY][this.positionX].equals(".")){}
        }
        else if(this.direction=='E'){}
        else if(this.direction=='S'){}
        else if(this.direction=='O'){}
    }

    }

