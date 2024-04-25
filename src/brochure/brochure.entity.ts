import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Brochure {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  email: string;

  @Column()
  name: string;

  @Column()
  company: string;

  @Column()
  tel: string;
}
