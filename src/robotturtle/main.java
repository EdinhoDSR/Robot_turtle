package robotturtle;

import java.util.*;

public class main {


    private static Scanner scanner = new Scanner(System.in);
    public static int nombreDeJoueurs;
    public static Cases[][] plateau = new Cases[10][10];


    public static void main(String[] args) {

        initialisation(2);
        afficher();


    }



    private static void initialisation(int nombreJoueurs){
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
            Joueur J1 = new Joueur(1,2,1);
            plateau[1][2].setJoueur(J1);
            Joueur J2 = new Joueur(2,6,1);
            plateau[1][6].setJoueur(J2);

        }
        else if (nombreJoueurs==3){
            plateau[8][1].joyau();
            plateau[8][4].joyau();
            plateau[8][7].joyau();

            Joueur J1 = new Joueur(1,1,1);
            Joueur J2 = new Joueur(2,4,1);
            Joueur J3 = new Joueur(3,7,1);

            plateau[1][1].setJoueur(J1);
            plateau[1][4].setJoueur(J2);
            plateau[1][7].setJoueur(J3);
        }
        else if (nombreJoueurs==4){
            plateau[8][2].joyau();
            plateau[8][7].joyau();

            Joueur J1 = new Joueur(1,1,1);
            Joueur J2 = new Joueur(2,3,1);
            Joueur J3 = new Joueur(3,6,1);
            Joueur J4 = new Joueur(4,8,1);

            plateau[1][1].setJoueur(J1);
            plateau[1][3].setJoueur(J2);
            plateau[1][6].setJoueur(J3);
            plateau[1][8].setJoueur(J4);
        }

    }

    private static void afficher(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){System.out.print(plateau[i][j].getType());}// on a une ligne
            System.out.println();// on a le retour a la ligne
        }
    }




}















































/*
//plateau[y][x]
    public static robotturtle.Cases [][] plateau = new robotturtle.Cases[10][10];
    private static Scanner scanner = new Scanner(System.in);
    public static int nombreDeJoueurs;

    public static void robotturtle.main(String[] args) {
        System.out.println("Entrez le nombre de joueurs");
        int nombreDeJoueurs = Integer.parseInt(scanner.nextLine());
        initialisation(nombreDeJoueurs);
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                plateau[i][j]=


            }

        }
        afficher();



    }

    private static void initialisation(int nombreJoueurs){
        for (int x = 1; x < 9; x++) {//boucle qui fait le tableau jouable
            for (int y = 1; y < 9; y++) {
                plateau[y][x].setType('V');
            }
        }
        for (int i = 0; i < 10; i++) {// boucle qui fait les bords
            plateau[0][i].setType('O');
            plateau[9][i].setType('O');
            plateau[i][0].setType('O');
            plateau[i][9].setType('O');

        }
        if (nombreJoueurs==2 || nombreJoueurs==3){// rajoute des bords s'il y a moins de 4 joueurs
            for (int y = 0; y < 10; y++){plateau[y][8].setType('M');}
        }

        //Initialise les joueurs, les joyaux et leurs positions
        if (nombreJoueurs==2){
            plateau[8][4].joyau(8,4);

            plateau[1][2].joueur('S',1,2,1);
            plateau[1][6].joueur('S',1,6,2);


        }
        else if (nombreJoueurs==3){
            plateau[8][1].joyau(8,4);
            plateau[8][4].joyau(8,4);
            plateau[8][7].joyau(8,7);

            plateau[1][1].joueur('S',1,1,1);
            plateau[1][4].joueur('S',1,4,2);
            plateau[1][7].joueur('S',1,7,3);
        }
        else if (nombreJoueurs==4){
            plateau[8][2].joyau(8,2);
            plateau[8][7].joyau(8,7);

            plateau[1][1].joueur('S',1,1,1);
            plateau[1][3].joueur('S',1,3,2);
            plateau[1][6].joueur('S',1,6,3);
            plateau[1][8].joueur('S',1,8,4);
        }

    }





 */













