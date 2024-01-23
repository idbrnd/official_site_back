package ai.idb.site.service.inquiry.dto;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SendInquiryCommand {
	final private String to;
	final private List<String> cc;
	final private List<String> bcc;
	final private String companyName;
	final private String position;
	final private String name;
	final private String contact;
	final private String email;
	final private String inquiryType;
	final private String contexts;
}
