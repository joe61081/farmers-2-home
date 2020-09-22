import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customerRegisterForm: FormGroup;

  customerId: number;
  emailAddress: string; 
  password: string;
  customerName: string;
  customerAddress: string;
  customerContact: string;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  //   this.customerRegisterForm = this.formBuilder.group({
  //     customerName: ['', Validators.required],
  //     customerEmail: ['', Validators.required],
  //     customerPassword: ['', Validators.required],
  //     customerAddress: ['', Validators.required],
  //     customerContact: ['', Validators.required]
  // });
  }

  onSubmit() {
  }
  

}
