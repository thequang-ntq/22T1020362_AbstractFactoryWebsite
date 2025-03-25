import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-button-delete',
  imports: [FormsModule],
  templateUrl: './button-delete.component.html',
  styleUrl: './button-delete.component.css'
})
export class ButtonDeleteComponent {
  @Input() onOpenModal(): void {};
}
