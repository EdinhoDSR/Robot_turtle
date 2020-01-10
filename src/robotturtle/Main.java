package robotturtle;

import java.util.*;

public class Main {


    private static Scanner scanner = new Scanner(System.in);
    public static int nombreDeJoueurs;
    public static Cases[][] plateau = new Cases[10][10];
    public static ArrayList<Joueur> listeDeJoueur = new ArrayList<>();


    public static void main(String[] args) {


    }



    private static ArrayList<Joueur> initialisation(int nombreJoueurs){

        ArrayList<Joueur> listeJoueur = new ArrayList<>();

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

            listeJoueur.add(J1);
            listeJoueur.add(J2);

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

            listeJoueur.add(J1);
            listeJoueur.add(J2);
            listeJoueur.add(J3);
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

            listeJoueur.add(J1);
            listeJoueur.add(J2);
            listeJoueur.add(J3);
            listeJoueur.add(J4);

        }
        return listeJoueur;
    }

    private static void afficher(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){System.out.print(plateau[i][j].getType());}// on a une ligne
            System.out.println();// on a le retour a la ligne
        }
    }

    public void run(){
        ArrayList<Joueur>listeDeJoueur = initialisation(2);
        while (listeDeJoueur.size() >1){
            for (Joueur joueur : listeDeJoueur) {
                tourDeJeu(joueur);
                if(listeDeJoueur.size() == 1){break;}
            }
        }
        System.out.println("Fin de la partie");
    }

    public void tourDeJeu(Joueur joueur){
        System.out.println("Mur?Programme?Execution?");
        String choix = scanner.nextLine();
        int flag =0;
        while(flag == 0){
            switch(choix){

                case "Mur":
                    flag =1;
                    System.out.println("Quel type de mur? (Glace/Pierre)");
                    String typeDeMur = scanner.nextLine();
                    if (typeDeMur.equals("Pierre")){
                        if (joueur.listeMurs[1].TailleDeck() == 0){
                            System.out.println("Pas de murs");
                            break;
                        }
                    }
                    if (typeDeMur.equals("Glace")){
                        if (joueur.listeMurs[0].TailleDeck() == 0){
                            System.out.println("Pas de murs");
                            break;
                        }
                    }
                    int X;
                    int Y;
                    do{
                        System.out.println("X");
                        X = scanner.nextInt();
                        System.out.println("Y");
                        Y = scanner.nextInt();
                    } while(X>9 || Y>9 || plateau[Y][X].getType()!='V');
                    if (typeDeMur.equals("Glace")){
                        plateau[Y][X].glace();
                    }
                    if (typeDeMur.equals("Pierre")){
                        plateau[Y][X].pierre();
                    }
                case "Programme":
                    System.out.println("Voici les cartes dans votre programme");
                    System.out.println((joueur.programme);
                    int flag1=0;
                    while (flag1==0) {
                        System.out.println("Voulez vous ajouter une carte au programme");
                        String choix1= scanner.nextLine();
                        switch(choix1) {
                            case "oui":
                                System.out.println("Veuillez sélectionner la carte à ajouter au programme");
                                System.out.println( joueur.programme);
                                int i= scanner.nextInt();
                                joueur.programme.ajouter_programme  (joueur.mainDujoueur,i);
                                break;

                            case "non":
                                System.out.println("Voici les cartes dans votre programme");
                                System.out.println((joueur.programme));
                                flag1=1;
                                flag=1;
                                break

                            default:
                                System.out.println("Choix incorrect, veuillez taper oui ou non !!!!!");
                                break;
                        }
                    }

                case "Execution" :
                    joueur.Programme();
                    flag=1;

                default : System.out.println("Trompé");

            }

            int flag3=0;
            while(flag3==0){
                System.out.println( "Souhaitez vous défausser une carte ");
                String choix2 =  scanner.nextLine();
                switch(choix2) {
                    case "oui":
                        System.out.println("Veuillez sélectionner la carte à défausser ");
                        System.out.println( joueur.mainDujoueur);
                        int i= scanner.nextInt();
                        joueur.defausse.Defausse(joueur.mainDujoueur,joueur.defausse,i);
                        break;

                    case "non":
                        flag3=1;
                        break
                    default:
                        System.out.println("Choix incorrect, veuillez taper oui ou non !!!!!");
                        break;


                }
            }
                while (joueur.mainDujoueur.TailleDeck() <5){
                    if (joueur.deck.TailleDeck()==0){
                        joueur.deck=joueur.defausse;
                        joueur.defausse.vider();
                        joueur.deck.mélanger();
                    }
                    else{
                    joueur.mainDujoueur.draw(joueur.deck);
                }
            }

        }


    }


}

