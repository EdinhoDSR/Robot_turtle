package robotturtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Fenetre extends JFrame{
    private JCheckBox j2 = new JCheckBox("2 joueurs");
    private JCheckBox j3 = new JCheckBox("3 joueurs");
    private JCheckBox j4 = new JCheckBox("4 joueurs");

    public Fenetre(){
    }

    public void fenterePlateau(){

        this.setTitle("Robot Turtle");
        this.setSize(1000, 1000);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void deplacerJoueur(Joueur joueur, int X, int Y){
        joueur.imageElement.setBounds(16+71*(X-1),15+71*(Y-1),71,71);
        this.repaint();
    }

    public void CreationDuMenu(){
        JLabel image =  new JLabel(new ImageIcon("\"TournerG.png\""));
        Main.fenetre.add(image);

        // créationde la banière d'acueille
        JLabel info = new JLabel("Bienvenue dans robot Turtle. Veuillez sélectionner le nombre de joueurs participants.");
        info.setPreferredSize(new Dimension(5000, 100));
        Main.fenetre.add(info);

        // case à cocher 2 joueurs
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deux_joueurs(e);
                    JLabel i = new JLabel("Biehfj;vfyhhkghjkljn");
                    Main.fenetre.removeAll();
                    Main.fenetre.add(i);
           //         Main.fenetre.updateUI();
    //                Main.fenetre.removeAll();
  //                  Main.fenetre.updateUI();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Main.fenetre.add(j2);

        // case à cocher 3 joueurs
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Main.fenetre.removeAll();
                try {
                    trois_joueurs(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        Main.fenetre.add(j3);

        // case à cocher 3 joueurs

        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    quatre_joueurs(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ;
        Main.fenetre.add(j4);

    }

    private void deux_joueurs (ActionEvent event) throws IOException {
        System.out.println("Vous avez sélectionner 2 joueurs ");
        Main.nombreDeJoueurs=2;




    }

    private void trois_joueurs (ActionEvent event) throws IOException {
        System.out.println("Vous avez sélectionner 3 joueurs ");
        Main.nombreDeJoueurs=3;
        System.out.println(Main.nombreDeJoueurs);




    }
    private void quatre_joueurs (ActionEvent event) throws IOException {
        System.out.println("Vous avez sélectionner 4 joueurs ");
        Main.nombreDeJoueurs=4;
        System.out.println(Main.nombreDeJoueurs);


    }


    }




