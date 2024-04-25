import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Inquiry } from './inquery/inquiry.entity';
import { InquiryService } from './inquery/inquiry.service';
import { InquiryController } from './inquery/inquiry.controller';
import { MailService } from './util/mail.service';
import { TypeormConfigService } from './config/typeorm-config.service';
import { MailConfigService } from './config/mail-config.service';
import { ConfigModule } from '@nestjs/config';
import { BrochureModule } from './brochure/brochure.module';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
    }),
    TypeOrmModule.forRootAsync({
      useClass: TypeormConfigService,
    }),
    TypeOrmModule.forFeature([Inquiry]),
    BrochureModule,
  ],
  providers: [InquiryService, MailService, MailConfigService],
  controllers: [InquiryController],
})
export class AppModule {}
