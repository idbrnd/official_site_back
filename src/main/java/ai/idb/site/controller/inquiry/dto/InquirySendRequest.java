package ai.idb.site.controller.inquiry.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InquirySendRequest {
	final private String companyName;
	final private String position;
	final private String name;
	final private String contact;
	final private String inquiryType;
	final private String contexts;
	final private String email;
}
