import { Component, OnInit } from '@angular/core';
import { FarmerService } from '../farmer.service';
import { Router } from '@angular/router';
import { ProductService } from '../../product.service';
import { Farmer } from '../../farmer';
import { Product } from '../../product';
import { FarmerProducts } from '../farmerProducts';

@Component({
  selector: 'app-farmer-profile',
  templateUrl: './farmer-profile.component.html',
  styleUrls: ['./farmer-profile.component.css']
})
export class FarmerProfileComponent implements OnInit {


  Farmers:Farmer[]
  Products:Product[]
  productId: number
  farmerProducts:FarmerProducts[]
  farmerId:number

  constructor( private farmerService:FarmerService, private productService:ProductService, private router:Router) { 
    this.Products=[]
    this.Farmers=[]
    this.farmerProducts=[]
  }

  
  addProductToFarmer(farmerId:number, productId:number){
    this.productService.addProductToFarmer(farmerId, productId, ).subscribe(
      res=>{
        this.Products=res
        res => {this.Farmers =res}
      }
    )
  }
  ngOnInit(): void {
  
    this.farmerService.getProducts().subscribe(
      res =>{ this.farmerProducts= res
        console.log(JSON.stringify(this.farmerProducts))} 
    )

  }

}
