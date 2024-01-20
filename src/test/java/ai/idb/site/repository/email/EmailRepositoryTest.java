package ai.idb.site.repository.email;

import ai.idb.site.entity.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmailRepositoryTest {

    @Autowired
    private EmailRepository emailRepository;

    @Test
    public void testSaveEmail() {
        // Creating a new Email entity
        Email email = new Email("test@example.com");
        Email savedEmail = emailRepository.save(email);

        // Assertions
        assertNotNull(savedEmail.getId());
        assertEquals("test@example.com", savedEmail.getEmail());
    }

    // Additional tests can be added to cover more scenarios
}