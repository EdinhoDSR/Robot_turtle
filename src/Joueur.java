import java.util.List;

public class Joueur extends Cases{

    public int numero,positionXDepart,positionYDepart;
    public char direction;
    public List<String> defausse,main,deck;

    public Joueur(int pNumero){

        this.type = 'J'; //Initialise le type à 'J'
        this.numero = pNumero;
        this.direction = 'S';
        this.positionXDepart = positionX;
        this.positionYDepart = positionY;
    }
    private void laser(Joueur joueur){
        if (joueur.direction == 'N'){// Cas où le joueur regarde vers le nord
            for (int i = 0;i<main.plateau.length()-joueur.getPositionY();i++){
                Cases caseEnCours = (main.plateau[joueur.getPositionY()-i][joueur.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    caseEnCours.setOccupe(false);
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (main.nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.demiTour(); // ne pas oublier de coder demiTour()
                        break;
                    }
                    if (main.nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        int X = joueur.getPositionX();
                        int Y = joueur.getPositionY();
                        joueur.setPositionX(joueur.positionXDepart);
                        joueur.setPositionY(joueur.positionYDepart);
                        main.plateau[Y][X].setOccupe(false);
                        main.plateau[Y][X].setType('V');
                        main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                        int X = caseEnCours.getPositionX();
                        int Y = caseEnCours.getPositionY();
                        caseEnCours.setPositionX(joueur.positionXDepart);
                        caseEnCours.setPositionY(joueur.positionYDepart);
                        main.plateau[Y][X].setOccupe(false);
                        main.plateau[Y][X].setType('V');
                        main.plateau[caseEnCours.positionYDepart][caseEnCours.positionXDepart] = joueur;
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    int X = joueur.getPositionX();
                    int Y = joueur.getPositionY();
                    joueur.setPositionX(joueur.positionXDepart);
                    joueur.setPositionY(joueur.positionYDepart);
                    main.plateau[Y][X].setOccupe(false);
                    main.plateau[Y][X].setType('V');
                    main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                }
            }
        }
        if (joueur.direction == 'S'){// Cas où le joueur regarde vers le Sud
            for (int i = joueur.getPositionY();i<main.plateau.length();i++){
                Cases caseEnCours = (main.plateau[i][joueur.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    caseEnCours.setOccupe(false);
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (main.nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.demiTour(); // ne pas oublier de coder demiTour()
                        break;
                    }
                    if (main.nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        int X = joueur.getPositionX();
                        int Y = joueur.getPositionY();
                        joueur.setPositionX(joueur.positionXDepart);
                        joueur.setPositionY(joueur.positionYDepart);
                        main.plateau[Y][X].setOccupe(false);
                        main.plateau[Y][X].setType('V');
                        main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                        int X = caseEnCours.getPositionX();
                        int Y = caseEnCours.getPositionY();
                        caseEnCours.setPositionX(joueur.positionXDepart);
                        caseEnCours.setPositionY(joueur.positionYDepart);
                        main.plateau[Y][X].setOccupe(false);
                        main.plateau[Y][X].setType('V');
                        main.plateau[caseEnCours.positionYDepart][caseEnCours.positionXDepart] = joueur;
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    int X = joueur.getPositionX();
                    int Y = joueur.getPositionY();
                    joueur.setPositionX(joueur.positionXDepart);
                    joueur.setPositionY(joueur.positionYDepart);
                    main.plateau[Y][X].setOccupe(false);
                    main.plateau[Y][X].setType('V');
                    main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                }
            }
            if (joueur.direction == 'E'){// Cas où le joueur regarde vers l'Est
                for (int i = joueur.getPositionX();i<main.plateau.length();i++){
                    Cases caseEnCours = (main.plateau[joueur.getPositionY()][i];
                    if (caseEnCours.type == 'G'){
                        caseEnCours.setType('V');
                        caseEnCours.setOccupe(false);
                        break;
                    }
                    if (caseEnCours.type == 'J'){
                        if (main.nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                            caseEnCours.demiTour(); // ne pas oublier de coder demiTour()
                            break;
                        }
                        if (main.nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                            int X = joueur.getPositionX();
                            int Y = joueur.getPositionY();
                            joueur.setPositionX(joueur.positionXDepart);
                            joueur.setPositionY(joueur.positionYDepart);
                            main.plateau[Y][X].setOccupe(false);
                            main.plateau[Y][X].setType('V');
                            main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                            int X = caseEnCours.getPositionX();
                            int Y = caseEnCours.getPositionY();
                            caseEnCours.setPositionX(joueur.positionXDepart);
                            caseEnCours.setPositionY(joueur.positionYDepart);
                            main.plateau[Y][X].setOccupe(false);
                            main.plateau[Y][X].setType('V');
                            main.plateau[caseEnCours.positionYDepart][caseEnCours.positionXDepart] = joueur;
                            break;
                        }
                    }
                    if (caseEnCours.getType()=='j'){
                        int X = joueur.getPositionX();
                        int Y = joueur.getPositionY();
                        joueur.setPositionX(joueur.positionXDepart);
                        joueur.setPositionY(joueur.positionYDepart);
                        main.plateau[Y][X].setOccupe(false);
                        main.plateau[Y][X].setType('V');
                        main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                    }
                }
                if (joueur.direction == 'O'){// Cas où le joueur regarde vers l'ouest
                    for (int i = 0;i<main.plateau.length()-joueur.casePlateau.getPositionX();i++){
                        Cases caseEnCours = (main.plateau[joueur.getPositionY()][joueur.getPositionX()-i];
                        if (caseEnCours.type == 'G'){
                            caseEnCours.setType('V');
                            caseEnCours.setOccupe(false);
                            break;
                        }
                        if (caseEnCours.type == 'J'){
                            if (main.nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                                caseEnCours.demiTour(); // ne pas oublier de coder demiTour()
                                break;
                            }
                            if (main.nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                                int X = joueur.getPositionX();
                                int Y = joueur.getPositionY();
                                joueur.setPositionX(joueur.positionXDepart);
                                joueur.setPositionY(joueur.positionYDepart);
                                main.plateau[Y][X].setOccupe(false);
                                main.plateau[Y][X].setType('V');
                                main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                                int X = caseEnCours.getPositionX();
                                int Y = caseEnCours.getPositionY();
                                caseEnCours.setPositionX(joueur.positionXDepart);
                                caseEnCours.setPositionY(joueur.positionYDepart);
                                main.plateau[Y][X].setOccupe(false);
                                main.plateau[Y][X].setType('V');
                                main.plateau[caseEnCours.positionYDepart][caseEnCours.positionXDepart] = joueur;
                                break;
                            }
                        }
                        if (caseEnCours.getType()=='j'){
                            int X = joueur.getPositionX();
                            int Y = joueur.getPositionY();
                            joueur.setPositionX(joueur.positionXDepart);
                            joueur.setPositionY(joueur.positionYDepart);
                            main.plateau[Y][X].setOccupe(false);
                            main.plateau[Y][X].setType('V');
                            main.plateau[joueur.positionYDepart][joueur.positionXDepart] = joueur;
                        }
                    }
                }
            }
        }


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
    public void demiTour(){
        this.tournerG();
        this.tournerG();
    }


/*

    public Joueur( char pDriection, int pPositionX, int pPositionY)
    {
        System.out.println("Création d'un joueur avec des paramètres !");
        positionXDepart = pPositionX;
        positionYDepart = pPositionY;
        direction = pDriection;
    }
    public void avancer(){

        //C'est fait en fonction du nombre de joueur reste plus qu'à changer la place du joueur dans le tableau
        if(this.direction=='N'){
            if(main.plateau[this.casePlateau.getPositionY()-1][this.casePlateau.getPositionX()].this.casePlateau.getType() == 'V'){
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
    public void initPositionDebut(int posX,int posY){
        this.setPositionX(posX);
        this.setPositionXDepart(posX);
        this.setPositionY(posY);
        this.setPositionYDepart(posY);
        jeu.plateau[this.getPositionY()][this.getPositionX()] = "J1";
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
                        .tournerD();
                        this.tournerD();
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



*/
    }

