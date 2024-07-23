import { UserService } from './../../services/user.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../model/user';
import { UserAdd } from '../../model/user-add';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
})
export class FormComponent implements OnInit {
  userList: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getUsers().subscribe((users: User[]) => {
      this.userList = users;
    });
  }
}
