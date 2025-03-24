import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
// import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-entitychoice',
  imports: [FormsModule],
  templateUrl: './entitychoice.component.html',
  styleUrl: './entitychoice.component.css'
})
export class EntitychoiceComponent {
  @Input() selectedOption: string = 'sinhvien'; 
  @Input() selectedDB: string = 'mysql';

  constructor(private router: Router) {}

  onOptionChange(value: string) {
    this.selectedOption = value;
    this.selectedDB = 'mysql';
    this.router.navigate([`/${value}/mysql`]);
  }
}
