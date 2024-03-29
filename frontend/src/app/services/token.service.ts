import { Injectable } from '@angular/core';

const KEY = 'token';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private  KEY = "jwt_token"
  constructor() {}

  public isAuthenticated(): boolean {
    const token = localStorage.getItem(this.KEY);
    return !!token;
  }

  public getToken(): string | null {
    return localStorage.getItem(this.KEY);
  }

  public setToken(token: string): void {
    localStorage.setItem(this.KEY, token);
  }

  public logout(): void {
    localStorage.removeItem(this.KEY);
  }

}
