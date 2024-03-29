import { Component } from '@angular/core';
import { CarDTO } from '../../dto/carDTO';
import { CarService } from '../../services/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-car',
  standalone: false,
  templateUrl: './add-car.component.html',
  styleUrl: './add-car.component.css'
})
export class AddCarComponent {

  car : CarDTO = {
    licensePlate : '',
    model : '',
    color : '',
  }

  constructor(
    private carService: CarService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  add() {
    this.carService.add(this.car).subscribe(() => {
      this.router.navigate(['/cars'])
    })
  }

  cancel() {
    this.router.navigate(['/cars'])
  }

}
