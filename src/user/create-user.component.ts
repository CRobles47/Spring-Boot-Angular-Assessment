import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from './user.service';
import { User } from './user';
import { UserComponent } from './user.component';

@Component({
    selector: 'create-user',
    templateUrl: 'create-user.component.html',
    styleUrls: ['./user.component.css']
})

export class CreateUserComponent implements OnInit {
    user = new User('', '', '');
    userList!: UserComponent;

    submitted = false;

    @Output() userCreated = new EventEmitter<string>();
    sendNotification() {
        this.userCreated.emit('true');
    }

    constructor(private userService: UserService) { }

    ngOnInit() { }

    save() {
        this.userService
        .createUser(this.user).subscribe(
            data => {
                console.log(data);
            },
            error => console.log(error)
        );
    }

    onSubmit() {
        this.submitted = true;
        this.save();
        this.userCreated.emit('true');
    }

    resetForm(){
       this.user = new User('', '', '');
    }
}