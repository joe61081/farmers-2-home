import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  rootURL: string;

// declare the client object in constructor to use in this service.
  constructor(private httpSvc:HttpClient) { 
    this.rootURL = "http://localhost:8080/farmers2home"
  }

  addProductToFarmer(farmerId:number, productId:number):Observable<Product[]>{
    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
      }

      var reqBody = "farmerId="+farmerId+"&productId="+productId

      return this.httpSvc.post<Product[]>(
        this.rootURL+"/farmer_to_product_assignment/", reqBody, httpOpts
      )
  }
  

  addNewProduct(newProduct: Product) {
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('productName', newProduct.productName)
    params.set('productDesc', newProduct.productDesc)
    params.set('productCat', newProduct.productCat)

    return this.httpSvc.post<Product>(this.rootURL+"/products/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  
    }

  findProductsByFarmerNo(farmerId:number):Observable<Product[]>{
    return this.httpSvc.get<Product[]>(this.rootURL+"/product/"+farmerId)
  }

  registerProductsForFarmer(farmerId:number,newProduct:Product):Observable<Product>{
    var contentData = "farmerId="+farmerId
                      +"&productName="+newProduct.productName
                      +"&productDesc="+newProduct.productDesc
                      +"&productCat="+newProduct.productCat
                      +"&productPrice="+newProduct.productPrice
                      +"&stockQuantity="+newProduct.stockQuantity

    const httpOptions={
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"})
    }
    
    return this.httpSvc.post<Product>(
    this.rootURL+"/products/register", // URL
    contentData, // data for the server
    httpOptions) // header options
  }

}