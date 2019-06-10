import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from '../../services/login-auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

   public currentStatus: any;
   public loggedinUser:any;
   public roleAdmin:boolean=false;
   constructor(private loginAuthService: LoginAuthService, private router: Router){
     this.currentStatus = this.loginAuthService.getStatus()
     .subscribe(currentStatus =>{
       this.currentStatus = currentStatus;
     });
     this.loginAuthService.isLoggedIn();
   }

   logout(){
    localStorage.removeItem('currentUser');
    this.roleAdmin=false;
    this.router.navigate(['login']);
   }
  ngOnInit() {
    console.log(this.loginAuthService.isLoggedIn());
    if(this.loginAuthService.isLoggedIn()){
    this.loggedinUser=JSON.parse(localStorage.getItem('currentUser'));
    console.log("user:"+this.loggedinUser);
    if(this.loggedinUser.user.role=="ADMIN"){
      this.roleAdmin=true;
    }
  }
  }

}
