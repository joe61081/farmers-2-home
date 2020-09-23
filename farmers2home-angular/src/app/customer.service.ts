import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    
    const params = new URLSearchParams();
    params.set('email', newCustomer.emailAddress)
    params.set('pass', newCustomer.password)
    params.set('name', newCustomer.customerName)
    params.set('address', newCustomer.customerAddress)
    params.set('contact', newCustomer.customerContact)

    return this.httpsvc.post<Customer>(this.rootURL+"/customer/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }

}