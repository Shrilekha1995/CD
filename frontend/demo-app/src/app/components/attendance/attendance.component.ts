import { Component, OnInit } from "@angular/core";
import { LoginAuthService } from "../../services/login-auth.service";
import { UserService } from "../../services/user.service";
import { LocationService } from "../../services/location.service";
import { Response } from "@angular/http";
import "rxjs/add/operator/map";
@Component({
  selector: "app-attendance",
  templateUrl: "./attendance.component.html",
  styleUrls: ["./attendance.component.css"]
})
export class AttendanceComponent implements OnInit {
  public loginUser: any = {};
  public user: any = {};
  public ip: any = {};
  public token: any = {};
  public coords: any = {};
  public result: string = "";
  constructor(
    private loginAuthService: LoginAuthService,
    private userService: UserService,
    private locationService: LocationService
  ) {
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
    this.token = this.loginUser.token;
    console.log("user:" + this.token);
  }

  ngOnInit() {
    this.locationService
      .getLocation()
      .map(response => response)
      .subscribe(response => {
        this.loginUser.user.ip = response.ip;
        console.log(response);

        console.log(this.loginUser.user.ip);
      });
    this.locationService
      .getLocationUpdate()
      .map(location => location)
      .subscribe(location => {
        this.coords = location.coords;
        this.loginUser.user.latitude = this.coords.latitude;
        this.loginUser.user.longitude = this.coords.longitude;
        console.log(this.loginUser.user.latitude);
        console.log(this.loginUser.user.longitude);

        console.log("location");
      });
  }

  submitAttendance() {
    if (this.loginUser.user.latitude !== null)
      this.userService
        .submitAttendance(this.loginUser)
        .map(data => data)
        .subscribe(data => {
          console.log(data);
          this.result = data;
          alert(this.result);
        });
    else {
      // alert("System is fetching co-ordinates");
      while(this.loginUser.user.latitude === null) {
        this.submitAttendance();
      }
    }
  }
}
