import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'user-app',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users!: Observable<User[]>;
  userToEdit = new User('','','');

  constructor(private userService: UserService) {}
  

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getUsers();
  }

  deleteUser(id: number) {
    this.userService.deleteUser(id)
    .subscribe(
        data => {
            console.log(data);
            this.reloadData();
        }, error => console.log(error)
    );
  }

  updateUser() {
    this.userService.updateUser(this.userToEdit.userId, this.userToEdit)
    .subscribe(
        data => {
            console.log(data);
    }, error => console.log(error))
  }

  getNotification($event: any) {
    window.location.reload();
  }

  displayStyle = "none";
  
  openPopup(user: User) {
    this.userToEdit = user;
    this.displayStyle = "block";
  }

  closePopup() {
    this.displayStyle = "none";
  }

  submitted = false;

  onSubmit(){
    this.submitted = true;
    this.updateUser();
    this.closePopup();
  }

}
