import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    CustomerRegisterComponent,
    CustomerLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
