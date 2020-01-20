package robotturtle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuTourDeJeu {
   /* JLabel jl;
    private JFrame frame;
    private JButton poserUnMurButton;
    private JButton executerLeProgrammeButton;
    private JButton ajouterUneCarteAuButton;
    private JPanel p;
    private JLabel lab;
    public MenuTourDeJeu(){}
    public void executionProgramme(Joueur joueur){
        frame.dispose();
        executerLeProgrammeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    public void mur(Joueur joueur){
        frame.dispose();
        poserUnMurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    public void menuTourDeJeu(Joueur joueur){

        frame = new JFrame();
        frame.setTitle("menuTourDeJeu");
        frame.setVisible(true);
        frame.setSize(240, 150);
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
    public static void main(String[] args){

    }*/
}
