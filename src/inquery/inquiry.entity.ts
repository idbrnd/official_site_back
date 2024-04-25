import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Inquiry {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  company: string;

  @Column()
  name: string;

  @Column()
  emp_title: string;

  @Column()
  phone: string;

  @Column()
  email: string;

  @Column()
  inquiry_category: string;

  @Column()
  inquiry_content: string;
}
