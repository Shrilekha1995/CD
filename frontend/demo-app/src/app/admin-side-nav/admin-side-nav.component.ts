import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LoginAuthService } from '../services/login-auth.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-admin-side-nav',
  templateUrl: './admin-side-nav.component.html',
  styleUrls: ['./admin-side-nav.component.css']
})
export class AdminSideNavComponent {

  public loginUser:any;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,private loginAuthService: LoginAuthService, private userService:UserService) {
    this.loginAuthService.isLoggedIn();
    this.loginUser=JSON.parse(localStorage.getItem("currentUser"));
    console.log(this.loginUser);
  }

}
