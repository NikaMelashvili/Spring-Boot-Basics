import { Routes } from '@angular/router';
import { FormComponent } from './components/form/form.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'user' },
  { path: 'user', component: FormComponent },
];
