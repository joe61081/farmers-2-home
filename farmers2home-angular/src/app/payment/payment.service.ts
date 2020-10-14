import { Injectable } from '@angular/core';
import { Farmer } from '../farmer';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Payment } from '../payment';


@Injectable({
    providedIn: 'root'
  })
export class PaymentService {
    rootURL: string;
    isRegistered:boolean;
  currentPayment:Payment

  constructor(private httpsvc: HttpClient) {
    this.currentPayment = JSON.parse(localStorage.getItem("currentPayment"));

    this.rootURL = "http://localhost:8080/farmers2home"
   }
   addNewPayment(newPayment: Payment){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('PaymentType', newPayment.PaymentType)
    params.set('CardNumber', newPayment.CardNumber)
    params.set('SecurityCode', newPayment.SecurityCode)
    params.set('BillingAddress', newPayment.BillingAddress)
    params.set('FirstName', newPayment.FirstName)
    params.set('LastName', newPayment.LastName)
    params.set('ShippingAddress', newPayment.ShippingAddress)
    params.set('ShippingMethod', newPayment.ShippingMethod)
    params.set('Email', newPayment.Email)
    params.set('Password',newPayment.Password)


    return this.httpsvc.post<Farmer>(this.rootURL+"/Payment/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );   
   }
  getPaymentregistered(email: string, password: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)
    params.set('password', password) 
    
    return this.httpsvc.post(this.rootURL+"/payment/login", params.toString(), httpOpts).subscribe(
      (result:any) => {
        if(result){
        localStorage.setItem('currentPayment', JSON.stringify(result));
        this.currentPayment = result;
        this.isRegistered= true;    
        }
      }
    )
}
paymentLogout(){
  localStorage.removeItem("currentPayment");
  this.isRegistered = false;
}

checkIsregistered(){
  if(localStorage.getItem("currentPayment")){
    return true;
  }else{
    return false;
  }
}
}




