import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
})
export class FormComponent implements OnInit {
  user = {
    email: '',
    password: '',
  };

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onSubmit() {
    const url = 'http://localhost:8080/rest/users/add';
    this.http.post(url, this.user).subscribe(
      (response) => {
        console.log('User added successfully', response);
      },
      (error) => {
        console.error('There was an error!', error);
      }
    );
  }
}
