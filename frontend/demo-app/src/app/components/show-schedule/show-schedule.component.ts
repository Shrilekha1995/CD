import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ScheduleDets } from 'src/models/scheduleDets';
import { LoginAuthService } from 'src/app/services/login-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-schedule',
  templateUrl: './show-schedule.component.html',
  styleUrls: ['./show-schedule.component.css']
})
export class ShowScheduleComponent implements OnInit {
 
  public table_show:boolean=false;
  public date1:any={
    
  }
  public user:any={}
  public role:any;
  public temp:number;
  public loginUser:any={};
  public schDets:ScheduleDets;
  constructor(private loginAuthService: LoginAuthService,private userService:UserService,private router:Router) 
  { 
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
    console.log(this.loginUser);
  }

   //sending back to dashboard acoording to logged in user
userCheck(){
  this.user = JSON.parse(localStorage.getItem("currentUser"));
  console.log(this.user.user.role);
  this.role = this.user.user.role;
  if(this.role === "ADMIN")
    this.router.navigate(['/admindashboard']);
  else if(this.role === "FACULTY")
    this.router.navigate(['/facultydashboard']);
  else
    this.router.navigate(['/userdashboard']);
}

  getSchedule()
  {
    console.log(this.date1);
    //alert(this.loginUser.token);
    this.userService.getSchedule(this.date1,this.loginUser.token)
    .subscribe((response) =>{
      if(response){
       this.table_show=true;
      this.schDets=response;
        console.log(response);
        
        
         
          
        
        
      }
      else{
        alert("no. schedule present for the date");
        this.table_show=false;
      }
    })  
  }


  ngOnInit() {
  
  }
 
  calc(date1:any)
  {
    this.getSchedule();
  }
  

}

