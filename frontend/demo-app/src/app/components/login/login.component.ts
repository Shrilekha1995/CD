import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { LoginAuthService } from '../../services/login-auth.service';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user:any= {

  };
  public message:any={};
  lengthCount:boolean=false;
  constructor(private userService: UserService, private router: Router, private loginAuthService: LoginAuthService) {
    this.loginAuthService.isLoggedIn();
   }

  ngOnInit() {
  }

  loginUser(user:any){
    this.userService.loginUser(user).map(response=>response).subscribe((response) =>{
      if(response){
        if(response.token){
          localStorage.setItem('currentUser', JSON.stringify(response));
          console.log(localStorage.getItem("currentUser"));
          if(response.user.role === 'ADMIN'){
            this.router.navigate(['/admindashboard']);
          }else if(response.user.role === 'FACULTY'){
            this.router.navigate(['/facultydashboard']);
          }
          else{
            this.router.navigate(['/userdashboard'])
          }
        }else{
          console.log(response.message);
          console.log("msg:"+JSON.stringify(response.message));
          let msg=JSON.stringify(response.message);
          if(msg.length>0)
            this.lengthCount=true;
          this.message=response.message;
        }
      }
    })
  }
}
