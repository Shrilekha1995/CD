import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from '../../services/login-auth.service';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  public loginUser:any={};
  public users: any=[];

  constructor(private loginAuthService: LoginAuthService, private userService:UserService) { 
    this.loginAuthService.isLoggedIn();
    this.loginUser=JSON.parse(localStorage.getItem("currentUser"));
    console.log(this.loginUser);
  }


  ngOnInit() {
    this.userService.getAllUsers(this.loginUser.user.token)
    .subscribe(users => {
      this.users = users;
    })
  }

}
