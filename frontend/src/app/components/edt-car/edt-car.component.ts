import { Component } from '@angular/core';
import { CarDTO } from '../../dto/carDTO';
import { CarService } from '../../services/car.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edt-car',
  templateUrl: './edt-car.component.html',
  styleUrl: './edt-car.component.css'
})
export class EdtCarComponent {
   car : CarDTO = {
    licensePlate : '',
    model : '',
    color : '',
  }

  constructor(
    private carService: CarService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.carService.getById(Number(id)).subscribe((car) => {
      this.car = car
    })
  }
  update() {
    this.carService.update(this.car).subscribe(() => {
      this.router.navigate(['/cars'])
    })
  }

  cancel() {
    this.router.navigate(['/cars'])
  }

}
