import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Customer } from './customer';
import { CustomerService } from './customer.service';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'farmers2home-angular';

  themeMode: boolean;

  constructor() { 
    if(localStorage.getItem('themeMode')){
      this.themeMode = JSON.parse(localStorage.getItem('themeMode'));
    }else{
      this.themeMode = true;
    }
    
  }

  toggleTheme(){
      this.themeMode = !this.themeMode;
      localStorage.setItem('themeMode', JSON.stringify(this.themeMode));
  }
}
