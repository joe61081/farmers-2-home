import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { orderProducts } from './orderProducts';
import { Order } from './order'
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  rootURL:string
  
  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:7777/farmertomarket"
}

getOrder():Observable<Order[]>{
  return this.httpsvc.get<Order[]>
  (this.rootURL+"/customer_orders/list")

}

getProducts(productId:number):Observable<orderProducts[]>{
  return this.httpsvc.get<orderProducts[]>(this.rootURL+"/products/orderItem/register")
}


}