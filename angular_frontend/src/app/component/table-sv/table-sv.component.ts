import { Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { SinhVien } from '../../entity/sinhvien/sinhvien';
// import { DbchoiceComponent } from '../dbchoice/dbchoice.component';

// @NgModule({
//   imports: [BrowserModule, CommonModule], 
//   providers: [],
// })
// export class AppModule {}


@Component({
  selector: 'app-table-sv',
  imports: [CommonModule],
  templateUrl: './table-sv.component.html',
  styleUrls: ['./table-sv.component.css']
})
export class TableSVComponent {
  @Input() sv!: SinhVien[];
}

