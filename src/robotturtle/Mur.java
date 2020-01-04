package robotturtle;

public class   Mur extends Cases {

    protected char typeDeMur;

    public Mur(Cases CasePlateau, char ){

        this.setType('M');//initialise le type de pion à 'M'
    }
    protected char getTypeDeMur(){
        return(typeDeMur);
    }
    protected void setTypeDeMur(char tdm){
        typeDeMur = tdm;
    }

}
