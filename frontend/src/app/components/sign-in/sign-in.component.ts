import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from '../../services/token.service';
import { AuthenticationService } from '../../services/authentication.service';
import { SignInDTO } from '../../dto/signInDTO';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent {

  signIn : SignInDTO = {
    login: '',
    password: '',
  }


  constructor(
    private tokenService: TokenService,
    private authenticationService: AuthenticationService,
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  signin() {
       this.authenticationService.authenticate(this.signIn).subscribe(result => {
        if (result && result.token) {
          this.tokenService.setToken(result.token);
          this.router.navigate(['/cars']);
        } else {
          console.error('Token inválido');
        }
      })
  }

}
