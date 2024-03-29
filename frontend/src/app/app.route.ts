import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListUsersComponent } from './components/list-users/list-users.component';
import { ListCarsComponent } from './components/list-cars/list-cars.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { AddCarComponent } from './components/add-car/add-car.component';
import { EdtUserComponent } from './components/edt-user/edt-user.component';
import { EdtCarComponent } from './components/edt-car/edt-car.component';
import { authGuard } from './guard/auth.guard';

export const routes: Routes = [
  { path: 'users', component: ListUsersComponent },
  { path: 'user/add', component: AddUserComponent },
  { path: 'user/edit/:id', component: EdtUserComponent },
  { path: 'cars', component: ListCarsComponent , canActivate: [authGuard]},
  { path: 'car/add', component: AddCarComponent , canActivate: [authGuard]},
  { path: 'car/edit/:id', component: EdtCarComponent , canActivate: [authGuard]},
  { path: 'sign-in', component: SignInComponent },
  { path: 'signin', component: SignInComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
