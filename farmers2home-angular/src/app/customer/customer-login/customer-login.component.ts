import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {
  customerLoginForm: FormGroup;

  emailAddress: string; 
  password: string;

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    
  }

}
