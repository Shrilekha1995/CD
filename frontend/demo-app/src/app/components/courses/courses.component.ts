import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { ModuleDets } from 'src/models/moduleDets';

import { forEach } from '@angular/router/src/utils/collection';
import { Router } from '@angular/router';
import { LoginAuthService } from 'src/app/services/login-auth.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
 public loginUser:any={};
  module:any={};

  constructor(private userService: UserService,private router:Router,private loginAuthService: LoginAuthService) { 
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
  }

ngOnInit() {
 
     this.module.courseId=localStorage.getItem("course_id");
     console.log("id:"+this.module.courseId)
   }

  asyncing()
  {
        
  }

  saveModule(module:any,moduleForm:any)
  {
    module.enabled = true;
    alert(module.moduleName);
    localStorage.setItem("course_id",null);
    this.userService.saveModule(this.module,this.loginUser.token)
    .subscribe((Response) =>{
      if(Response){
        console.log(Response);
        alert("returned")
        alert(Response.message);
        moduleForm.reset();
      }
    }) 
    this.router.navigate(['/admindashboard']);
  }


  moveNext(module:any,moduleForm:any)
  {
    module.enabled = true;
    alert(module.moduleName);
    this.userService.saveModule(this.module,this.loginUser.token)
    .subscribe((Response) =>{
      if(Response){
        console.log(Response);
        alert("returned")
        alert(Response.message);
        moduleForm.reset();
      }
    }) 
    
    window.location.reload();
  }

  
  





}
