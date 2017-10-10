package sim1.lahtte;

import static org.junit.Assert.*;

/**
 *
 * @author Jean-Pierre
 */
public class Sim1LAHTTETest {
    
    public Sim1LAHTTETest() {
    }
    
    /**
     * Test de la methode laSorte.
     */
    @org.junit.Test
    public void testLaSorte() {
        System.out.println("laSorte");
        int carte = 0;
        int expResult = 0;
        int result = Sim1LAHTTE.laSorte(carte);
        assertEquals(expResult, result);
    }

    /**
     * Test de la methode laCouleur.
     */
    @org.junit.Test
    public void testLaCouleur() {
        System.out.println("laCouleur");
        int result1 = Sim1LAHTTE.laCouleur(51);
        int result2 = Sim1LAHTTE.laCouleur(0);
        assertEquals(3, result1);
        assertEquals(0, result2);
    }
    
    /**
     * Test de la methode estUnePaire.
     */
    @org.junit.Test
    public void testEstUnePaire() {
        System.out.println("estUnePaire");
        boolean result1 = Sim1LAHTTE.estUnePaire(51, 0);
        boolean result2 = Sim1LAHTTE.estUnePaire(26, 13);
        assertFalse(result1);
        assertTrue(result2);
    }
    
    /**
     * Test de la methode sontMemeCouleur.
     */
    @org.junit.Test
    public void testSontMemeCouleur() {
        System.out.println("sontMemeCouleur");
        boolean result1 = Sim1LAHTTE.sontMemeCouleur(51, 0);
        boolean result2 = Sim1LAHTTE.sontMemeCouleur(40, 45);
        assertFalse(result1);
        assertTrue(result2);
    }
    
    /**
     * Test de la methode estUneSequence.
     */
    @org.junit.Test
    public void testEstUneSequence() {
        System.out.println("estUneSequence");
        boolean result1 = Sim1LAHTTE.estUneSequence(13, 14);
        boolean result2 = Sim1LAHTTE.estUneSequence(14, 13);
        boolean result3 = Sim1LAHTTE.estUneSequence(51, 13);
        boolean result4 = Sim1LAHTTE.estUneSequence(13, 51);
        boolean result5 = Sim1LAHTTE.estUneSequence(10, 41);
        boolean result6 = Sim1LAHTTE.estUneSequence(51, 14);
        boolean result7 = Sim1LAHTTE.estUneSequence(14, 51);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertFalse(result5);
        assertFalse(result6);
        assertFalse(result7);
    }
    
    /**
     * Test de la methode estInferieureOuEgaleA7.
     */
    @org.junit.Test
    public void testInferieureOuEgaleA7() {
        System.out.println("estInferieureOuEgaleA7");
        boolean result1 = Sim1LAHTTE.estInferieureOuEgaleA7(7);
        boolean result2 = Sim1LAHTTE.estInferieureOuEgaleA7(0);
        boolean result3 = Sim1LAHTTE.estInferieureOuEgaleA7(8);
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }
    
    /**
     * Test de la methode laValeurSorte.
     */
    @org.junit.Test
    public void testLaValeurSorte() {
        System.out.println("laValeurSorte");
        int result = Sim1LAHTTE.laValeurSorte(7);
        assertEquals(8, result);
    }
    
    /**
     * Test de la methode laSomme.
     */
    @org.junit.Test
    public void testLaSomme() {
        System.out.println("laSomme");
        int result = Sim1LAHTTE.laSomme(7, 10);
        assertEquals(18, result);
    }
    
    /**
     * Test de la methode laValeur.
     */
    @org.junit.Test
    public void testlaValeur() {
        System.out.println("laValeur");
        int result1 = Sim1LAHTTE.laValeur(10);
        int result2 = Sim1LAHTTE.laValeur(11);
        int result3 = Sim1LAHTTE.laValeur(12);
        int result4 = Sim1LAHTTE.laValeur(0);
        assertEquals(10, result1);
        assertEquals(10, result2);
        assertEquals(10, result3);
        assertEquals(1, result4);
    }
    
    /**
     * Test de la methode chaineCouleur.
     */
    @org.junit.Test
    public void testChaineCouleur() {
        System.out.println("chaineCouleur");
        String result1 = Sim1LAHTTE.chaineCouleur(0);
        String result2 = Sim1LAHTTE.chaineCouleur(13);
        String result3 = Sim1LAHTTE.chaineCouleur(29);
        String result4 = Sim1LAHTTE.chaineCouleur(40);
        assertEquals("coeur", result1);
        assertEquals("carreau", result2);
        assertEquals("trefle", result3);
        assertEquals("pique", result4);
    }
    
