package ai.idb.site.controller.inquiry.dto;

import lombok.Getter;

@Getter
public class InquirySendRequest {
	private String companyName;
	private String position;
	private String name;
	private String contact;
	private String inquiryType;
	private String contexts;
}
