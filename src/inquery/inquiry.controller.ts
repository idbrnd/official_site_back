import { Controller, Post, Body, Res, HttpStatus } from '@nestjs/common';
import { Response } from 'express';
import { InquiryService } from './inquiry.service';
import { Inquiry } from './inquiry.entity';
import { MailService } from '../util/mail.service';

@Controller('api/contact')
export class InquiryController {
  constructor(
    private inquiryService: InquiryService,
    private mailService: MailService,
  ) {}

  @Post()
  async create(
    @Body() inquiryData: Inquiry,
    @Res() response: Response,
  ): Promise<Response> {
    try {
      await this.inquiryService.create(inquiryData); // 데이터베이스에 저장
      await this.mailService.sendEmail(
        inquiryData.email, // 수신자 이메일
        'Your Inquiry Has Been Received', // 제목
        'We have received your inquiry and will respond shortly.', // 이메일 내용
      );

      return response.status(HttpStatus.OK).json({
        message: 'Email sent successfully',
      });
    } catch (error) {
      console.error('Error sending email', error);
      return response.status(HttpStatus.INTERNAL_SERVER_ERROR).json({
        message: 'Failed to send email',
        error: error.message,
      });
    }
  }
}
