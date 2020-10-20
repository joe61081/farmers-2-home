import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import {ContactUsComponent} from '../app/contact-us/contact-us.component'
import { Contact } from './contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  rootURL: string;
  rootProductURL: string;


  constructor(public httpsvc:HttpClient) {
    

    this.rootURL = "http://localhost:8080/farmers2home"
    this.rootProductURL="http://localhost:8080/farmer2home/contact"
   }

   addContactDetails( newContact: Contact):Observable<Contact>{
     const httpOpts ={
       headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
   }
   const params = new URLSearchParams();
   params.set('name', newContact.name)
   params.set('email', newContact.email)
   params.set('message', newContact.message)

  }}
   

