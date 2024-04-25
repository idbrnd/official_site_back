import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import * as fs from 'node:fs';

async function bootstrap() {
  const httpsOptions = {
    key: fs.readFileSync('/etc/letsencrypt/live/idb.ai/privkey.pem'),
    cert: fs.readFileSync('/etc/letsencrypt/live/idb.ai/fullchain.pem'),
  };

  const app = await NestFactory.create(AppModule, {
    httpsOptions,
  });

  await app.listen(3000);
}
bootstrap();
