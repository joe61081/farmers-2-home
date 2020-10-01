import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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

  constructor(private formBuilder: FormBuilder, private custService: CustomerService, private router:Router) {
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
    this.custService.getCustomerLogin(email, password).then(()=>{
      this.router.navigate(['/customer/profile']);
    });
  }

}
