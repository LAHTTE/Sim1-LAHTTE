package sim1.lahtte;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jean-Pierre
 */
public class Tp2Test {
    
    public Tp2Test() {
    }
    
    /**
     * Test de la methode laSorte.
     */
    @org.junit.Test
    public void testLaSorte() {
        System.out.println("laSorte");
        int carte = 0;
        int expResult = 0;
        int result = Tp2.laSorte(carte);
        assertEquals(expResult, result);
    }

    /**
     * Test de la methode laCouleur.
     */
    @org.junit.Test
    public void testLaCouleur() {
        System.out.println("laCouleur");
        int result1 = Tp2.laCouleur(51);
        int result2 = Tp2.laCouleur(0);
        assertEquals(3, result1);
        assertEquals(0, result2);
    }
    
    /**
     * Test de la methode estUnePaire.
     */
    @org.junit.Test
    public void testEstUnePaire() {
        System.out.println("estUnePaire");
        boolean result1 = Tp2.estUnePaire(51, 0);
        boolean result2 = Tp2.estUnePaire(26, 13);
        assertFalse(result1);
        assertTrue(result2);
    }
    
    /**
     * Test de la methode sontMemeCouleur.
     */
    @org.junit.Test
    public void testSontMemeCouleur() {
        System.out.println("sontMemeCouleur");
        boolean result1 = Tp2.sontMemeCouleur(51, 0);
        boolean result2 = Tp2.sontMemeCouleur(40, 45);
        assertFalse(result1);
        assertTrue(result2);
    }
    
    /**
     * Test de la methode estUneSequence.
     */
    @org.junit.Test
    public void testEstUneSequence() {
        System.out.println("estUneSequence");
        boolean result1 = Tp2.estUneSequence(13, 14);
        boolean result2 = Tp2.estUneSequence(14, 13);
        boolean result3 = Tp2.estUneSequence(51, 13);
        boolean result4 = Tp2.estUneSequence(13, 51);
        boolean result5 = Tp2.estUneSequence(10, 41);
        boolean result6 = Tp2.estUneSequence(51, 14);
        boolean result7 = Tp2.estUneSequence(14, 51);
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
        boolean result1 = Tp2.estInferieureOuEgaleA7(7);
        boolean result2 = Tp2.estInferieureOuEgaleA7(0);
        boolean result3 = Tp2.estInferieureOuEgaleA7(8);
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
        int result = Tp2.laValeurSorte(7);
        assertEquals(8, result);
    }
    
    /**
     * Test de la methode laSomme.
     */
    @org.junit.Test
    public void testLaSomme() {
        System.out.println("laSomme");
        int result = Tp2.laSomme(7, 10);
        assertEquals(18, result);
    }
    
    /**
     * Test de la methode laValeur.
     */
    @org.junit.Test
    public void testlaValeur() {
        System.out.println("laValeur");
        int result1 = Tp2.laValeur(10);
        int result2 = Tp2.laValeur(11);
        int result3 = Tp2.laValeur(12);
        int result4 = Tp2.laValeur(0);
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
        String result1 = Tp2.chaineCouleur(0);
        String result2 = Tp2.chaineCouleur(13);
        String result3 = Tp2.chaineCouleur(29);
        String result4 = Tp2.chaineCouleur(40);
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
        String result1 = Tp2.chaineSorte(0);
        String result2 = Tp2.chaineSorte(49);
        String result3 = Tp2.chaineSorte(50);
        String result4 = Tp2.chaineSorte(51);
        String result5 = Tp2.chaineSorte(14);
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
        String result1 = Tp2.symboleChaineSorte(0);
        String result2 = Tp2.symboleChaineSorte(49);
        String result3 = Tp2.symboleChaineSorte(50);
        String result4 = Tp2.symboleChaineSorte(51);
        String result5 = Tp2.symboleChaineSorte(48);
        String result6 = Tp2.symboleChaineSorte(14);
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
        String result1 = Tp2.symboleChaineCouleur(0);
        String result2 = Tp2.symboleChaineCouleur(13);
        String result3 = Tp2.symboleChaineCouleur(26);
        String result4 = Tp2.symboleChaineCouleur(39);
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
        int result = Tp2.reduitMontantDe3(10);
        assertEquals(7, result);
    }


    
}
