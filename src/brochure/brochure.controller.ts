import { Body, Controller, HttpStatus, Post, Res } from '@nestjs/common';
import { BrochureService } from './brochure.service';
import { Response } from 'express';
import { Brochure } from './brochure.entity';

@Controller('api/brochure')
export class BrochureController {
  constructor(private brochureService: BrochureService) {}

  @Post()
  async create(
    @Body() brochureData: Brochure,
    @Res() response: Response,
  ): Promise<Response> {
    try {
      const number = await this.brochureService.saveInfo(brochureData);

      return response.status(HttpStatus.OK).json({
        message: `brochure no.${number} created`,
      });
    } catch (error) {
      console.error('Error brochure providing', error);
      return response.status(HttpStatus.INTERNAL_SERVER_ERROR).json({
        message: 'Failed to provide brochure info',
        error: error.message,
      });
    }
  }
}
