import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  { path: 'customer', component: CustomerComponent,
  children: [
    {
      path: 'register',
      component: CustomerRegisterComponent, 
    },
    {
      path: 'login',
      component: CustomerLoginComponent, 
    }]
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