    /**
     * Test de la methode chaineSorte.
     */
    @org.junit.Test
    public void testChaineSorte() {
        System.out.println("chaineSorte");
        String result1 = Sim1LAHTTE.chaineSorte(0);
        String result2 = Sim1LAHTTE.chaineSorte(49);
        String result3 = Sim1LAHTTE.chaineSorte(50);
        String result4 = Sim1LAHTTE.chaineSorte(51);
        String result5 = Sim1LAHTTE.chaineSorte(14);
        assertEquals("as", result1);
        assertEquals("valet", result2);
        assertEquals("dame", result3);
        assertEquals("roi", result4);
        assertEquals("2", result5);
    }
    
    /**
     * Test de la methode symboleChaineSorte
     */
    @org.junit.Test
    public void testSymboleChaineSorte() {
        System.out.println("symboleChaineSorte");
        String result1 = Sim1LAHTTE.symboleChaineSorte(0);
        String result2 = Sim1LAHTTE.symboleChaineSorte(49);
        String result3 = Sim1LAHTTE.symboleChaineSorte(50);
        String result4 = Sim1LAHTTE.symboleChaineSorte(51);
        String result5 = Sim1LAHTTE.symboleChaineSorte(48);
        String result6 = Sim1LAHTTE.symboleChaineSorte(14);
        assertEquals("A ", result1);
        assertEquals("J ", result2);
        assertEquals("Q ", result3);
        assertEquals("K ", result4);
        assertEquals("10", result5);
        assertEquals("2 ", result6);
    }

    /**
     * Test de la methode symboleChaineCouleur
     */
    @org.junit.Test
    public void testSymboleChaineCouleur() {
        System.out.println("symboleChaineCouleur");
        String result1 = Sim1LAHTTE.symboleChaineCouleur(0);
        String result2 = Sim1LAHTTE.symboleChaineCouleur(13);
        String result3 = Sim1LAHTTE.symboleChaineCouleur(26);
        String result4 = Sim1LAHTTE.symboleChaineCouleur(39);
        assertEquals("\u2665", result1);
        assertEquals("\u2666", result2);
        assertEquals("\u2663", result3);
        assertEquals("\u2660", result4);
    }
    
    /**
     * Test de la methode reduitMontantDe3
     */
    @org.junit.Test
    public void testReduitMontantDe3() {
        System.out.println("reduitMontantDe3");
        int result = Sim1LAHTTE.reduitMontantDe3(10);
        assertEquals(7, result);
    }

    @org.junit.Test
    public void testdAcceptation(){
        System.out.println("testdAcceptation");
        boolean result1 = Sim1LAHTTE.estUnePaire(42, 37);
        boolean result2 = Sim1LAHTTE.estUnePaire(35, 3);
        boolean result3 = Sim1LAHTTE.estUneSequence(40, 0);
        boolean result4 = Sim1LAHTTE.estUneSequence(25, 30);
        boolean result5 = Sim1LAHTTE.estUneSequence(43, 37);
        boolean result6 = Sim1LAHTTE.estInferieureOuEgaleA7(6);
        boolean result7 = Sim1LAHTTE.sontMemeCouleur(3, 6);
        assertFalse(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertFalse(result5);
        assertFalse(result4);
        assertTrue(result6);
        
        assertEquals(0, Sim1LAHTTE.jeuPaire(42, 37, 17));
        assertEquals(0, Sim1LAHTTE.jeuPaire(35, 1, 17));
        assertEquals(0, Sim1LAHTTE.jeuDeSequence(25, 30, 17));
        assertEquals(0, Sim1LAHTTE.jeuDeSequence(25, 30, 17));
        assertEquals(40, Sim1LAHTTE.jeuDeSequence(40, 0, 20));
        assertEquals(0, Sim1LAHTTE.jeuDeSequence(43, 37, 17));
        
        int somme = Sim1LAHTTE.laSomme(1, 29);
        assertEquals(120, Sim1LAHTTE.jeuInferieurA7(somme, 20));
        assertEquals(0, Sim1LAHTTE.jeuDeSequence(43, 37, 17));
        assertEquals(20, Sim1LAHTTE.jeuDeCouleur(3, 6, 20));
    }
    
}
