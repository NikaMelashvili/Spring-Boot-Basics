import { Component } from '@angular/core';
import { FormComponent } from './components/form/form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormComponent],
  // templateUrl: './app.component.html',
  template: ` <app-form></app-form> `,
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'forms-front';
}
