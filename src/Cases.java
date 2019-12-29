import java.util.List;

public class Cases {
    //test
    private int positionX;
    private int positionY;
    private int positionXDepart;
    private int positionYDepart;
    private int numero;
    private char type;
    private char typeM;
    private char direction;
    private List<String> deck;
    private List<String> defausse;
    private List<String> main;
    private Deck Deck;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setDeck(Deck deck) {
        Deck = deck;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionXDepart() {
        return positionXDepart;
    }

    public void setPositionXDepart(int positionXDepart) {
        this.positionXDepart = positionXDepart;
    }

    public int getPositionYDepart() {
        return positionYDepart;
    }

    public void setPositionYDepart(int positionYDepart) {
        this.positionYDepart = positionYDepart;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public List<String> getDeck() {
        return deck;
    }

    public void setDeck(List<String> deck) {
        this.deck = deck;
    }

    public List<String> getDefausse() {
        return defausse;
    }

    public void setDefausse(List<String> defausse) {
        this.defausse = defausse;
    }

    public List<String> getMain() {
        return main;
    }

    public void setMain(List<String> main) {
        this.main = main;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Cases(char pDriection, int pPositionX, int pPositionY)
    {
        System.out.println("Création d'un joueur avec des paramètres !");
        positionX = pPositionX;
        positionY = pPositionY;
        direction = pDriection;
    }

    public void joueur( char pDriection, int pPositionY, int pPositionX, int pNumero)
    {
        System.out.println("Création d'un joueur avec des paramètres !");

        positionX = pPositionX;
        positionXDepart = pPositionX;
        positionY = pPositionY;
        positionYDepart = pPositionY;

        direction = pDriection;
        numero = pNumero;
        Deck = new Deck();
        type = 'J';
    }

    public void joyau( int pPositionY, int pPositionX){
        type = 'j';
        positionY = pPositionY;
        positionX = pPositionX;
    }

    public void remove(){
        main.plateau[this.positionY][this.positionX].setType('V');

    }

    public void avancer(){
        //C'est fait en fonction du nombre de joueur reste plus qu'à changer la place du joueur dans le tableau
        if(this.direction=='N'){
            if(main.plateau[this.positionY-1][this.positionX].getType() == 'V'){
                main.plateau[this.positionY][this.positionX].remove();
                this.positionX=this.positionXDepart;
                this.positionY=this.positionYDepart;
            }
            else if(main.plateau[this.positionY-1][this.positionX].getType() == 'M'){
                main.plateau[this.positionY][this.positionX].remove();
                main.plateau[this.positionY][this.positionX].demiTour();
            }
            else if(main.plateau[this.positionY-1][this.positionX].getType() == 'J'){
                main.plateau[this.positionY][this.positionX].remove();
                main.plateau[this.positionY][this.positionX].demiTour();
                main.plateau[this.positionY-1][this.positionX].demiTour();
            }
        }
        else if(this.direction=='E' && jeu.nombreDeJoueurs==4){
            if(this.positionX==8){this.positionX=this.positionXDepart;this.positionY=this.positionYDepart;}
            else{this.positionX=this.positionX+1;}
        }
        else if(this.direction=='E'){
            if(this.positionX==7){this.positionX=this.positionXDepart;this.positionY=this.positionYDepart;}
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

}