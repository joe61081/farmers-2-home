import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { Product } from '../product';
import { ProductService } from '../product.service';

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



  constructor(private productService:ProductService) {
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

  }

  ngOnInit(): void {
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

}  
