import { BrochureService } from './brochure.service';
import { BrochureController } from './brochure.controller';
import { Brochure } from './brochure.entity';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Module } from '@nestjs/common';

@Module({
  imports: [TypeOrmModule.forFeature([Brochure])],
  providers: [BrochureService],
  controllers: [BrochureController],
  // exports: [BrochureService],
})
export class BrochureModule {}
