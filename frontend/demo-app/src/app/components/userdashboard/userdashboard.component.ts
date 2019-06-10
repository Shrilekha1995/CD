import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from '../../services/login-auth.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  public loginUser:any={};
  public user: any = {};
  constructor(private loginAuthService: LoginAuthService, private userService: UserService) { 
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
    console.log(this.loginUser);
  }

  ngOnInit() {
    this.userService.getUser(this.loginUser.token)
    .subscribe(user => {
      this.user = user;
    })
   
  }

}
