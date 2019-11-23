import java.util.*;
public class jeu {
    //plateau[y][x]
    public static String [][] plateau = new String[10][10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialisation(2);
        afficher();
        Joueur J1 = new Joueur('D',1,5);
        J1.positionX = 2;
        System.out.println("J"+Integer.toString(1)+"="+J1.positionX);
    }
    public static void initialisation(int nombreJoueurs){
            for (int x = 1; x < 9; x++) {//boucle qui fait le tableau jouable
                for (int y = 1; y < 9; y++) {
                    plateau[y][x] = ".";
                }
            }
            for (int i = 0; i < 10; i++) {// boucle qui fait les bords
                plateau[0][i] = "O";
                plateau[9][i] = "O";
                plateau[i][0] = "O";
                plateau[i][9] = "O";
            }
            if (nombreJoueurs==2 || nombreJoueurs==3){// rajoute des bords s'il y a moins de 4 joueurs
                for (int y = 0; y < 10; y++){plateau[y][8]="O";}
            }
        plateau[1][2]="E";
    }
    public static void afficher(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){System.out.print(plateau[i][j]);}// on a une ligne
            System.out.println("");// on a le retour a la ligne
        }
    }
}
