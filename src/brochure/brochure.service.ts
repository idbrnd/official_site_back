import { Injectable } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Brochure } from './brochure.entity';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class BrochureService {
  constructor(
    @InjectRepository(Brochure)
    private brochureRepository: Repository<Brochure>,
  ) {}

  async saveInfo(brochureData: Brochure): Promise<number> {
    const brochure = await this.brochureRepository.save(brochureData);
    return brochure.id;
  }
}
