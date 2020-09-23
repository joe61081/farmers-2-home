import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  rootURL: string;

  constructor(private httpsvc:HttpClient) { 
    this.rootURL = "http://localhost:8080/farmers2home"
  }

  addNewCustomer(newCustomer: Customer){
    console.log("CUST:", newCustomer)
    console.log(newCustomer.emailAddress)
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded;charset=UTF-8"})
    }
    const params = {
      'email': newCustomer.emailAddress,
      'pass': newCustomer.password,
      'name': newCustomer.customerName,
      'address': newCustomer.customerAddress,
      'contact': newCustomer.customerContact
    };
    
    return this.httpsvc.post<Customer>(this.rootURL+"/customer/register", params, httpOpts);
  }

}
