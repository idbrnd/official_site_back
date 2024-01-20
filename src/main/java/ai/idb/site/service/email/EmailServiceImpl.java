package ai.idb.site.service.email;

import ai.idb.site.repository.inquiry.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private InquiryRepository inquiryRepository;

    @Override
    public void sendEmail() {

    }
}
