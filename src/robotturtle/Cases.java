package robotturtle;

import javax.swing.*;

public class Cases {

    protected int positionX,positionY;
    protected char type; //robotturtle.Joueur : J, joyau : j, robotturtle.Mur de pierre : P, robotturtle.Mur de glace : G, robotturtle.Mur de bois : B, Vide : V
    protected Joueur joueur;
    public JLabel imageGlace;
    public JLabel imageJoyau;




    public Cases(){}
    public Cases (int pX, int pY){
        positionX = pX;
        positionY = pY;
        type = 'V';
    }


    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }


    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    public Joueur getJoueur() {
        return(joueur);
    }

    public void setJoueur(Joueur j){
        this.joueur = j;
        this.type = 'J';
    }

    public void pierre(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'P';
        JLabel imageMurDePierre = new JLabel(new ImageIcon("murDePierre.png"));
        imageMurDePierre.setBounds(16+71*(this.getPositionX()-1),15+71*(this.getPositionY()-1),71,71);
        Main.getFenetre().remove(Main.getPlateauVisu());
        Main.getFenetre().add(imageMurDePierre);
        Main.getFenetre().add(Main.getPlateauVisu());
        Main.getFenetre().repaint();
    }
    public void bois(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'B';
        JLabel imageMurDeBois = new JLabel(new ImageIcon("murDeBois.png"));
        imageMurDeBois.setBounds(16+71*(this.getPositionX()-1),15+71*(this.getPositionY()-1),71,71);
        Main.getFenetre().remove(Main.getPlateauVisu());
        Main.getFenetre().add(imageMurDeBois);
        Main.getFenetre().add(Main.getPlateauVisu());
        Main.getFenetre().repaint();
    }
    public void glace(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'G';
        this.imageGlace  = new JLabel(new ImageIcon("murDeGlace.png"));
        imageGlace.setBounds(16+71*(this.getPositionX()-1),15+71*(this.getPositionY()-1),71,71);

        Main.getFenetre().remove(Main.getPlateauVisu());
        Main.getFenetre().add(this.imageGlace);
        Main.getFenetre().add(Main.getPlateauVisu());
        Main.getFenetre().repaint();
    }
    public void joyau(){//Pour s'assurer que la case est occupe et simplifier l'init
        this.type = 'j';
        Main.getPlateau()[1][2] = new Cases(2,3);
        this.imageJoyau = new JLabel(new ImageIcon("joyau.png"));
        Main.getFenetre().remove(Main.getPlateauVisu());
        this.imageJoyau.setBounds(16+71*(this.getPositionX()-1),15+71*(this.getPositionY()-1),71,71);
        Main.getFenetre().add(this.imageJoyau);
        Main.getFenetre().add(Main.getPlateauVisu());
    }


    }



