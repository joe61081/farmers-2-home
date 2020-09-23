import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/customer.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customerRegisterForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private custService: CustomerService) {
 
   }

   addNewCustomer(newCustomer: Customer){
     this.custService.addNewCustomer(newCustomer);
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
