import com.es2.singleton.End;
import com.es2.singleton.Registry;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class TestSingleton {
    @AfterAll
    public static void tearDown(){
        End e = new End();
    }

    @Test
    public void testSetPath() {
        String path = "Joe path";

        Registry.getInstance().setPath(path);
        assertEquals(path, Registry.getInstance().getPath());
    }

    @Test
    public void testSetConnectionString() {
        String con = "Joe con";

        Registry.getInstance().setConnectionString(con);
        assertEquals(con, Registry.getInstance().getConnectionString());
    }

    @Test
    public void testPathNull() {
        String path = null;
        Registry.getInstance().setPath(path);

        assertEquals(path, Registry.getInstance().getPath());
    }

    @Test
    public void testConStringNull() {
        String con = null;
        Registry.getInstance().setConnectionString(con);

        assertEquals(con, Registry.getInstance().getConnectionString());
    }

    @Test
    public void testPrivateMethod() throws NoSuchMethodException {
        if(Modifier.isPrivate(Registry.class.getDeclaredConstructor().getModifiers()))
            return;
        else
            fail("Yo the class is not private!");
    }
}