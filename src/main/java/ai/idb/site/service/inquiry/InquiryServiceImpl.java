package ai.idb.site.service.inquiry;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ai.idb.site.repository.inquiry.InquiryRepository;
import ai.idb.site.service.inquiry.dto.SendInquiryCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class InquiryServiceImpl implements InquiryService {

	private final JavaMailSender javaMailSender;
	private final InquiryRepository inquiryRepository;

	@Override
	public void sendEmail(SendInquiryCommand sendInquiryCommand) {
		// 	SimpleMailMessage message = new SimpleMailMessage();
		// 	message.setFrom(to);
		// 	message.setTo(to);
		// 	message.setCc(cc.toArray(new String[0]));
		// 	message.setBcc(bcc.toArray(new String[0]));
		// 	message.setSubject("메일 제목");
		// 	message.setText("메일 내용");
		// 	javaMailSender.send(message);
	}
}
