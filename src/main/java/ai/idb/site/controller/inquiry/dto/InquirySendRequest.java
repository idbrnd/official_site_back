package ai.idb.site.controller.inquiry.dto;

import ai.idb.site.entity.InquiryType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;

import static jakarta.persistence.EnumType.STRING;

public class InquirySendRequest {
    private String companyName;
    private String position;
    private String name;
    private String contact;
    private String inquiryType;
    private String contexts;
}
