import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {


  constructor(private custService: CustomerService) { }

  ngOnInit(): void {
  }

  getCustomerOrders(){
    if(this.custService.isLoggedIn == true){
      this.custService.currentUser.customerId;
    }
  }

}
