import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from 'src/app/customer.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {
  customerLoginForm: FormGroup;

  emailAddress: string; 
  password: string;

  // public isLoggedIn: boolean;

  constructor(private formBuilder: FormBuilder, private custService: CustomerService) {
    // this.isLoggedIn = this.isLoggedInCheck();
   }

  ngOnInit(): void {
    this.customerLoginForm = this.formBuilder.group({
      customerEmail: ['', Validators.required],
      customerPassword: ['', Validators.required]
  });
  }

  onSubmit(){
    
  }

  customerLogin(email: string, password: string){
    this.custService.getCustomerLogin(email, password)
  }

  customerLogout(){
    localStorage.removeItem("currentUser");
  }

  // isLoggedInCheck(){
  //   if(localStorage.getItem("currentUser")){
  //     return true;
  //   }else{
  //     return false;
  //   }
  // }

}
