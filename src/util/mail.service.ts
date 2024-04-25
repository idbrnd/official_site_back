// src/mail/mail.service.ts
// src/mail/mail.service.ts
import { Injectable } from '@nestjs/common';
import * as nodemailer from 'nodemailer';
import { MailConfigService } from '../config/mail-config.service';

@Injectable()
export class MailService {
  private transporter;
  private fromAddress: string;
  private toAddress: string;
  private bccAddress: string[];

  constructor(private configService: MailConfigService) {
    const mailOptions = configService.createMailOptions();
    this.transporter = nodemailer.createTransport(mailOptions);
    this.fromAddress = configService.getMailFrom();
    this.toAddress = configService.getMailTo();
    this.bccAddress = configService.getMailBcc();
  }

  async sendEmail(to: string, subject: string, text: string) {
    const mailDetails = {
      from: this.fromAddress,
      to: this.toAddress,
      subject: subject,
      html: text,
      bcc: this.bccAddress,
    };

    await this.transporter.sendMail(mailDetails);
  }
}
