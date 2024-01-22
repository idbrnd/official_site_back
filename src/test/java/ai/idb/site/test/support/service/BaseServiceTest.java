package ai.idb.site.test.support.service;

import org.springframework.beans.factory.annotation.Autowired;

import ai.idb.site.service.inquiry.InquiryService;

@ServiceTest
public abstract class BaseServiceTest {
	@Autowired
	private InquiryService inquiryService;

}
