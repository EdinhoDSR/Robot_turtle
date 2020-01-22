package robotturtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Fenetre extends JFrame{
    JLabel jl;
    public static int i;
    public static boolean jouer = true;
    private static JFrame frame;
    private static JButton poserUnMurButton;
    private static JButton executerLeProgrammeButton;
    private static JButton ajouterUneCarteAuButton;
    private static JPanel p;
    private static JLabel lab;
    public static ArrayList<Joueur> listeDeJoueurs;


    public Fenetre(){


    }
    public static JButton cancel(Joueur joueur){
        JButton buttonC = new JButton("Retour");
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuTourDeJeu(joueur);
            }
        });
        return buttonC;
    }
    public static void valider(String texte){
        frame.dispose();
        JFrame frameV = new JFrame();
        frameV.setTitle("Validation");
        frameV.setVisible(true);
        frameV.setSize(240, 150);
        frameV.setLocationRelativeTo(null);

        JPanel panelV = new JPanel();

        JTextField textFieldV = new JTextField(texte);

        JButton buttonV = new JButton("Valider");

        panelV.add(textFieldV);
        panelV.add(buttonV);
        frameV.add(panelV);

        buttonV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameV.dispose();
                jouer = false;
            }
        });

    }
    public static void ajouterUneCarte(Joueur joueur){
        ajouterUneCarteAuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                JFrame frameAjoutCarte = new JFrame();
                frameAjoutCarte.setTitle("Selection de cartes");
                frameAjoutCarte.setVisible(true);
                frameAjoutCarte.setSize(240, 150);
                frameAjoutCarte.setLocationRelativeTo(null);

                JPanel panelCarte = new JPanel();
                panelCarte.setBackground(Color.black);

                ArrayList<JCheckBox> listeCB = new ArrayList<>();

                for(int i = 0; i < joueur.mainDujoueur.TailleDeck(); i++){
                    JCheckBox cb = new JCheckBox(joueur.mainDujoueur.getCard(i).toString());
                    listeCB.add(cb);
                    panelCarte.add(cb);
                }

                JButton valider = new JButton("Valider");
                panelCarte.add(valider);

                valider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String listeCartes ="";
                        ArrayList<Integer> A = new ArrayList<>();

                        for(int i = 0; i < listeCB.size();i++){

                            if(listeCB.get(i).isSelected()){
                                listeCartes = listeCartes + " " + listeCB.get(i).getText();
                                A.add(i);

                                frameAjoutCarte.dispose();

                            }
                        }
                        Collections.sort(A,Collections.reverseOrder());
                        for (Integer i:A) {
                            joueur.mainDujoueur.Defausse(joueur.mainDujoueur,joueur.programme,i);
                        }

                        valider("Vous avez placé les cartes : " + listeCartes);
                    }
                });
                frameAjoutCarte.add(panelCarte);
            }
        });
    }
    public static void executionProgramme(Joueur joueur){

        executerLeProgrammeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                frame.dispose();
                String listeCarteProgramme="Vous avez joué";


                for (int i = 0; i<joueur.programme.TailleDeck();i++) {

                    listeCarteProgramme = listeCarteProgramme + " " + joueur.programme.getCard(i).toString();
                    joueur.executionProgramme();
                }
                valider(listeCarteProgramme);

            }
        });
    }
    public static void defausse(Joueur joueur){
        //frame.dispose();

        JFrame frameDefausse = new JFrame();
        frameDefausse.setTitle("Defausse");
        frameDefausse.setVisible(true);
        frameDefausse.setSize(240, 150);
        frameDefausse.setLocationRelativeTo(null);
        frameDefausse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelDefausse = new JPanel();
        panelDefausse.setBackground(Color.black);

        JButton ouiButton = new JButton("OUI");
        JButton nonButton = new JButton("NON");

        panelDefausse.add(ouiButton);
        panelDefausse.add(nonButton);
        frameDefausse.add(panelDefausse);

        nonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameDefausse.dispose();
                jouer = false;
            }
        });
        ouiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameDefausse.dispose();

                JFrame frameAjoutCarte = new JFrame();
                frameAjoutCarte.setTitle("Selection de cartes");
                frameAjoutCarte.setVisible(true);
                frameAjoutCarte.setSize(240, 150);
                frameAjoutCarte.setLocationRelativeTo(null);

                JPanel panelCarte = new JPanel();
                panelCarte.setBackground(Color.black);

                ArrayList<JCheckBox> listeCB = new ArrayList<>();

                for(int i = 0; i < joueur.mainDujoueur.TailleDeck(); i++){
                    JCheckBox cb = new JCheckBox(joueur.mainDujoueur.getCard(i).toString());
                    listeCB.add(cb);
                    panelCarte.add(cb);
                }

                JButton valider = new JButton("Valider");
                panelCarte.add(valider);

                valider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ArrayList<Integer> A = new ArrayList<>();
                        String listeCartes ="";
                        for(int i = 0; i < listeCB.size();i++){
                            if(listeCB.get(i).isSelected()){
                                listeCartes = listeCartes + " " + listeCB.get(i).getText();
                                A.add(i);
                                frameAjoutCarte.dispose();

                            }
                        }
                        Collections.sort(A,Collections.reverseOrder());
                        for (Integer i:A) {
                            joueur.mainDujoueur.Defausse(joueur.mainDujoueur,joueur.defausse,i);
                        }
                        valider("Vous avez défaussé les cartes : " + listeCartes);
                    }
                });
                frameAjoutCarte.add(panelCarte);
            }
        });
    }
    public static void mur(Joueur joueur){

        poserUnMurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                JFrame frameMur = new JFrame();
                frameMur.setTitle("Selection type de mur");
                frameMur.setVisible(true);
                frameMur.setSize(240, 150);
                frameMur.setLocationRelativeTo(null);
                frameMur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panelMur = new JPanel();
                panelMur.setBackground(Color.black);

                JButton glaceButton = new JButton("Glace");
                JButton pierreButton = new JButton("Pierre");

                panelMur.add(glaceButton);
                panelMur.add(pierreButton);

                frameMur.add(panelMur);

                glaceButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int positionX;
                        int positionY;
                        if (joueur.mursGlace.TailleDeck() == 0){
                            frameMur.dispose();
                            valider("Vous n'avez pas de mur");
                            menuTourDeJeu(joueur);
                        }
                        else{
                            do{
                                positionX = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en X"));
                                positionY = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en Y"));
                            }while (positionX>9 || positionY>9 || Main.getPlateau()[positionY][positionX].getType()!='V');
                            Main.getPlateau()[positionY][positionX].glace();
                            joueur.mursGlace.removeCard(0);
                            valider("Mur posé");
                            frameMur.dispose();
                        }
                    }
                });

                pierreButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int positionX;
                        int positionY;
                        if (joueur.mursPierre.TailleDeck() == 0){
                            frameMur.dispose();
                            valider("Vous n'avez pas de mur");
                            menuTourDeJeu(joueur);
                        }
                        else{
                            do{
                                positionX = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en X"));
                                positionY = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en Y"));
                            }while (positionX>9 || positionY>9 || Main.getPlateau()[positionY][positionX].getType()!='V');
                            Main.getPlateau()[positionY][positionX].pierre();
                            joueur.mursPierre.removeCard(0);
                            valider("Mur posé");
                            frameMur.dispose();
                        }
                    }
                });

            }
        });
    }
    public static int initialisation(){

        JFrame frameMenu = new JFrame();
        frameMenu.setTitle("menuInitialisation");
        frameMenu.setVisible(true);
        frameMenu.setSize(270, 150);
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pMenu = new JPanel();
        pMenu.setBackground(Color.black);

        JButton Joueurs2Button = new JButton("2 Joueurs");
        Joueurs2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                listeDeJoueurs = Main.initialisation(2);
                for (Joueur joueur:listeDeJoueurs) {
                    menuTourDeJeu(joueur);
                }
                //Main.listeDeJoueur = Main.initialisation(2);


            }
        });

        JButton Joueurs3Button = new JButton("3 Joueurs");
        Joueurs3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                Main.initialisation(3);
                i=3;

                //Main.listeDeJoueur = Main.initialisation(3);

            }
        });

        JButton Joueurs4Button = new JButton("4 Joueurs");
        Joueurs4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                Main.initialisation(4);
                i=4;
                //listeDeJoueurs = Main.initialisation(4);
                //Main.listeDeJoueur = Main.initialisation(4);

            }
        });

        pMenu.add(Joueurs2Button);
        pMenu.add(Joueurs3Button);
        pMenu.add(Joueurs4Button);

        frameMenu.add(pMenu);
        return i;
    }
    public static void menuTourDeJeu(Joueur joueur){

        frame = new JFrame();
        frame.setTitle("Tour du joueur"+joueur.getNumero());
        frame.setVisible(true);
        frame.setSize(270, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.black);

        poserUnMurButton = new JButton("                  Poser un mur                  ");
        mur(joueur);

        executerLeProgrammeButton = new JButton("      Executer le programme         ");
        executionProgramme(joueur);

        ajouterUneCarteAuButton = new JButton("Ajouter une carte au programme");
        ajouterUneCarte(joueur);

        p.add(poserUnMurButton);
        p.add(executerLeProgrammeButton);
        p.add(ajouterUneCarteAuButton);
        frame.add(p);


    }

    public void fenterePlateau(){

        this.setTitle("Robot Turtle");
        this.setSize(600, 600);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        //JPanel contentPane =  (JPanel) this.getContentPane();
        //this.setContentPane(new Panneau());
        this.setVisible(true);
    }

    public void deplacerJoueur(Joueur joueur, int X, int Y){
        joueur.imageElement.setBounds(16+71*(X-1),15+71*(Y-1),71,71);
        this.repaint();
    }




}
