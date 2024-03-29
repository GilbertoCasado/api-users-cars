import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CarDTO } from '../dto/carDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private readonly API = `http://localhost:8080/api/cars`

  constructor(private httpClient: HttpClient) {
  }

  getCars(): Observable<CarDTO[]> {
    return this.httpClient.get<CarDTO[]>(this.API)
  }

  add(car: CarDTO): Observable<CarDTO> {
    return this.httpClient.post<CarDTO>(this.API, car)
  }

  delete(id: number): Observable<CarDTO> {
    const url = `${this.API}/${id}`
    return this.httpClient.delete<CarDTO>(url)
  }

  getById(id: number): Observable<CarDTO> {
    const url = `${this.API}/${id}`
    return this.httpClient.get<CarDTO>(url)
  }

  update(car: CarDTO): Observable<CarDTO> {
    const url = `${this.API}/${car.id}`
    return this.httpClient.put<any>(url, car)
  }
}
