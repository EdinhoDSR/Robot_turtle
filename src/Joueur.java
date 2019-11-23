import java.util.List;

public class Joueur {
    private int positionX;
    private int positionY;
    private int positionXDepart;
    private int positionYDepart;
    private int numero;
    private char direction;
    private List<String> deck;
    private List<String> defausse;
    private List<String> main;


    public Joueur( char pDriection, int pPositionX, int pPositionY)
    {
        System.out.println("Création d'un joueur avec des paramètres !");
        positionX = pPositionX;
        positionY = pPositionY;
        direction = pDriection;
    }
    public void avancer(){
        //Mettre en fonction du nombre de joueur
        if(this.direction=='N'){
            if(this.positionY==1){this.positionX=this.positionXDepart;this.positionY=this.positionYDepart;}
            else{this.positionY=this.positionY-1;}
        }
        else if(this.direction=='E'){
            if(this.positionX==8){this.positionX=this.positionXDepart;this.positionY=this.positionYDepart;}
            else{this.positionX=this.positionX+1;}
        }
        else if(this.direction=='S'){
            if(this.positionY==8){this.positionX=this.positionXDepart;this.positionY=this.positionYDepart;}
            else{this.positionY=this.positionY+1;}
        }
        else if(this.direction=='O'){
            if(this.positionX==1){this.positionX=this.positionXDepart;this.positionY=this.positionYDepart;}
            else{this.positionX=this.positionX-1;}
        }
    }
    public void test(){
        // Si vide avancer, si joueur, les deux reculent, si mur, reculer, si joyaux gagner
        //plateau[y][x]
        if(this.direction=='N'){
            if(jeu.plateau[this.positionY][this.positionX].equals(".")){}
        }
        else if(this.direction=='E'){}
        else if(this.direction=='S'){}
        else if(this.direction=='O'){}
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

    public void utiliserLaser(){
        if (direction == 'E'){
            for(int i=0;i<nb){

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

    }

