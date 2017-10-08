package sim1.lahtte;

public class Sim1LAHTTE {

    public static char lireOuiNon() {

        char reponse;

        System.out.print("Voulez-vous jouer une partie ? ");
        reponse = sim1.lahtte.Clavier.lireChar();
        sim1.lahtte.Clavier.lireFinLigne();

        while (reponse != 'o' && reponse != 'n') {
            System.out.print("*** vous devez repondre par o ou n : ");
            reponse = sim1.lahtte.Clavier.lireChar();
            sim1.lahtte.Clavier.lireFinLigne();
        }

        return reponse;
    } // lireOuiNon

    /**
     * Amelioration apportee: Gestion des exceptions d'entrees numeriques
     */
    public static int lireSortePari() {

        int reponse;

        System.out.println("Quel pari voulez-vous faire ?");
        System.out.print(" 1 : paire, 2 : sequence, 3 : meme couleur, 4 : somme inferieure ou egale a 7 => ");

        while (true) {
            try {
                reponse = sim1.lahtte.Clavier.lireInt();

                while (reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4) {
                    System.out.print("*** vous devez repondre par 1, 2, 3 ou 4 : ");
                    reponse = sim1.lahtte.Clavier.lireInt();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("*** vous devez repondre par 1, 2, 3 ou 4 : ");
            }
        }

        return reponse;
    } // lireSortePari

    //Afficher message
    public static void messageDeCoutPige() {
        System.out.print("Coût d'une pige de cartes est 3$ et\nle montant doit etre superieur a 3.\n");
    } // messageDeCoutPige

    /**
     * Amelioration apportee: Gestion des exceptions d'entrees numeriques
     */
    public static int lireMontantJoueur() {

        int reponse;

        System.out.print("Entrez le montant dont vous disposez : ");
        while (true) {
            try {
                reponse = sim1.lahtte.Clavier.lireInt();

                while (reponse <= 3) {
                    System.out.print("*** Le montant doit etre superieur a 3 : ");
                    reponse = sim1.lahtte.Clavier.lireInt();
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Veuillez entrer un nombre entier");
                System.out.print("Entrez le montant dont vous disposez : ");
            }
        }

        return reponse;
    } // lireMontantJoueur

    /**
     * Amelioration apportee: Gestion des exceptions d'entrees numeriques
     */
    public static int lireMiseJoueur(int max) {

        int reponse;

        System.out.print("Entrez le montant de la mise ( maximum : " + max + " ) : ");
        while (true) {
            try {
                reponse = sim1.lahtte.Clavier.lireInt();

                while (reponse < 0 || reponse > max) {
                    System.out.print("*** Le montant doit etre entre 0 et " + max + " : ");
                    reponse = sim1.lahtte.Clavier.lireInt();
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Veuillez entrer un nombre entier");
                System.out.print("Entrez le montant de la mise ( maximum : " + max + " ) : ");
            }
        }

        return reponse;
    } // lireMiseJoueur

    public static int laSorte(int carte) {

        /* antecedent : 0 <= carte <= 51
     * consequent : retourne la valeur de la carte (0, 1, ... 12)
     *              0 : as, 1 : 2, 2 : 3, ..., 9 : 10, 10 : valet, 11 : dame, 12 : roi
         */
        return carte % 13;

    } // laSorte

    public static int laCouleur(int carte) {

     /* antecedent : 0 <= carte <= 51
      * consequent : retourne la couleur de la carte (0, 1, 2, 3)
      *              0 : coeur, 1 : carreau, 2 : trefle, 3 : pique
      */
        return carte / 13;

    } // laCouleur

    public static boolean estUnePaire(int carte1, int carte2) {

    /* antecedent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consequent : retourne vrai si carte1 et carte 2 constituent une paire,
     *              faux sinon
     */
        return laSorte(carte1) == laSorte(carte2);

    } // estUnePaire

    public static boolean sontMemeCouleur(int carte1, int carte2) {

    /* antecedent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consequent : retourne vrai si carte1 et carte 2 sont de la meme
     *              couleur.  Les 4 couleurs possibles sont : coeur, carreau,
     *              trefle et pique.
     */
        return laCouleur(carte1) == laCouleur(carte2);

    } // sontMemeCouleur

    public static boolean estUneSequence(int carte1, int carte2) {

     /* antecedent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consequent : retourne vrai si carte1 et carte 2 forment une sequence,
     *              peu importe leur couleur, faux sinon.  Une sequence de
     *              deux cartes sont deux cartes de valeur consecutive.  L'as
     *              et le 2 sont considerees comme consecutives ainsi que l'as
     *              et le roi.
     */
        int sorte1 = laSorte(carte1);
        int sorte2 = laSorte(carte2);

        return sorte1 == sorte2 + 1
                || sorte1 == sorte2 - 1
                || sorte1 == 12 && sorte2 == 0
                || // as et roi
                sorte2 == 12 && sorte1 == 0;

    } // estUneSequence

    public static boolean estInferieureOuEgaleA7(int somme) {

        /*  antecedent : -
         *  consequent : retourne vrai si la somme est inferieure ou egale a 7,
         *               sinon retourne faux
         */
        return somme <= 7;

    } // estInferieureOuEgaleA7

    public static int laValeurSorte(int carte) {

        /* antecedent : 0 <= carte <= 51
        * consequent : retourne la valeur de la sorte de carte
         */
        return laValeur(laSorte(carte));

    } // laValeurSorte

    public static int laSomme(int carte1, int carte2) {

        /* antecedent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
        * consequent : retourne la somme des valeurs des sortes des deux cartes
         */
        return laValeurSorte(carte1) + laValeurSorte(carte2);

    } // laSomme

    public static int laValeur(int sorte) {

        /* antecedent : -
        * consequent : retourne la valeur de la sorte pour le pari #4
         */
        if (sorte == 10 || sorte == 11 || sorte == 12) {
            return 10;
        } else {
            return sorte + 1;
        }

    } // laValeur

    public static String chaineCouleur(int carte) {

    /* antecedent : 0 <= carte <= 51
     * consequent : retourne une chaine correspondant a la couleur de la 
     * carte
     */
        String reponse;

        int couleur = laCouleur(carte);
        if (couleur == 0) {
            reponse = "coeur";
        } else if (couleur == 1) {
            reponse = "carreau";
        } else if (couleur == 2) {
            reponse = "trefle";
        } else {
            reponse = "pique";
        }

        return reponse;
    } // chaineCouleur

    public static String chaineSorte(int carte) {

    /* antecedent : 0 <= carte <= 51
     * consequent : retourne une chaine correspondant a la sorte de la 
     * carte
     */
        String reponse;

        int sorte = laSorte(carte);
        if (sorte == 0) {
            reponse = "as";
        } else if (sorte == 10) {
            reponse = "valet";
        } else if (sorte == 11) {
            reponse = "dame";
        } else if (sorte == 12) {
            reponse = "roi";
        } else {
            reponse = String.valueOf(sorte + 1);
        }

        return reponse;
    } // chaineSorte

    public static String symboleChaineSorte(int carte) {

    /* antecedent : 0 <= carte <= 51
     * consequent : retourne la chaine correspondant au symbole de la sorte
     * de la carte
     */
        String reponse;

        int sorte = laSorte(carte);
        switch (sorte) {
            case 0:
                reponse = "A ";
                break;
            case 10:
                reponse = "J ";
                break;
            case 11:
                reponse = "Q ";
                break;
            case 12:
                reponse = "K ";
                break;
            case 9:
                reponse = "10";
                break;
            default:
                reponse = String.valueOf(sorte + 1) + " ";
                break;
        }

        return reponse;
    } // symboleChaineSorte

    public static String symboleChaineCouleur(int carte) {

    /* antecedent : 0 <= carte <= 51
     * consequent : retourne la chaine correspondant au symbole de la couleur
     * de la carte
     */
        String reponse;

        int couleur = laCouleur(carte);
        switch (couleur) {
            case 0:
                reponse = "\u2665";
                break;
            case 1:
                reponse = "\u2666";
                break;
            case 2:
                reponse = "\u2663";
                break;
            default:
                reponse = "\u2660";
                break;
        }

        return reponse;
    } // symboleChaineCouleur

    public static void afficherCarte(int carte) {

    /* antecedent : 0 <= carte <= 51
     * consequent : affiche la carte selon sa couleur et sa valeur
     */
        System.out.print(chaineSorte(carte) + " " + chaineCouleur(carte));

    } // afficherCarte

    public static void afficherCarteGraphicSimple(int carte) {

    /* antecedent : 0 <= carte <= 51
     * consequent : affiche le graphique de la carte
     */
        String sorte = symboleChaineSorte(carte);
        String couleur = symboleChaineCouleur(carte);
        System.out.println(
                "\n┌─────────┐"
                + "\n│ " + sorte + "      │"
                + "\n│         │"
                + "\n│         │"
                + "\n│    " + couleur + "    │"
                + "\n│         │"
                + "\n│         │"
                + "\n│       " + sorte + "│"
                + "\n└─────────┘"
                + "\n");
    } // afficherCarteGraphicSimple

    public static void afficherCarteGraphicComplexe(int carte1, int carte2, GraphiquesComplexes fenetre) {

    /* antecedent : 0 <= carte <= 51
     * consequent : affiche le graphique de la carte
     */
        fenetre.setCartes(laSorte(carte1), laCouleur(carte1), laSorte(carte2), laCouleur(carte2));
    } // afficherCarteGraphicComplexe

    public static void afficherLesDeuxCartes(int carte1, int carte2, GraphiquesComplexes fenetre) {

    /* antecedent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consequent : affiche le graphique des deux cartes
     */
        System.out.print("Voici la premiere carte : ");
        afficherCarte(carte1);
        afficherCarteGraphicSimple(carte1);

        System.out.print("Voici la deuxieme carte : ");
        afficherCarte(carte2);
        afficherCarteGraphicSimple(carte2);

        afficherCarteGraphicComplexe(carte1, carte2, fenetre);

    } // afficherLesDeuxCartes

    public static void afficherFin(int montant) {

        System.out.println("Merci d'avoir joue avec moi !");
        System.out.println("Vous quittez avec " + montant + " $ en poche.");

    } // afficherFin

    /**
     * Amelioration apportee: Gestion des exceptions d'entrees numeriques
     */
    public static void initialiserJeuDeCarte() {

        System.out.print("Entrez un nombre entier pour initialiser le jeu : ");
        int nbLu;
        while (true) {
            try {
                nbLu = sim1.lahtte.Clavier.lireInt();
                sim1.lahtte.JeuDeCartes.initialiserJeuDeCarte(nbLu);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Veuillez entrer un nombre entier");
                System.out.print("Entrez un nombre entier pour initialiser le jeu : ");
            }

        }

        System.out.println();

    } // initialiserJeuDeCarte

    public static int validationDuMontantInitial(int montantJoueur){
        messageDeCoutPige();
        montantJoueur = lireMontantJoueur();
        System.out.println();
        return montantJoueur;
    }
    
    public static int reduitMontantDe3(int montant) {

    /* antecedent : -
     * consequent : retourne le montant reduit de la mise de 3$
     */
        return montant - 3;
    } //reduitMontantDe3

    public static void main(String[] parametres) {

        char reponse;       // saisi : pour la reponse o ou n
        int pari;           // saisi : pour la sorte de pari 1, 2 ou 3
        int montantJoueur =0;// saisi puis ajuste : montant dont dispose le joueur
        int montantGagne;   // calcule : montant gagne selon le pari effectue

        int mise;           // saisi : montant mise par le joueur
        int deuxCartes;     // les deux cartes pigees par l'ordinateur
        int carte1;         // la premiere carte pigee
        int carte2;         // la deuxieme carte pigee

        boolean joueurGagne;    // si le joueur a gagne ou non la partie 

        // Initialiser le procede aleatoire
        initialiserJeuDeCarte();

        // Initialiser le Graphiques Complexes
        GraphiquesComplexes fenetre = new GraphiquesComplexes();

        // Saisir et valider le montant initial du joueur
        montantJoueur = validationDuMontantInitial(montantJoueur);

        // Boucle pour les parties
        reponse = lireOuiNon();
        System.out.println();

        while (reponse == 'o') {

            // saisie et validation du type de pari
            pari = lireSortePari();
            System.out.println();

            // Cout de pige des cartes
            montantJoueur = reduitMontantDe3(montantJoueur);
            System.out.println();
            System.out.println("La montant est déduit de 3$ pour la pige de cartes.\n");

            // saisie et validation du montant de la mise
            mise = lireMiseJoueur(montantJoueur);
            System.out.println();

            montantJoueur = montantJoueur - mise;

            // faire piger deux cartes par l'ordinateur
            deuxCartes = sim1.lahtte.JeuDeCartes.pigerDeuxCartes();

            carte1 = deuxCartes / 100;
            carte2 = deuxCartes % 100;

            afficherLesDeuxCartes(carte1, carte2, fenetre);

            // determiner si le joueur a gagne ou perdu
            int somme = laSomme(carte1, carte2);
            System.out.println("Voici les cartes: " + laValeurSorte(carte1) + " + "
                            + laValeurSorte(carte2) + " = " + somme);
            switch (pari) {
                case 1:
                    // est-ce une paire ?
                    joueurGagne = estUnePaire(carte1, carte2);
                    montantGagne = 4 * mise;
                    break;
                case 2:
                    // est-ce une sequence ?
                    joueurGagne = estUneSequence(carte1, carte2);
                    montantGagne = 2 * mise;
                    break;
                case 3:
                    // deux de la meme couleur ?
                    joueurGagne = sontMemeCouleur(carte1, carte2);
                    montantGagne = mise;
                    break;
                default:
                    // la somme est-elle inferieure ou egale a 7 ?
                    joueurGagne = estInferieureOuEgaleA7(somme);
                    montantGagne = somme * mise;                   
                    break;
            }

            // afficher si le joueur a gagne ou perdu ainsi que son gain s'il y a lieu
            if (joueurGagne) {
                System.out.println("Bravo ! Vous avez gagne " + montantGagne + " $");
                montantJoueur = montantJoueur + montantGagne;
            } else {
                System.out.println("Desole ! Vous avez perdu votre mise !");
            }

            System.out.println();
            System.out.println("Vous disposez maintenant de " + montantJoueur + " $");
            System.out.println();

            // determiner si on continue ou pas
            if (montantJoueur > 3) {
                reponse = lireOuiNon();
            } else {
                System.out.println("Vous n'avez plus d'argent, vous ne pouvez continuer.");
                reponse = 'n';
            }

        } // boucle de jeu

        afficherFin(montantJoueur);

    } // main

} // Sim1LAHTTE
