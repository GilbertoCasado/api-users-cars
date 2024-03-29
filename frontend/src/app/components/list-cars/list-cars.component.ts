import { Component } from '@angular/core';
import { CarService } from '../../services/car.service';
import { Router } from '@angular/router';
import { CarDTO } from '../../dto/carDTO';

@Component({
  selector: 'app-list-cars',
  standalone: false,
  templateUrl: './list-cars.component.html',
  styleUrl: './list-cars.component.css'
})
export class ListCarsComponent {

  cars : CarDTO[]= [];

  constructor(
    private carService : CarService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.carService.getCars().subscribe((cars) => {
        this.cars = cars;
    })
  }



  delete(id : number) {
    this.carService.delete(id).subscribe(() => {
      this.ngOnInit();
    })
  }

  update(id : number) {
    this.router.navigate([`car/edit/${id}`])
  }

}
