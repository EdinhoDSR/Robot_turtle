package robotturtle;

import javax.swing.*;
import java.util.*;

public class Main {


    private static Scanner scanner = new Scanner(System.in);
    public static int nombreDeJoueurs;
    public static Cases[][] plateau = new Cases[10][10];
    public static ArrayList<Joueur> listeDeJoueur = new ArrayList<>();
    public static Fenetre fenetre = new Fenetre();
    public static JLabel plateauVisu = new JLabel(new ImageIcon("plateau.png"));


    public static void main(String[] args) {

        run();


    }


    private static ArrayList<Joueur> initialisation(int nombreJoueurs){

        ArrayList<Joueur> listeJoueur = new ArrayList<>();

        plateauVisu.setBounds(0,0,600,600);

        for (int i=0;i<10;i++){// boucle qui fait les cases vides
            for (int j=0;j<10;j++){
                Cases caseBoucle = new Cases(j,i);
                plateau[i][j] = caseBoucle;
            }
        }

        for (int i = 0; i < 10; i++) {// boucle qui fait les bords
            plateau[0][i].pierre();
            plateau[9][i].pierre();
            plateau[i][0].pierre();
            plateau[i][9].pierre();
        }
        if (nombreJoueurs==2 || nombreJoueurs==3){// rajoute des bords s'il y a moins de 4 joueurs
            for (int y = 0; y < 10; y++){plateau[y][8].pierre();}
        }

        //Initialise les joueurs, les joyaux et leurs positions
        if (nombreJoueurs==2){

            plateau[8][4].joyau();
            Joueur J1 = new Joueur(1,2,1,"leonardo.png");
            plateau[1][2].setJoueur(J1);
            Joueur J2 = new Joueur(2,6,1,"raphael.png");
            plateau[1][6].setJoueur(J2);

            listeJoueur.add(J1);
            listeJoueur.add(J2);


            fenetre.deplacerJoueur(J1,J1.getPositionX(),J1.getPositionY());
            fenetre.deplacerJoueur(J2,J2.getPositionX(),J1.getPositionY());
            fenetre.add(J1.imageElement);
            fenetre.add(J2.imageElement);
            fenetre.add(plateauVisu);
            fenetre.repaint();


        }
        else if (nombreJoueurs==3){
            plateau[8][1].joyau();
            plateau[8][4].joyau();
            plateau[8][7].joyau();

            Joueur J1 = new Joueur(1,1,1,"leonardo.png");
            Joueur J2 = new Joueur(2,4,1,"raphael.png");
            Joueur J3 = new Joueur(3,7,1,"donatello.png");

            plateau[1][1].setJoueur(J1);
            plateau[1][4].setJoueur(J2);
            plateau[1][7].setJoueur(J3);

            listeJoueur.add(J1);
            listeJoueur.add(J2);
            listeJoueur.add(J3);

            fenetre.deplacerJoueur(J1,J1.getPositionX(),J1.getPositionY());
            fenetre.deplacerJoueur(J2,J2.getPositionX(),J1.getPositionY());
            fenetre.deplacerJoueur(J3,J3.getPositionX(),J3.getPositionY());
            fenetre.add(J1.imageElement);
            fenetre.add(J2.imageElement);
            fenetre.add(J3.imageElement);
            fenetre.add(plateauVisu);
            fenetre.repaint();
        }
        else if (nombreJoueurs==4){
            plateau[8][2].joyau();
            plateau[8][7].joyau();

            Joueur J1 = new Joueur(1,1,1,"leonardo.png");
            Joueur J2 = new Joueur(2,3,1,"raphael.png");
            Joueur J3 = new Joueur(3,6,1,"donatello.png");
            Joueur J4 = new Joueur(4,8,1,"leonardo.png");

            plateau[1][1].setJoueur(J1);
            plateau[1][3].setJoueur(J2);
            plateau[1][6].setJoueur(J3);
            plateau[1][8].setJoueur(J4);

            listeJoueur.add(J1);
            listeJoueur.add(J2);
            listeJoueur.add(J3);
            listeJoueur.add(J4);

            fenetre.deplacerJoueur(J1,J1.getPositionX(),J1.getPositionY());
            fenetre.deplacerJoueur(J2,J2.getPositionX(),J1.getPositionY());
            fenetre.deplacerJoueur(J3,J3.getPositionX(),J3.getPositionY());
            fenetre.deplacerJoueur(J4,J4.getPositionX(),J4.getPositionY());
            fenetre.add(J1.imageElement);
            fenetre.add(J2.imageElement);
            fenetre.add(J3.imageElement);
            fenetre.add(J4.imageElement);
            fenetre.add(plateauVisu);
            fenetre.repaint();

        }
        return listeJoueur;
    }

