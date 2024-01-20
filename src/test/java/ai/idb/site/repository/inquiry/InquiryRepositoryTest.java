package ai.idb.site.repository.inquiry;

import ai.idb.site.entity.Inquiry;
import ai.idb.site.entity.InquiryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class InquiryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InquiryRepository inquiryRepository;

    @Test
    public void testSaveInquiry() {
        // Inquiry 객체 생성
        Inquiry newInquiry = new Inquiry("Company", "Position", "Name", "Contact", "email@example.com", InquiryType.INQUERY_REGISTER, "Context");
        Inquiry savedInquiry = inquiryRepository.save(newInquiry);

        // 검증
        Inquiry foundInquiry = entityManager.find(Inquiry.class, savedInquiry.getId());
        assertNotNull(foundInquiry);
        assertEquals("Name", foundInquiry.getName());
        // 여기에 더 많은 검증 로직 추가
    }

    // 추가적인 테스트 메소드 구현
}