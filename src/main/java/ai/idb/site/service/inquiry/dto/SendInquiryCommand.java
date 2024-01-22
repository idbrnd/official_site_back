package ai.idb.site.service.inquiry.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SendInquiryCommand {

	public SendInquiryCommand(String to, List<String> cc, List<String> bcc, String companyName, String inquiryType,
		String contexts, String name, String contact, String position, String contexts1) {
	}
}
