import { RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ListUsersComponent } from './components/list-users/list-users.component';
import { ListCarsComponent } from './components/list-cars/list-cars.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app.route';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddUserComponent } from './components/add-user/add-user.component';
import { AddCarComponent } from './components/add-car/add-car.component';
import { EdtCarComponent } from './components/edt-car/edt-car.component';
import { EdtUserComponent } from './components/edt-user/edt-user.component';
import { AuthInterceptor } from './interceptors/auth.interceptor';



@NgModule({
  declarations: [
    AppComponent,
    ListUsersComponent,
    ListCarsComponent,
    SignInComponent,
    AddUserComponent,
    AddCarComponent,
    EdtCarComponent,
    EdtUserComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    RouterModule,
    HttpClientModule,
    CommonModule,
    RouterOutlet,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,

  ],
  providers: [ { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
