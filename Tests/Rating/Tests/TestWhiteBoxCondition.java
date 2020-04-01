import com.es2.whiteboxconditions.Rating;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWhiteBoxCondition {
    static Rating r;

    @BeforeAll
    public static void setup() {
        r = new Rating();
    }

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @Test
    public void testScore10Temp35() {
        String scoreTemp = r.evaluateScoreTemperature(10, 35);

        assertEquals("It's hot out, and so am I", scoreTemp);
    }

    @Test
    public void testTempUpLower20Score5() {
        String scoreTemp = r.evaluateScoreTemperature(5, 20);

        assertEquals("I'm in a bad mood", scoreTemp);
    }

    @Test
    public void testTempUp20ScoreLower5() {
        String scoreTemp = r.evaluateScoreTemperature(4, 21);

        assertEquals("I'm in a bad mood", scoreTemp);
    }

    @Test
    public void testTempUpLower20ScoreLower5() {
        String scoreTemp = r.evaluateScoreTemperature(4, 19);

        assertEquals("I'm in a bad mood", scoreTemp);
    }

    @Test
    public void testTempUp35Score5() {
        String scoreTemp = r.evaluateScoreTemperature(5, 40);

        assertEquals("I'm balanced", scoreTemp);
    }

    @Test
    public void testDiscoAccepted() {
        String disco = r.evaluateIfCouldBeAcceptedAtDisco(8,5);
        assertEquals("Accepted", disco);
    }

    @Test
    public void testDiscoNotDressStyle() {
        String disco = r.evaluateIfCouldBeAcceptedAtDisco(7,5);
        assertEquals("Not Accepted", disco);
    }

    @Test
    public void testDiscoNotPropSpeech() {
        String disco = r.evaluateIfCouldBeAcceptedAtDisco(8,4);
        assertEquals("Not Accepted", disco);
    }

    @Test
    public void testDiscoNotAnything() {
        String disco = r.evaluateIfCouldBeAcceptedAtDisco(6,3);
        assertEquals("Not Accepted", disco);
    }
}
