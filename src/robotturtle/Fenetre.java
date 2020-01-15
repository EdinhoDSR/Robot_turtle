package robotturtle;
import javax.swing.*;
import java.awt.Toolkit;

public class Fenetre extends JFrame{

    public Fenetre(){


    }

    public void fenterePlateau(){

        this.setTitle("Robot Turtle");
        this.setSize(700, 700);
        //this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        //JPanel contentPane =  (JPanel) this.getContentPane();
        //this.setContentPane(new Panneau());
        this.setVisible(true);
    }

    public void deplacerJoueur(Joueur joueur, int X, int Y){
        joueur.imageJoueur.setBounds(13+82*X,82*Y,82,82);
        this.repaint();
    }


}
