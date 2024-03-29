import { Component } from '@angular/core';
import { UserDTO } from '../../dto/userDTO';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TokenService } from '../../services/token.service';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrl: './list-users.component.css',
})
export class ListUsersComponent {

  users : UserDTO[] = [];

  constructor(
    private userService : UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getUserList()
  }



  getUserList(){
    this.userService.getUsers().subscribe((users) => {
      this.users = users;
    })
  }

  update(id : number) {
    this.router.navigate([`/user/edit/${id}`])
  }

  delete(id : number) {
    this.userService.delete(id).subscribe(() => {
      this.ngOnInit();
    })
  }


}
