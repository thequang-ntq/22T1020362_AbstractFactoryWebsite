import { Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { Nganh } from '../../entity/nganh/nganh';
@Component({
  selector: 'app-table-ndt',
  imports: [CommonModule],
  templateUrl: './table-ndt.component.html',
  styleUrl: './table-ndt.component.css'
})
export class TableNDTComponent {
  @Input() ndt!: Nganh[];
}
