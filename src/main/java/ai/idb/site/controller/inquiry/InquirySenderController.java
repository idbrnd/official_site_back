package ai.idb.site.controller.inquiry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.idb.site.controller.inquiry.dto.InquirySendRequest;
import ai.idb.site.service.inquiry.InquiryService;
import ai.idb.site.service.inquiry.dto.SendInquiryCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/inquiry")
@RestController
public class InquirySenderController {

	private final InquiryService inquiryService;

	/** 문의 등록 */
	@PostMapping
	public void askIDB(final @RequestBody InquirySendRequest req) {
		String to = "bkmin@idb.ai";
		List<String> cc = new ArrayList<>();
		List<String> bcc = new ArrayList<>();
		inquiryService.sendEmail(
			new SendInquiryCommand(
				"bkmin@idb.ai",
				List.of(""),
				List.of(""),
				req.getCompanyName(),
				req.getInquiryType(),
				req.getContexts(),
				req.getName(),
				req.getContact(),
				req.getPosition(),
				req.getContexts()
			)
		);
	}
}
