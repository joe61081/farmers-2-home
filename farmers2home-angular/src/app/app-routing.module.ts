import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerComponent } from './customer/customer.component';
import { FarmerComponent } from './farmer/farmer.component';
import { FarmerProfileComponent } from './farmer/farmer-profile/farmer-profile.component';
import { FarmerRegisterComponent } from './farmer/farmer-register/farmer-register.component';
import { FarmerLoginComponent } from './farmer/farmer-login/farmer-login.component';
import { PaymentComponent} from './payment/payment.component';
import { PaymentCheckoutComponent} from './payment/payment-checkout/payment-checkout.component';
import { ContinueToCheckoutComponent} from './payment/continue-to-checkout/continue-to-checkout.component';
import { from } from 'rxjs';
import { ContactUsComponent } from './contact-us/contact-us.component';
// import { ProductComponent } from './product/product.component';
import { OrderComponent } from './order/order.component';
import { compileComponentFromMetadata } from '@angular/compiler';
import { AboutUsComponent } from './about-us/about-us.component';
import { HomeComponent} from './home/home.component';

const routes: Routes = [

  // {
  //   path: 'product', component: ProductComponent
  // },
{
  path: '',
  pathMatch: 'full',
  component: HomeComponent
},
  {
    path: 'about-us', pathMatch: 'full', component: AboutUsComponent
  
  },

  { path: 'customer', component: CustomerComponent,
  children: [
    {
      path: 'profile',
      pathMatch: 'full',
      component: CustomerProfileComponent,
    },
    {
      path: 'register',
      pathMatch: 'full',
      component: CustomerRegisterComponent,
    },
    {
      path: 'login',
      pathMatch: 'full',
      component: CustomerLoginComponent,
    }]
   },
   { path: 'farmers', component: FarmerComponent,
   children: [
     {
       path: 'profile',
       pathMatch: 'full',
       component: FarmerProfileComponent,
     },
     {
       path: 'register',
       pathMatch: 'full',
       component: FarmerRegisterComponent,
     },
     {
       path: 'login',
       pathMatch: 'full',
       component: FarmerLoginComponent,
     }]
    },
  {
      path: 'payment-checkout',
      pathMatch: 'full',
      component: PaymentCheckoutComponent,
    },
    {
    path: 'continue-to-checkout',
    pathMatch: 'full',
    component: ContinueToCheckoutComponent,
    },

  {path: 'contact-us',
   pathMatch: 'full',
    component: ContactUsComponent},

  {path: 'order', pathMatch: 'full', component: OrderComponent}

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

