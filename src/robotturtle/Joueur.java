package robotturtle;

import java.util.List;

public class Joueur extends Cases{

    public int numero,positionXDepart,positionYDepart;
    public char direction;
    public List<String> defausse,main,deck;

    public Joueur(int pNumero, int pPositionXDepart, int pPositionYDepart){

        this.positionXDepart = pPositionXDepart;
        this.positionYDepart = pPositionYDepart;
        this.numero = pNumero;
        this.direction = 'S';

    }
    private void laser(Cases[][] plateau,int nombreDeJoueur){
        if (this.direction == 'N'){// Cas où le joueur regarde vers le nord
            for (int i = 0;i<plateau.length-this.getPositionY();i++){
                Cases caseEnCours = plateau[this.getPositionY()-i][this.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart(plateau);
                        caseEnCours.joueur.retourCaseDepart(plateau);
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart(plateau);
                    break;
                }
            }
        }
        if (this.direction == 'S'){// Cas où le joueur regarde vers le Sud
            for (int i = joueur.getPositionY();i<plateau.length;i++){
                Cases caseEnCours = plateau[i][joueur.getPositionX()];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart(plateau);
                        caseEnCours.joueur.retourCaseDepart(plateau);
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart(plateau);
                    break;
                }
            }
        }
        if (joueur.direction == 'E'){// Cas où le joueur regarde vers l'Est
            for (int i = joueur.getPositionX();i<plateau.length;i++){
                Cases caseEnCours = plateau[joueur.getPositionY()][i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart(plateau);
                        caseEnCours.joueur.retourCaseDepart(plateau);
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart(plateau);
                    break;
                }
            }
        }
        if (joueur.direction == 'O'){// Cas où le joueur regarde vers l'ouest
            for (int i = 0;i<plateau.length-joueur.getPositionX();i++){
                Cases caseEnCours = plateau[joueur.getPositionY()][joueur.getPositionX()-i];
                if (caseEnCours.type == 'G'){
                    caseEnCours.setType('V');
                    break;
                }
                if (caseEnCours.type == 'J'){
                    if (nombreDeJoueur == 2){// si il y a que deux joueurs, le joueur fait demi-tour
                        caseEnCours.joueur.demiTour();
                        break;
                    }
                    if (nombreDeJoueur >2){//Si il y en a plus, les deux joueur reviennent à leur case initiale
                        this.retourCaseDepart(plateau);
                        caseEnCours.joueur.retourCaseDepart(plateau);
                        break;
                    }
                }
                if (caseEnCours.getType()=='j'){
                    this.retourCaseDepart(plateau);
                    break;
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
    public void retourCaseDepart(Cases[][] plateau){
        int X = this.getPositionX();
        int Y = this.getPositionY();
        this.setPositionX(this.positionXDepart);
        this.setPositionY(this.positionYDepart);
        plateau[joueur.positionYDepart][joueur.positionXDepart].joueur = this;
        plateau[joueur.positionYDepart][joueur.positionXDepart].type = 'J';
        plateau[Y][X].setType('V');
    }


/*

    public robotturtle.Joueur( char pDriection, int pPositionX, int pPositionY)
    {
        System.out.println("Création d'un joueur avec des paramètres !");
        positionXDepart = pPositionX;
        positionYDepart = pPositionY;
        direction = pDriection;
    }
    public void avancer(){

        //C'est fait en fonction du nombre de joueur reste plus qu'à changer la place du joueur dans le tableau
        if(this.direction=='N'){
            if(robotturtle.main.plateau[this.casePlateau.getPositionY()-1][this.casePlateau.getPositionX()].this.casePlateau.getType() == 'V'){
                robotturtle.main.plateau[this.positionY][this.positionX].remove();
                this.positionX=this.positionXDepart;
                this.positionY=this.positionYDepart;
            }
            else if(robotturtle.main.plateau[this.positionY-1][this.positionX].getType() == 'M'){
                robotturtle.main.plateau[this.positionY][this.positionX].remove();
                robotturtle.main.plateau[this.positionY][this.positionX].demiTour();
            }
            else if(robotturtle.main.plateau[this.positionY-1][this.positionX].getType() == 'J'){
                robotturtle.main.plateau[this.positionY][this.positionX].remove();
                robotturtle.main.plateau[this.positionY][this.positionX].demiTour();
                robotturtle.main.plateau[this.positionY-1][this.positionX].demiTour();
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

    public void setDeck(robotturtle.Deck deck) {
        robotturtle.Deck = deck;
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
        return robotturtle.main;
    }

    public void setMain(List<String> robotturtle.main) {
        this.robotturtle.main = robotturtle.main;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public robotturtle.Cases(char pDriection, int pPositionX, int pPositionY)
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
        robotturtle.Deck = new robotturtle.Deck();
        type = 'J';
    }

    public void joyau( int pPositionY, int pPositionX){
        type = 'j';
        positionY = pPositionY;
        positionX = pPositionX;
    }

    public void remove(){
        robotturtle.main.plateau[this.positionY][this.positionX].setType('V');

    }



*/
    }

