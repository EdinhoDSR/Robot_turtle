package robotturtle;
import javax.swing.*;
import java.awt.Toolkit;

public class Fenetre extends JFrame{

    public Fenetre(){


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
