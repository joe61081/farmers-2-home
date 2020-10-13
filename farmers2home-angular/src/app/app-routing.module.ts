import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerComponent } from './customer/customer.component';
import { FarmerComponent } from './farmer/farmer.component';
import { FarmerProfileComponent } from './farmer/farmer-profile/farmer-profile.component';
import { FarmerRegisterComponent } from './farmer/farmer-register/farmer-register.component';
import { FarmerLoginComponent } from './farmer/farmer-login/farmer-login.component';

const routes: Routes = [
  { path: 'customer', component: CustomerComponent,
  children: [
    {
      path: 'profile',
      component: CustomerProfileComponent, 
    },
    {
      path: 'register',
      component: CustomerRegisterComponent, 
    },
    {
      path: 'login',
      component: CustomerLoginComponent, 
    }]
   },
   { path: 'farmers', component: FarmerComponent,
   children: [
     {
       path: 'profile',
       component: FarmerProfileComponent, 
     },
     {
       path: 'register',
       component: FarmerRegisterComponent, 
     },
     {
       path: 'login',
       component: FarmerLoginComponent, 
     }]
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
