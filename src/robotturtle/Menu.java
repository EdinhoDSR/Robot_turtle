package robotturtle;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public  class Menu extends JFrame {
    private JCheckBox j2 = new JCheckBox("2 joueurs");
    private JCheckBox j3 = new JCheckBox("3 joueurs");
    private JCheckBox j4 = new JCheckBox("4 joueurs");


    public Menu() throws MalformedURLException {
        super("My first java application");
        // ferme la fenêtre apres avoir appuyer sur X
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // definit la taille d'une fenêtre
        this.setSize(1000, 1000);
        // position
//        this.setLocation(100,100);
        // centre par rapport un objet
        this.setLocationRelativeTo(null);

    }

        public void creerfenêtre() {
            // conmposant graphique qui va contenir d'autres élements graphiques
            JPanel contentPane = (JPanel) this.getContentPane();
            //aligne les élements de la fenêtre
            contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
//            f2.setLayout(new FlowLayout(FlowLayout.LEFT));

            // alignement en colonne
//        contentPane.setLayout(new GridLayout(5, 1, 0, 0));

            //alignement selon N S E O C
//        contentPane.setLayout(new BorderLayout());


        JLabel image =  new JLabel(new ImageIcon("\"TournerG.png\""));
        contentPane.add(image);

            // créationde labanière d'acueille

            JLabel info = new JLabel("Bienvenue dans robot Turtle. Veuillez sélectionner le nombre de joueurs participants.");
            info.setPreferredSize(new Dimension(5000, 100));
            contentPane.add(info);

//        JScrollPanel
            // controle dela taillepréféreée
            // setPrefferedSize(new dimension(x,y);


        // case à cocher 2 joueurs
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deux_joueurs(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                ;
            }
        });
        contentPane.add(j2);


        // case à cocher 3 joueurs

        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                try {
                    trois_joueurs(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        contentPane.add(j3);

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
        contentPane.add(j4);

    }

    private void deux_joueurs (ActionEvent event) throws IOException {
        System.out.println("Vous avez sélectionner 2 joueurs ");
        Main.nombreDeJoueurs=2;
        Main.run();


    }

    private void trois_joueurs (ActionEvent event) throws IOException {
        System.out.println("Vous avez sélectionner 3 joueurs ");
        Main.nombreDeJoueurs=3;
        Main.run();



    }
    private void quatre_joueurs (ActionEvent event) throws IOException {
        System.out.println("Vous avez sélectionner 4 joueurs ");
        Main.nombreDeJoueurs=4;
        Main.run();

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, MalformedURLException {
        // change de look
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // création de la fenetre
        Menu myWindow= new Menu();
        myWindow.creerfenêtre();


        // aficher la fenêtre
        myWindow.setVisible(true);


    }

}
