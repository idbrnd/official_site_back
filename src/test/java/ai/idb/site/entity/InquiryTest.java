package ai.idb.site.entity;

import org.junit.jupiter.api.Test;

import static ai.idb.site.entity.InquiryType.*;
import static org.junit.jupiter.api.Assertions.*;

public class InquiryTest {

    @Test
    void testInquiryCreation() {
        // Testing constructor and getter methods
        Inquiry inquiry = new Inquiry("Company", "Position", "Name", "Contact", "email@example.com", INQUERY_REGISTER, "Context");

        assertNotNull(inquiry);
        assertEquals("Company", inquiry.getCompanyName());
        assertEquals("Position", inquiry.getPosition());
        assertEquals("Name", inquiry.getName());
        assertEquals("Contact", inquiry.getContact());
        assertEquals(INQUERY_REGISTER, inquiry.getInqueryType());
        assertEquals("Context", inquiry.getContexts());
        // Add assertions for other fields as necessary
    }

    // Additional tests can be written for other methods or logic in the Inquiry class
}