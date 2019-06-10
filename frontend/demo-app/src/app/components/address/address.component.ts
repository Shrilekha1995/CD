import { Component, OnInit } from '@angular/core';
import { AddressDets } from 'src/models/Address';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
 
  public loginUser:any={};
  public adrDets={

  }
  
  constructor(private userService:UserService,private router:Router) { 
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
  }

  ngOnInit() {
  }
  
  saveAddress(adrDets:any,addressForm:any)
  {
    alert(adrDets.addressLineOne);
        this.userService.saveAddress(adrDets,this.loginUser.token)
    .subscribe((response) =>{
      if(response){
        this.router.navigate(['/admindashboard']);
        console.log(response);
        addressForm.reset();
      }
    })  
  }


}
