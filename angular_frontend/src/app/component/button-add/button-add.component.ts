import { Component, Input} from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-button-add',
  imports: [FormsModule],
  templateUrl: './button-add.component.html',
  styleUrl: './button-add.component.css'
})
export class ButtonAddComponent {
  @Input() onOpenModal(): void {};
}
