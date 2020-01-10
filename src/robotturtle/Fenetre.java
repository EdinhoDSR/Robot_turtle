package robotturtle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class Fenetre extends JFrame{
    public Fenetre(){
        this.setTitle("Robot Turtle");
        this.setSize(400, 500);
        this.setUndecorated(true);
        //this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel contentPane =  (JPanel) this.getContentPane();
        this.setVisible(true);

    }
}
