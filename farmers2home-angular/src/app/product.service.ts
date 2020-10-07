import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  serviceURL: string;

// declare the client object in constructor to use in this service.
  constructor(private httpSvc:HttpClient) { 
    this.serviceURL = "http://localhost:8080/farmers2home"
  }

  addNewProduct(newProduct: Product) {
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('productName', newProduct.productName)
    params.set('productDesc', newProduct.productDesc)
    params.set('productCat', newProduct.productCat)

    return this.httpSvc.post<Product>(this.serviceURL+"/product/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }


  findProductsByFarmerNo(farmerId:number):Observable<Product[]>{
    return this.httpSvc.get<Product[]>(this.serviceURL+"/product/"+farmerId)
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
    this.serviceURL+"/product/register", // URL
    contentData, // data for the server
    httpOptions) // header options
  }

}