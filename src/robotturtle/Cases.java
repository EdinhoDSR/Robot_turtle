package robotturtle;

import javax.swing.*;

public class Cases {

    protected int positionX,positionY;
    protected char type; //robotturtle.Joueur : J, joyau : j, robotturtle.Mur de pierre : P, robotturtle.Mur de glace : G, robotturtle.Mur de bois : B, Vide : V
    protected Joueur joueur;
    protected JLabel imageGlace;




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
        Main.fenetre.remove(Main.plateauVisu);
        Main.fenetre.add(imageMurDePierre);
        Main.fenetre.add(Main.plateauVisu);
        Main.fenetre.repaint();
    }
    public void bois(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'B';
        JLabel imageMurDeBois = new JLabel(new ImageIcon("murDeBois.png"));
        imageMurDeBois.setBounds(16+71*(this.getPositionX()-1),15+71*(this.getPositionY()-1),71,71);
        Main.fenetre.remove(Main.plateauVisu);
        Main.fenetre.add(imageMurDeBois);
        Main.fenetre.add(Main.plateauVisu);
        Main.fenetre.repaint();
    }
    public void glace(){
        // méthode qui pose les murs de pierre et permet à la fonction initialisation d'être plus propre/courte
        this.type = 'G';
        JLabel imageMurDeGlace = new JLabel(new ImageIcon("murDeGlace.png"));
        imageMurDeGlace.setBounds(16+71*(this.getPositionX()-1),15+71*(this.getPositionY()-1),71,71);
        this.imageGlace = imageMurDeGlace;
        Main.fenetre.remove(Main.plateauVisu);
        Main.fenetre.add(imageMurDeGlace);
        Main.fenetre.add(Main.plateauVisu);
        Main.fenetre.repaint();
    }
    public void joyau(){//Pour s'assurer que la case est occupe et simplifier l'init
        this.type = 'j';
        Main.plateau[1][2] = new Cases(2,3);



    }


    }



