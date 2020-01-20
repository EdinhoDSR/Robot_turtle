package robotturtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Fenetre extends JFrame{
    JLabel jl;
    private static JFrame frame;
    private static JButton poserUnMurButton;
    private static JButton executerLeProgrammeButton;
    private static JButton ajouterUneCarteAuButton;
    private static JPanel p;
    private static JLabel lab;


    public Fenetre(){


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
                frameAjoutCarte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panelCarte = new JPanel();
                panelCarte.setBackground(Color.black);
            }
        });
    }
    public static void executionProgramme(Joueur joueur){

        executerLeProgrammeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String A="";
                ArrayList<String> listeCarteProgramme = new ArrayList<>();
                JFrame frameExecution = new JFrame();
                frameExecution.setTitle("Execution du programme");
                frameExecution.setVisible(true);
                frameExecution.setSize(240, 150);
                frameExecution.setLocationRelativeTo(null);
                frameExecution.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panelExecution = new JPanel();
                panelExecution.setBackground(Color.black);

                for (int i = 0; i<joueur.programme.TailleDeck();i++) {
                    listeCarteProgramme.add(joueur.programme.getCard(i).toString());
                    A = A + "\n" + joueur.programme.getCard(i).toString();
                }
                JTextField carteProgrammes = new JTextField();
                carteProgrammes.setText(A);
                panelExecution.add(carteProgrammes);
                frameExecution.add(panelExecution);
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
                            panelMur.removeAll();
                            JTextField output = new JTextField();
                            output.setText("Vous n'avez pas de murs de glace");
                            panelMur.add(output);
                            frameMur.repaint();
                            menuTourDeJeu(joueur);
                        }
                        else{
                            do{
                                positionX = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en X"));
                                positionY = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en Y"));
                            }while (positionX>9 || positionY>9 || Main.plateau[positionY][positionX].getType()!='V');
                            Main.plateau[positionY][positionX].setType('G');
                            joueur.mursGlace.removeCard(0);
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
                            panelMur.removeAll();
                            JTextField output = new JTextField();
                            output.setText("Vous n'avez pas de murs de pierre");
                            panelMur.add(output);
                            frameMur.repaint();
                            menuTourDeJeu(joueur);
                        }
                        else{
                            do{
                                positionX = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en X"));
                                positionY = Integer.parseInt(JOptionPane.showInputDialog(null,"Entrez la position en Y"));
                            }while (positionX>9 || positionY>9 || Main.plateau[positionY][positionX].getType()!='V');
                            Main.plateau[positionY][positionX].setType('P');
                            joueur.mursPierre.removeCard(0);
                            frameMur.dispose();
                        }
                    }
                });

            }
        });
    }
    public static void initialisation(){
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
                Main.initialisation(2);
                Main.afficher();
            }
        });
        JButton Joueurs3Button = new JButton("3 Joueurs");
        Joueurs3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.initialisation(3);
            }
        });
        JButton Joueurs4Button = new JButton("4 Joueurs");
        Joueurs4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.initialisation(4);
            }
        });

        pMenu.add(Joueurs2Button);
        pMenu.add(Joueurs3Button);
        pMenu.add(Joueurs4Button);

        frameMenu.add(pMenu);
    }
    public static void menuTourDeJeu(Joueur joueur){

        frame = new JFrame();
        frame.setTitle("menuTourDeJeu");
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
