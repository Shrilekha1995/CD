import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { LoginAuthService } from '../../services/login-auth.service';
import 'rxjs/add/operator/map';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public loginUser:any;
  public user:any={
    
  }
  public adminChk:boolean=false;
  public userChk:boolean=false;
  public loggedinUser:any=localStorage.getItem('currentUser');
  constructor(private userService: UserService, private loginAuthService: LoginAuthService,private router:Router) { 
    this.loginAuthService.isLoggedIn();
   this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
    
  }

  ngOnInit() {
    console.log(this.loggedinUser);
    let user=JSON.parse(this.loggedinUser);
    console.log(user.user.role);
    let role=user.user.role;
    if(role=='ADMIN'){
      this.adminChk=true;
    }else{
      this.userChk=true;
    }
  }

  saveUser(user:any,userForm:any){
    user.enabled = true;
    console.log(user.role);
    this.userService.saveUser(user,this.loginUser.token).map(response=>response)
    .subscribe((response) =>{
      if(response){
        this.router.navigate(['/address']);
        console.log(response);
        userForm.reset();
      }
    })
  }

}
