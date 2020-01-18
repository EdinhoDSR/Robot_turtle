package robotturtle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static robotturtle.Valeurs.avancer;

public class Card {
    private Valeurs valeurs;
    private JLabel image;


    public Card (Valeurs valeurs) {

        this.valeurs = valeurs;
        this.image = image;
        switch(this.valeurs){
            case avancer:
                this.image= new JLabel(new ImageIcon("\"Avancer.png\""));
            case tournerD:
                this.image= new JLabel(new ImageIcon("\"TournerD.png\""));
            case tournerG:
                this.image =new JLabel(new ImageIcon("\"TournerG.png\""));
            case LASER:
                this.image =new JLabel(new ImageIcon("\"Laser.png\""));
            case Mdg:
                this.image= new JLabel(new ImageIcon("\"murDEGlace.png\""));
            case Mdp:
                this.image= new JLabel(new ImageIcon("\"murDEPierre.png\""));



        }



    }



    public String toString() {

        return this.valeurs.toString();

    }

    public JLabel getimage() {
        return this.image;
    }

    public Valeurs getvaleurs() {
        return this.valeurs;

    }
}
