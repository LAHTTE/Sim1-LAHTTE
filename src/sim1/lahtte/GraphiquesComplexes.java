package sim1.lahtte;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GraphiquesComplexes extends JFrame {

    JPanel panneauCarte;
    GridLayout gridPanneauCarte = new GridLayout(1, 2);
    JLabel premiereCarteLabel;
    JLabel deuxiemeCarteLabel;

    public GraphiquesComplexes() {
        init();
    }
    
    private int laCouleurImage(int couleur) {
    /*  antecedent : 0 <= couleur <= 3
     *  consequent : retourne la couleur associe a la l'index de la rangee de l'image
     *
     */
        switch (couleur) {
            case 0: return 2; // coeur
            case 1: return 3; // carreau
            case 2: return 0; // trefle
            default: return 1; // pique
        }
    }

    public JLabel getImageCouper(int sorte, int couleur) {

    /*  antecedent : 0 <= sorte <= 12 , 0 <= couleur <= 3
     *  consequent : retourne JLabel de l'image de la carte coupee
     *
     */
        
        BufferedImage imageCarte;

        JLabel imageLabel = null;
        int largeur = 72, hauteur = 98;
        int x = (largeur + 1) * sorte;
        int y = (hauteur) * laCouleurImage(couleur);
        try {
            //l'image vient de http://www.milefoot.com/math/discrete/counting/cardfreq.htm
            imageCarte = ImageIO.read(new File("cards.png"));
            BufferedImage imageCarteCouper = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
            imageCarteCouper.getGraphics().drawImage(imageCarte, 0, 0, largeur, hauteur, x, y, x + largeur, y + hauteur, null);
            imageLabel = new JLabel(new ImageIcon(imageCarteCouper));
        } catch (IOException ex) {
            Logger.getLogger(GraphiquesComplexes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageLabel;
    }

    public void setCartes(int sorteCarte1, int couleurCarte1, int sorteCarte2, int couleurCarte2) {

    /* antecedent : 0 <= sorteCarte1 <= 12 , 0 <= couleurCarte1 <= 3 , 0 <= sorteCarte2 <= 12 , 0 <= couleurCarte2 <= 3
     * consequent : modifier le graphique complexe des cartes 
     *
     */
        
        premiereCarteLabel = getImageCouper(sorteCarte1, couleurCarte1);
        deuxiemeCarteLabel = getImageCouper(sorteCarte2, couleurCarte2);
        panneauCarte.removeAll();
        panneauCarte.add(premiereCarteLabel);
        panneauCarte.add(deuxiemeCarteLabel);
        setVisible(true);
    }

    private void init() {

    /* initialiser la fenetre du graphique complexes
     * 
     */
        
        setTitle("Cartes");
        setBounds(500, 230, 500, 300);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creation du panneau de cartes
        panneauCarte = new JPanel();
        panneauCarte.setLayout(gridPanneauCarte);
        add(panneauCarte);

    }

}
