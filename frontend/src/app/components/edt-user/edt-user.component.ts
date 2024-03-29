import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDTO } from '../../dto/userDTO';

@Component({
  selector: 'app-edt-user',
  templateUrl: './edt-user.component.html',
  styleUrl: './edt-user.component.css'
})
export class EdtUserComponent {

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
    private router: Router,
    private route: ActivatedRoute
  ) { }


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.userService.getById(Number(id)).subscribe((user) => {
      this.user = user
    })
  }

  update() {
    this.userService.update(this.user).subscribe(() => {
       this.router.navigate(['users'])
    })
  }
  cancel() {
     this.router.navigate([`users`])
  }


}
