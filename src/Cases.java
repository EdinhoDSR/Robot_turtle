import java.util.List;

public class Cases {
    //test
    private int positionX,positionY;
    protected char type;
    //Joueur : J, joyau : j, Mur de pierre : P, Mur de glace : G, Mur de bois : B
    private Boolean occupe; //true si une case est occupée par un pion, false si non
    // Liste des types : Joueur = j, vide = V, Mur = M, Joyeay *

    public Cases (int X, int Y, Boolean o){
        positionX = X;
        positionY = Y;
        occupe = o;
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


    }



