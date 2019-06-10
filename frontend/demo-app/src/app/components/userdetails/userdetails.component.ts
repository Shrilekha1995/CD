import { Component, OnInit } from '@angular/core';
import {LoginAuthService} from '../../services/login-auth.service';
import { UserService } from '../../services/user.service';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {

  public loginUser:any={};
  public user: any = {};
  constructor(private loginAuthService: LoginAuthService, private userService: UserService) { 
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
    console.log(this.loginUser);
  }

  ngOnInit() {
    this.userService.getUser(this.loginUser.token).map(user=>user)
    .subscribe(user => {
      this.user = user;
    })
   
  }

}
