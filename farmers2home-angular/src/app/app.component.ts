import { Component } from '@angular/core';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'farmers2home-angular';

  themeMode: boolean;

  constructor(public custService:CustomerService) { 
    this.custService.isLoggedIn = custService.checkIsLoggedIn();

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
