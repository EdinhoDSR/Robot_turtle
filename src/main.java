import java.util.*;
public class main {
    public Cases[][] plateau = new Cases[10][10];
    public static void main(String[] args) {
    }
    public void intitialisationTableau(){
        //initialise le plateau en créant un objet de la classe Cases par case. Par défault, les cases n'ont pas de pions sur elles.
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                Cases caseBoucle = new Cases(j,i,false);
                plateau[i][j] = caseBoucle;
            }
        }

    }


}















































/*
//plateau[y][x]
    public static Cases [][] plateau = new Cases[10][10];
    private static Scanner scanner = new Scanner(System.in);
    public static int nombreDeJoueurs;

    public static void main(String[] args) {
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













