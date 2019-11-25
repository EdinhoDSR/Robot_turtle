import java.util.*;

public class Joueur extends objetJeu {
    private int positionX;
    private int positionY;
    private int positionXDepart;
    private int positionYDepart;
    private int numero;
    private char direction;
    private List<String> deck;
    private List<String> defausse;
    private List<String> main;

    public Joueur( char pDriection, int pPositionX, int pPositionY, int pNumero)
    {
        System.out.println("Création d'un joueur avec des paramètres !");
        positionX = pPositionX;
        positionY = pPositionY;
        direction = pDriection;
        numero = pNumero;
        type = 'J';
    }
    public void avancer(){
        //methode termine
        if(this.direction=='N'){
            if(this.positionY==1){
                this.positionX=this.positionXDepart;
                this.positionY=this.positionYDepart;
            }
            else{
                jeu.plateau[positionY][positionX]=vide;
                this.positionY=this.positionY-1;
                jeu.plateau[positionY][positionX]="J"+this.numero;
            }
        }
        else if(this.direction=='E'){
            if(this.positionX==7){
                this.positionX=this.positionXDepart;
                this.positionY=this.positionYDepart;
            }
            else{
                jeu.plateau[positionY][positionX]=".";
                this.positionX=this.positionX+1;
                jeu.plateau[positionY][positionX]="J"+this.numero;
            }
        }
        else if(this.direction=='S'){
            if(this.positionY==8){
                this.positionX=this.positionXDepart;
                this.positionY=this.positionYDepart;
            }
            else{
                jeu.plateau[positionY][positionX]=".";
                this.positionY=this.positionY+1;
                jeu.plateau[positionY][positionX]="J"+this.numero;
            }
        }
        else if(this.direction=='O'){
            if(this.positionX==1){
                this.positionX=this.positionXDepart;
                this.positionY=this.positionYDepart;
            }
            else{
                jeu.plateau[positionY][positionX]=".";
                this.positionX=this.positionX-1;
                jeu.plateau[positionY][positionX]="J"+this.numero;
            }
        }
    }
    public void avancerMurDeBois(){}
    public void test(){
        // Si vide avancer, si joueur, les deux reculent, si mur, reculer, si joyaux gagner
        //plateau[y][x]
        if(jeu.plateau[this.positionY][this.positionX].equals(".")){
            this.avancer();
        }
        else if(jeu.plateau[this.positionY][this.positionX].equals("murDeBois")){}
        else if(jeu.plateau[this.positionY][this.positionX].equals("murDePierre")){}
        else if(jeu.plateau[this.positionY][this.positionX].equals("murDeGlace")){}
        else if(jeu.plateau[this.positionY][this.positionX].equals("joueur")){}
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
    public void reculer(){
        this.tournerG();
        this.tournerG();
        this.avancer();
    }

    public void utiliserLaser(){
        if (direction == 'E'){
            for(int i=positionX;i<8;i++){
                if (!jeu.plateau[positionY][i].equals(".")){
                    if (jeu.plateau[positionY][i].equals("murDeGlace")){
                        jeu.plateau[positionY][i] = ".";
                    }
                    if (jeu.plateau[positionY][i].substring(0,1).equals("j")){
                        this.tournerD();
                        this.tournerD();
                    }
                    if (jeu.plateau[positionY][i].substring(0,1).equals("J")){
                        /*L'objet joueur touché doit reculer
                        this.tournerD();
                        this.tournerD();
                        */
                    }


                }

            }
        }
    }

    public void poserMur(String typeDeMur) {
        //A remplir !!!!
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getDirection() {
        return direction;
    }


    public void setDirection(char direction) {
        this.direction = direction;
    }
/*
    public void utiliserCarte(String carte) {
        if (carte.equals("avancer")) {
            this.avancer();
        }
        if (carte.equals("reculer")) {
            this.tournerD();
            this.tournerD();
            this.avancer();
        }
        if (carte.equals("tournerG")) {
            this.tournerG();
        }
        if (carte.equals("tournerD")) {
            this.tournerD();
        }
        if (carte.equals("tournerD")) {
            this.utiliserLaser();
        }
        if (carte.equals("murDeGlace")) {
            this.poserMur("murDeGlace");
        }
        if (carte.equals("murDeBois")) {
            this.poserMur("murDeBois");
        }
        if (carte.equals("murEnPierre")) {
            this.poserMur("murEnPierre");
        }
    }
*/
    }

