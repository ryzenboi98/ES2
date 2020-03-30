import com.es2.decorator.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDecorator {
    @AfterAll
    public static void tearDown(){
        End e = new End();
    }

    @Test
    public void testAuthLogin() {
        AuthInterface auth = new Auth();

        assertDoesNotThrow(
                ()-> auth.auth("admin","admin")
        );
    }

    @Test
    public void testAuthWrongPassword() {
        AuthInterface auth = new Auth();

        assertThrows(AuthException.class, () -> {
            auth.auth("admin","joe");
        });
    }

    @Test
    public void testAuthWrongUsername() {
        AuthInterface auth = new Auth();

        assertThrows(AuthException.class, () -> {
            auth.auth("joe","admin");
        });
    }

    @Test
    public void testAuthWrongAll() {
        AuthInterface auth = new Auth();

        assertThrows(AuthException.class, () -> {
            auth.auth("joe","joe");
        });
    }

    @Test
    public void testCommonWordsValidator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Auth());

        assertThrows(AuthException.class, () -> {
            auth.auth("admin","joe");
        });
    }

    @Test
    public void testCommonWordsValidatorWrongPass() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Auth());

        assertThrows(AuthException.class, () -> {
            auth.auth("admin","kjhkj");
        });
    }
}