    private static void afficher(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){System.out.print(plateau[i][j].getType());}// on a une ligne
            System.out.println();// on a le retour a la ligne
        }
    }

    public static void run(){

        fenetre.fenterePlateau();


        System.out.println("Combien de joueurs?");
        nombreDeJoueurs = scanner.nextInt();
        ArrayList<Joueur>listeDeJoueur = initialisation(nombreDeJoueurs);
        while (listeDeJoueur.size() >1){
            for (Joueur joueur : listeDeJoueur) {
                System.out.println("tour du joueur "+joueur.getNumero());
                afficher();
                tourDeJeu(joueur);
                defausseJoueur(joueur);
                remplissageMain(joueur);
                joueur.affichage();
                if(listeDeJoueur.size() == 1){break;}
            }
        }
        System.out.println("Fin de la partie");
    }

    public static void tourDeJeu(Joueur joueur){
        boolean finie = false;
        while(finie== false){
            System.out.println("Mur? Programme? Execution?");
            String choix = scanner.nextLine();
            switch (choix){
                case "Mur":


                    System.out.println("Quel type de mur? (Glace/Pierre)");
                    String typeDeMur = scanner.nextLine();
                    if (typeDeMur.equals("Pierre")) {
                                if (joueur.mursPierre.TailleDeck() == 0) {
                                    System.out.println("Pas de murs");
                                    break;
                                }
                            }
                    if (typeDeMur.equals("Glace")) {
                                if (joueur.mursGlace.TailleDeck() == 0) {
                                    System.out.println("Pas de murs");
                                    break;
                                }
                            }
                    poserMur(typeDeMur);
                    finie = true;
                    break;
                case "Execution" :
                    joueur.executionProgramme();
                    System.out.println("programme execute");
                    finie=true;
                    break;
                case "Programme":
                    boolean continuer = true;
                    while (continuer == true && joueur.mainDujoueur.TailleDeck()>0) {
                        System.out.println("Veuillez sélectionner la carte à ajouter au programme");
                        joueur.affichage();
                        int i = Integer.parseInt(scanner.nextLine());
                        joueur.programme.ajouter_programme(joueur.mainDujoueur, i);
                        System.out.println("Voulez-vous prendre une autre carte? (oui/non)");
                        String choixMain = scanner.nextLine();
                        if (choixMain.equals("non")){
                            continuer = false;
                        }
                    }
                    finie = true;
                    break;
                }
        }

    }
    public static void defausseJoueur(Joueur joueur){
        System.out.println("Souhaitez vous vous défausser de cartes");
        String choix = scanner.nextLine();
        if (choix.equals("oui")){
            joueur.affichage();
            System.out.println("Combien de cartes voulez vous défausser");
            ArrayList<Integer> tableNumeroCarteADefausser = new ArrayList<>();
            int nombreDeCartesADefausser = Integer.parseInt(scanner.nextLine());
            System.out.println("Entrez le numéro des cartes");
            for(int j=0; j<nombreDeCartesADefausser; j++){
                int numeroDesCartesADefausser = Integer.parseInt(scanner.nextLine());
                tableNumeroCarteADefausser.add(numeroDesCartesADefausser);
            }
            Collections.sort(tableNumeroCarteADefausser,Collections.reverseOrder());
            for (Integer i : tableNumeroCarteADefausser) {
                joueur.programme.Defausse(joueur.mainDujoueur,joueur.defausse,i);
            }
        }
    }
    public static void remplissageMain(Joueur joueur) {
        while (joueur.mainDujoueur.TailleDeck() < 5) {
            if (joueur.deck.TailleDeck() == 0) {
                joueur.deck = joueur.defausse;
                joueur.defausse.vider();
                joueur.deck.mélanger();
                joueur.mainDujoueur.draw(joueur.deck);
            } else {
                joueur.mainDujoueur.draw(joueur.deck);
            }
        }
    }
    public static void poserMur(String typeMur){
        int X;
        int Y;
        do{
            System.out.println("Entrez X");
            X = Integer.parseInt(scanner.nextLine());
            System.out.println("Entrez Y");
            Y = Integer.parseInt(scanner.nextLine());

        } while(X>9 || Y>9 || plateau[Y][X].getType()!='V');
        if (typeMur.equals("Glace")){
            plateau[Y][X].glace();
            System.out.println("oui?");
        }
        if (typeMur.equals("Pierre")){
            plateau[Y][X].pierre();
        }
    }

}

