import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer/farmer.service';
import { Order } from '../Order';
import { OrderService } from '../order.service';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { orderProducts } from '../orderProducts';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  currentFarmer: Farmer
  farmerProducts: Product[]
  isFarmerEditing: boolean
  isProductFormVisible: boolean
  currentProduct: Product;
  products: Product[]
  orders: Order[]
  newProduct: Product[]
  orderProducts: orderProducts[]


  constructor(private productService:ProductService, private farmerService:FarmerService, private orderService: OrderService, private router:Router) {
    this.isProductFormVisible=false

    this.currentProduct=
    {
      productId: 216,
      productName:"Milk",
      productDesc:"Semi-Skimmed",
      productCat:"DAIRY",
      productPrice:1,
      stockQuantity:18,
    }

    this.farmerProducts=
    [
      {productId:1,
      productName:"Milk",
      productDesc:"Semi-Skimmed",
      productCat:"DAIRY",
      productPrice:1,
      stockQuantity:18}
    ]
    this.products=[]
  }

  addProductsToOrder(productId:number, orderId:number, newProduct:Product){
    this.productService.addNewProduct(newProduct).subscribe(
      res => 
      { newProduct = res
      this.productService.addProductToOrder(orderId, newProduct.productId).subscribe(
        res => {
          this.products = res
        }
      )}
    )
  }
 

  fetchFarmerProductsFromServer(){
    this.productService.findProductsByFarmerNo(this.currentFarmer.farmerId).subscribe(
      response => {
        this.farmerProducts = response
      }
    )
  }

  showProductForm(){
    this.isProductFormVisible=true
  }

  addNewProduct(newProduct:Product){
    this.productService.registerProductsForFarmer(
      this.currentFarmer.farmerId,newProduct).subscribe(
        response =>{
          this.fetchFarmerProductsFromServer()
        }
      )

    this.isProductFormVisible=true
  }
  ngOnInit(): void {
 
this.productService.getProducts().subscribe(
  res => {this.products=res
    console.log(JSON.stringify(this.products))}

  
)}}

