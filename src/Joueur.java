import java.util.List;

public class Joueur {
    private int position;
    private char direction;
    private List<String> deck;
    private List<String> defausse;
    private List<String> main;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
}
