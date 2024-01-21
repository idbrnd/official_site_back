package ai.idb.site.controller.inquiry;

import ai.idb.site.controller.inquiry.dto.InquirySendRequest;
import ai.idb.site.service.inquiry.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/inquiry")
@RestController
public class InquirySenderController {

    private final InquiryService inquiryService;
    /** 문의 등록 */
    @PostMapping
    public void askIDB(final @RequestBody InquirySendRequest request){
        inquiryService.sendEmail(to, cc, bcc);
    }
}
