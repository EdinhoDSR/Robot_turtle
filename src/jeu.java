import java.util.*;
public class jeu {
    //plateau[y][x]
    public static objetJeu [][] plateau = new objetJeu[10][10];
    private static Scanner scanner = new Scanner(System.in);
    public static int nombreDeJoueurs;
    public static void main(String[] args) {
        System.out.println("Entrez le nombre de joueurs");
        int nombreDeJoueurs = Integer.parseInt(scanner.nextLine());
        initialisation(nombreDeJoueurs);
        afficher();
        Joueur J1 = new Joueur('N',1,5,1);
        J1.setPositionX(2);
        System.out.println("J"+1+"="+J1.getPositionX());
        System.out.println("J"+1+"="+J1.getDirection());
        J1.tournerD();
        System.out.println("J"+1+"="+J1.getDirection());
        J1.tournerG();
        System.out.println("J"+1+"="+J1.getDirection());
        "J1".avancer()

    }
    private static void initialisation(int nombreJoueurs){
            for (int x = 1; x < 9; x++) {//boucle qui fait le tableau jouable
                for (int y = 1; y < 9; y++) {
                    plateau[y][x] = ".";
                }
            }
            for (int i = 0; i < 10; i++) {// boucle qui fait les bords
                plateau[0][i] = "MurDePierre";
                plateau[9][i] = "MurDePierre";
                plateau[i][0] = "MurDePierre";
                plateau[i][9] = "MurDePierre";
            }
            if (nombreJoueurs==2 || nombreJoueurs==3){// rajoute des bords s'il y a moins de 4 joueurs
                for (int y = 0; y < 10; y++){plateau[y][8]="O";}
            }
        plateau[1][2]="E";
    }
    private static void afficher(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){System.out.print(plateau[i][j]);}// on a une ligne
            System.out.println();// on a le retour a la ligne
        }
    }



    }

