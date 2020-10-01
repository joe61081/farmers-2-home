import { Component, OnInit } from '@angular/core';
import { FarmerService } from '../farmer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-farmer-profile',
  templateUrl: './farmer-profile.component.html',
  styleUrls: ['./farmer-profile.component.css']
})
export class FarmerProfileComponent implements OnInit {

  constructor(public farmerService: FarmerService, private router:Router) { }

  ngOnInit(): void {
  }

}
