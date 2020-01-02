public class Pion {

    protected Cases casePlateau;
    protected char type;
    //Joueur : J, joyau : j, Mur : M

    public Pion(Cases CasePlateau){
        //Constructeur
        casePlateau = CasePlateau;
    }
    protected Cases getCase(){
        return(casePlateau);
    }
    protected void setCase(Cases CasePlateau){
        casePlateau = CasePlateau;
    }

    protected char getType(){
        return(type);
    }

    protected void setType(char t){
        type =t;
    }
}
