// src/mail/mail-config.service.ts
import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class MailConfigService {
  constructor(private configService: ConfigService) {}

  createMailOptions() {
    return {
      host: this.configService.get<string>('MAIL_HOST'),
      port: this.configService.get<number>('MAIL_PORT'),
      secure: this.configService.get<boolean>('MAIL_SECURE'),
      auth: {
        user: this.configService.get<string>('MAIL_USER'),
        pass: this.configService.get<string>('MAIL_PASS'),
      },
    };
  }

  getMailTo() {
    return this.configService.get<string>('MAIL_TO');
  }

  getMailFrom() {
    return this.configService.get<string>('MAIL_FROM');
  }

  getMailBcc() {
    const bcc = this.configService.get<string>('MAIL_BCC');
    return bcc ? bcc.split(',') : [];
  }


}
