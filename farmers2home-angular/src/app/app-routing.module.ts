import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  { path: 'customer', component: CustomerComponent,
  children: [
    {
      path: 'register', // child route path
      component: CustomerRegisterComponent, // child route component that the router renders
    },
    {
      path: 'login', // child route path
      component: CustomerLoginComponent, // child route component that the router renders
    }]
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
