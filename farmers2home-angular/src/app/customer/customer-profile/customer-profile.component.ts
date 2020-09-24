import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/customer.service';
import { Order } from 'src/app/order';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {
  orders :Order[];

  headers = ["orderId", "orderPrice", "orderStatus", "orderDate", "subscription"]

  constructor(public custService:CustomerService, private router:Router) {
   }

  ngOnInit(): void {
    this.getCustomerOrders().subscribe(res=>this.orders=res);
  }

  getCustomerOrders(){
    if(this.custService.isLoggedIn == true){
      return this.custService.getCustomerOrders(this.custService.currentUser.customerId);
    }
  }

  orderDetails(orderId:number){
    this.router.navigate(['/']);
  }

}
