package robotturtle;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        JPanel contentPane =  (JPanel) this.getContentPane();
        this.setContentPane(new Panneau());
        this.setVisible(true);
    }
}
