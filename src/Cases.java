import java.util.List;

public class Cases {

    public int positionX,positionY;
    public char type; //Joueur : J, joyau : j, Mur de pierre : P, Mur de glace : G, Mur de bois : B, Vide : V
    public Boolean occupe; //true si une case est occupée par un pion, false si non

    public Cases(){}
    public Cases (int pX, int pY, Boolean pO){
        positionX = pX;
        positionY = pY;
        occupe = pO;
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

    public Boolean getOccupe() {
        return occupe;
    }

    public void setOccupe(Boolean o) { this.occupe = o; }

    public void pierre(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.occupe = True;
        this.type = 'P';
    }
    public void bois(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.occupe = True;
        this.type = 'B';
    }
    public void glace(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.occupe = True;
        this.type = 'G';
    }
    public void joyau(){//Pour s'assurer que la case est occupe et simplifier l'init
        this.type = 'j';
        this.occupe = True;

    }


    }



