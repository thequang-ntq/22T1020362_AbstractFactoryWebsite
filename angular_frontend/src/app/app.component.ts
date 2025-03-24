import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './component/header/header.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  // standalone: false,
  imports: [RouterOutlet, HeaderComponent, RouterModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular_frontend';
}
