import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDTO } from '../dto/userDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

private API = `http://localhost:8080/api/users`



  constructor(private httpClient: HttpClient) {
  }


  getUsers(): Observable<UserDTO[]> {
    return this.httpClient.get<UserDTO[]>(this.API)
  }

  add(user: UserDTO): Observable<UserDTO> {
    return this.httpClient.post<UserDTO>(this.API, user)
  }

  delete(id: number): Observable<UserDTO> {

    return this.httpClient.delete<UserDTO>(`${this.API}/${id}`)
  }

  getById(id: number): Observable<UserDTO> {
    return this.httpClient.get<UserDTO>(`${this.API}/${id}`)
  }

  update(user: UserDTO): Observable<UserDTO> {
    return this.httpClient.put<UserDTO>(`${this.API}/${user.id}`, user)
  }

}
