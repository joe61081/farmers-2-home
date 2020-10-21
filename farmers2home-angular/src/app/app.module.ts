import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { FarmerComponent } from './farmer/farmer.component';
import { FarmerProfileComponent } from './farmer/farmer-profile/farmer-profile.component';
import { FarmerRegisterComponent } from './farmer/farmer-register/farmer-register.component';
import { FarmerLoginComponent } from './farmer/farmer-login/farmer-login.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentCheckoutComponent} from './payment/payment-checkout/payment-checkout.component'
import { from } from 'rxjs';
import { AboutUsComponent } from './about-us/about-us.component';




@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    CustomerProfileComponent,
    CustomerRegisterComponent,
    CustomerLoginComponent,
  
    FarmerComponent,
    FarmerLoginComponent,
    FarmerProfileComponent,
    FarmerRegisterComponent,

    PaymentComponent,
    PaymentCheckoutComponent,
    AboutUsComponent,
    
  
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
