import { Injectable } from '@angular/core';
import { Farmer } from '../farmer';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FarmerService {
  rootURL: string;
  isLoggedIn:boolean;
  currentFarmer:Farmer
  isEmailInUse:boolean

  constructor(private httpsvc:HttpClient) {
    this.currentFarmer = JSON.parse(localStorage.getItem("currentFarmer"));

    this.rootURL = "http://localhost:8080/farmers2home"
   }

   addNewFarmer(newFarmer: Farmer){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', newFarmer.email)
    params.set('password', newFarmer.password)
    params.set('farmerFirstName', newFarmer.farmerFirstName)
    params.set('farmerLastName', newFarmer.farmerLastName)
    params.set('location', newFarmer.location)
    params.set('contactNumber', newFarmer.contactNumber)

    return this.httpsvc.post<Farmer>(this.rootURL+"/farmers/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );   
   }

   checkEmail(email: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)

    return this.httpsvc.post<boolean>(this.rootURL+"/farmers/emailcheck", params.toString(), httpOpts).subscribe(
      Response => {
        this.isEmailInUse = Response; 
        }
    )
   }

   getFarmerLogin(email: string, password: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)
    params.set('password', password) 
    
    return this.httpsvc.post(this.rootURL+"/farmers/login", params.toString(), httpOpts).subscribe(
      (result:any) => {
        if(result){
        localStorage.setItem('currentFarmer', JSON.stringify(result));
        this.currentFarmer = result;
        this.isLoggedIn= true;    
        }
      }
    )
}

farmerLogout(){
  localStorage.removeItem("currentFarmer");
  this.isLoggedIn = false;
}

checkIsLoggedIn(){
  if(localStorage.getItem("currentFarmer")){
    return true;
  }else{
    return false;
  }
}
}
