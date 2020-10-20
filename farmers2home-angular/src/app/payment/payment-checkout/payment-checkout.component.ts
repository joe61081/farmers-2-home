import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from 'src/app/payment';
import { PaymentService } from '../payment.service';

@Component({
  selector: 'app-payment-checkout',
  templateUrl: './payment-checkout.component.html',
  styleUrls: ['./payment-checkout.component.css']
})
export class PaymentCheckoutComponent implements OnInit {

  constructor(private paymentService:PaymentService, private router:Router) { }

  addNewPayment(newPayment:Payment){
    this.paymentService.addNewPayment(newPayment);
  }

  ngOnInit(): void {
    
  }

}
