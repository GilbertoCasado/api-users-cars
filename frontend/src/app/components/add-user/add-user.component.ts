import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { UserDTO } from '../../dto/userDTO';

@Component({
  selector: 'app-add-user',
  standalone: false,
  templateUrl: './add-user.component.html',
  styleUrl: './add-user.component.css'
})
export class AddUserComponent {

  user: UserDTO = {
          firstName : '',
          lastName : '',
          email : '',
          birthday : '',
          login : '',
          password : '',
          phone : '',
        }

  constructor(
    private userService : UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  add() {
    this.userService.add(this.user).subscribe(() => {
       this.router.navigate(['users'])
    })
  }

  cancel() {
     this.router.navigate([`users`])
  }
}
