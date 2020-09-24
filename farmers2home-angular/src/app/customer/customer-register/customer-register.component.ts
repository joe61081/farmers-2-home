import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/customer.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customerRegisterForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private custService: CustomerService, private router:Router) {
 
   }

   addNewCustomer(newCustomer: Customer){
     this.custService.addNewCustomer(newCustomer);

     this.router.navigate(['/customer/login']);
   }

  ngOnInit(): void {
    this.customerRegisterForm = this.formBuilder.group({
      customerName: ['', Validators.required],
      customerEmail: ['', Validators.required],
      customerPassword: ['', Validators.required],
      customerAddress: ['', Validators.required],
      customerContact: ['', Validators.required]
  });
  }

  onSubmit() {
  }
  

}