import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from '../../services/login-auth.service';
import { UserService } from '../../services/user.service';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  public loginUser:any={};
  public users: any=[];

  constructor(private loginAuthService: LoginAuthService, private userService:UserService) { 
    this.loginAuthService.isLoggedIn();
    this.loginUser=JSON.parse(localStorage.getItem("currentUser"));
    console.log(this.loginUser);
  }


  ngOnInit() {
    this.userService.getAllUsers(this.loginUser.user.token).map(users=>users)
    .subscribe(users => {
      this.users = users;
    })
    //console.log(this.users);
  }

}
