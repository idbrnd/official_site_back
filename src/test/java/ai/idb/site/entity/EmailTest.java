package ai.idb.site.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    public void testEmailCreationValid() {
        String validEmail = "test@example.com";
        Email email = new Email(validEmail);
        assertNotNull(email);
        assertEquals(validEmail, email.getEmail());
    }

    @Test
    public void testEmailCreationInvalid() {
        String invalidEmail = "invalid-email";
        assertThrows(IllegalArgumentException.class, () -> {
            new Email(invalidEmail);
        });
    }

    @Test
    public void testEmailCreationNull() {
        assertThrows(NullPointerException.class, () -> {
            new Email(null);
        });
    }

    // Additional tests can be added to cover more scenarios
}
