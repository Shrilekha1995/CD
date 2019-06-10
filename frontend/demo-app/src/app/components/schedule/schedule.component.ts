import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import 'rxjs/add/operator/map';
import { LoginAuthService } from 'src/app/services/login-auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  public loginUser:any={};
  public schedule:any={
    
  }
  

  constructor(private userService: UserService,private loginAuthService: LoginAuthService,private router:Router) {
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
   }

  ngOnInit() {
  }

  saveSchedule(schedule:any,scheduleForm:any)
  {
    alert(schedule.from1);
    schedule.enabled = true;
    this.userService.saveSchedule(schedule,this.loginUser.token).map(response=>response)
    .subscribe((response) =>{
      if(response){
        console.log(response);
        scheduleForm.reset();
        this.router.navigate(['/admindashboard']);
      }
      else{
        alert("SCHEDULE couldn't be saved ,,try again");
      }
    })  
  }

}
