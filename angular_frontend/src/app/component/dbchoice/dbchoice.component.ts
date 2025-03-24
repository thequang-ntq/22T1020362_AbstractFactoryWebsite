import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
// import { Router } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dbchoice',
  imports: [FormsModule],
  templateUrl: './dbchoice.component.html',
  styleUrl: './dbchoice.component.css'
})
export class DbchoiceComponent {
  @Input() selectedDB: string = 'mysql';
  @Input() selectedOption: string = 'sinhvien'; 

  constructor(private router: Router) {}

  onDBChange(db: string) {
    this.selectedDB = db;
    this.router.navigate([`/${this.selectedOption}/${db}`]);
  }
}
