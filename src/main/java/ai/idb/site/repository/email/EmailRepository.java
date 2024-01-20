package ai.idb.site.repository.email;

import ai.idb.site.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    // You can add custom query methods if needed
}

