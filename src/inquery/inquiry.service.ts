import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Inquiry } from './inquiry.entity';
import { MailService } from '../util/mail.service';

@Injectable()
export class InquiryService {
  constructor(
    @InjectRepository(Inquiry)
    private inquiryRepository: Repository<Inquiry>,
    private mailService: MailService,
  ) {}

  async create(inquiryData: Inquiry): Promise<Inquiry> {
    // 이메일 보내기
    await this.mailService.sendEmail(
      inquiryData.email,
      `[공식사이트 문의] ${inquiryData.company}_${inquiryData.name} ${inquiryData.emp_title} ${inquiryData.inquiry_category}입니다`,
      `<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4;">
                <div style="width: 100%; max-width: 600px; margin: 0 auto; background: #ffffff;">
                    <div style="background: #007bff; color: white; padding: 10px; text-align: center;">
                        <h1 style="margin: 0;">IDB 웹사이트 문의</h1>
                    </div>
                    <div style="padding: 20px; color: #333333;">
                        <h2>idb.ai 사이트 제품문의 </h2>
                        <br/>
                        <p>${inquiryData.inquiry_content}</p>
                        <br/>
                    </div>
                    <div style="background: #0056b3; color: white; text-align: center; padding: 10px; font-size: 12px;">
                        <p>보낸사람: ${inquiryData.name} </p>
                        <p>회사: ${inquiryData.company} </p>
                        <p>직함: ${inquiryData.emp_title} </p>
                        <!-- Add social media links -->
                        <p><a href="#" style="color: white;">Unsubscribe</a></p>
                    </div>
                </div>
            </body>`,
    );

    return this.inquiryRepository.save(inquiryData);
  }
}
