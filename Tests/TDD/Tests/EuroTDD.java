import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuroTDD {

    @BeforeEach
    void setUp() {
    }

    @AfterAll
    static void tearDown() {
        new End();
    }

    @Test
    void testEuroObjectCreation(){
        Euro tenEuros = new Euro(10);
    }

    @Test
    void testEuroToString(){
        Euro twoEuros = new Euro(2);

        System.out.println(twoEuros);
        assertEquals("EUR 2.00", twoEuros.toString());

        twoEuros = new Euro(2.50);
        assertEquals("EUR 2.50", twoEuros.toString());
    }

    @Test
    void testEuroEquality() {
        Euro twoEuros = new Euro(2);
        Euro twoEuros2 = new Euro(2);

        assertTrue(twoEuros.equals(twoEuros2));
    }

    @Test
    void testEuroInequality() {
        Euro twoEuros = new Euro(3);
        Euro sixEuros = new Euro(6);

        assertFalse(twoEuros.equals(sixEuros));
    }

    @Test
    void testEuroEqualsDifferentObject() {
        Euro twoEuros = new Euro(2);
        Double twoEuros2 = new Double(2);

        assertFalse(twoEuros.equals(twoEuros2));
    }

    @Test
    void testSubtraction() {
        Euro twoEuros = new Euro(2);
        Euro oneEuro = new Euro(1);

        System.out.print(twoEuros.minus(oneEuro));

        assertTrue(new Euro(1).equals(twoEuros.minus(oneEuro)));
    }

    @Test
    void testSubAccuracy() {
        Euro onetyEuro = new Euro(1.03);
        Euro fortwoEuro = new Euro(0.42);

        assertTrue(new Euro(0.61).equals(onetyEuro.minus(fortwoEuro)));
    }
}