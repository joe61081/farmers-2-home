import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  rootURL: string;
  private currentUserSubject: BehaviorSubject<Customer>;
  public currentUser: Observable<Customer>;

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

  getCustomerLogin(email: string, password: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)
    params.set('pass', password)

    return this.httpsvc.post(this.rootURL+"/customer/login", params.toString(), httpOpts).subscribe(
      (result:any) => {
        localStorage.setItem('currentUser', JSON.stringify(result));
        // change route to the profile component
        //this.router.navigate(['profile']);
      }
    )
  }

}