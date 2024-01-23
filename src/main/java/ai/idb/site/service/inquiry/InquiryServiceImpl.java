package ai.idb.site.service.inquiry;

import java.text.MessageFormat;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ai.idb.site.entity.Inquiry;
import ai.idb.site.entity.InquiryType;
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
	public void sendEmail(SendInquiryCommand command) {
		inquiryRepository.save(new Inquiry(
			command.getCompanyName(),
			command.getPosition(),
			command.getName(),
			command.getContact(),
			command.getEmail(),
			InquiryType.valueOf(command.getInquiryType()),
			command.getContexts()
		));

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(command.getTo());
		message.setTo(command.getTo());
		message.setCc(command.getCc().toArray(new String[0]));
		message.setBcc(command.getBcc().toArray(new String[0]));
		message.setSubject(
			MessageFormat.format("[공식사이트 문의] {0}_{1} {2} 문의입니다", command.getCompanyName(), command.getName(),
				command.getPosition()));
		message.setText(String.format(
			"<body style=\"font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4;\">" +
				"<div style=\"width: 100%%; max-width: 600px; margin: 0 auto; background: #ffffff;\">" +
				"<div style=\"background: #007bff; color: white; padding: 10px; text-align: center;\">" +
				"<h1 style=\"margin: 0;\">IDB 웹사이트 문의</h1>" +
				"</div>" +
				"<div style=\"padding: 20px; color: #333333;\">" +
				"<h2>idb.ai 사이트 제품문의 </h2>" +
				"<p>%s</p>" + // inquiryContent
				"</div>" +
				"<div style=\"background: #0056b3; color: white; text-align: center; padding: 10px; font-size: 12px;\">"
				+
				"<p>보낸사람: %s </p>" + // name
				"<p>회사: %s </p>" + // company
				"<p>직함: %s </p>" + // empTitle
				"<!-- Add social media links -->" +
				"<p><a href=\"#\" style=\"color: white;\">Unsubscribe</a></p>" +
				"</div>" +
				"</div>" +
				"</body>",
			command.getContexts(), command.getName(), command.getCompanyName(), command.getPosition()));
		javaMailSender.send(message);
	}
}
