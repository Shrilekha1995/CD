import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { map } from 'rxjs/operators';
import { LoginAuthService } from 'src/app/services/login-auth.service';
@Component({
  selector: 'app-view-attendance-dets',
  templateUrl: './view-attendance-dets.component.html',
  styleUrls: ['./view-attendance-dets.component.css']
})
export class ViewAttendanceDetsComponent implements OnInit {

  public table_show:boolean=false;
  public attendanceDets: any=[];
  public name:any={};
  public loginUser:any={};
  constructor(private userService:UserService,private loginAuthService: LoginAuthService) {
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
   }

  ngOnInit() {
  }
   
     view(prn:any,attend:any)
     {
       this.table_show=true;
      
      this.userService.getAttendanceDets(prn,this.loginUser.token).subscribe(response => {
        if(response)
        {
          this.attendanceDets = response;
              
        }else
        {
          alert("prn doesn't exist try again");
          this.table_show=false;
          attend.reset();
        }
      }
      )

     }




}
