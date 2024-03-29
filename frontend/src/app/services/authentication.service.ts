
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignInDTO } from '../dto/signInDTO';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private API = `http://localhost:8080/api`

  constructor(
    private httpClient: HttpClient
    ) {
  }

  authenticate(signIn : SignInDTO): Observable<any> {
    return this.httpClient.post<string>(`${this.API}/signin`, signIn)
  }

  authenticateToken(token : any ): Observable<any> {
    return this.httpClient.post<string>(`${this.API}/token`, token)
  }

}
