import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FarmerService } from '../farmer.service';
import { Router } from '@angular/router';
import { Farmer } from 'src/app/farmer';

@Component({
  selector: 'app-farmer-register',
  templateUrl: './farmer-register.component.html',
  styleUrls: ['./farmer-register.component.css']
})
export class FarmerRegisterComponent implements OnInit {

  farmerRegisterForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private farmerService: FarmerService, private router:Router) {

   }

   addNewFarmer(newFarmer: Farmer){
     this.farmerService.addNewFarmer(newFarmer);

     this.router.navigate(['farmers/login'])
   }

  ngOnInit(): void {
    this.farmerRegisterForm = this.formBuilder.group({
      farmerFirstName: ['', Validators.required],
      farmerLastName: ['', Validators.required],
      farmerEmail: ['', Validators.required],
      farmerPassword: ['', Validators.required],
      farmerLocation: ['', Validators.required],
      farmerContact: ['', Validators.required]
    })
  }

  onSubmit(){
    
  }

}
