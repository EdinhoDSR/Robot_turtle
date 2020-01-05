package robotturtle;

public class Cases {

    protected int positionX,positionY;
    private char type; //robotturtle.Joueur : J, joyau : j, robotturtle.Mur de pierre : P, robotturtle.Mur de glace : G, robotturtle.Mur de bois : B, Vide : V
    protected Joueur joueur;


    public Cases(){}
    public Cases (int pX, int pY){
        positionX = pX;
        positionY = pY;
        type = 'V';
    }


    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
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


    public Joueur getJoueur() {
        return(joueur);
    }

    public void setJoueur(Joueur j){
        this.joueur = j;
        this.type = 'J';
    }

    public void pierre(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'P';
    }
    public void bois(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'B';
    }
    public void glace(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'G';
    }
    public void joyau(){//Pour s'assurer que la case est occupe et simplifier l'init
        this.type = 'j';
        main.plateau[1][2] = new Cases(2,3);


    }


    }



