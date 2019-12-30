public class Mur extends Pion {
    protected char typeDeMur;
    public Mur(){
        this.setType('M');//initialise le type de pion à 'M'
    }
    protected char getTypeDeMur(){
        return(typeDeMur);
    }
    protected void setTypeDeMur(char tdm){
        typeDeMur = tdm;
    }

}
