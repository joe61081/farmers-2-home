import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  rootURL: string;
  isLoggedIn:boolean;
  currentUser: Customer;

  constructor(private httpsvc:HttpClient) { 
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));

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

  async getCustomerLogin(email: string, password: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)
    params.set('pass', password)

    const result = await this.httpsvc.post<Customer>(this.rootURL+"/customer/login", params.toString(), httpOpts).toPromise();
    if(result){
      this.currentUser = result;
      localStorage.setItem('currentUser', JSON.stringify(result));
      this.isLoggedIn= true;
      }
      return result;
  }

  getCustomerOrders():Observable<Order[]>{
    return this.httpsvc.get<Order[]>(this.rootURL+"/customer/orders/"+this.currentUser.customerId);
  }

  customerLogout(){
    localStorage.removeItem("currentUser");
    this.isLoggedIn = false;
  }

  checkIsLoggedIn(){
    if(localStorage.getItem("currentUser")){
      return true;
    }else{
      return false;
    }
  }

}