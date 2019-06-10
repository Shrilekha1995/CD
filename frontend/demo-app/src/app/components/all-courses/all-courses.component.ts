import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import 'rxjs/add/operator/map';
import { Router } from '@angular/router';
import { LoginAuthService } from '../../services/login-auth.service';
@Component({
  selector: 'app-all-courses',
  templateUrl: './all-courses.component.html',
  styleUrls: ['./all-courses.component.css']
})
export class AllCoursesComponent implements OnInit {

 
  public loginUser:any={};
  public Allcourse:any={
    
  }

  constructor(private userService:UserService,private router:Router,private loginAuthService: LoginAuthService) { 
    this.loginAuthService.isLoggedIn();
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
  }

  ngOnInit() {
  }



  saveAllCourse(Allcourse:any,AllcourseForm:any)
  {
    localStorage.setItem("moduleCount",Allcourse.moduleCount);
    
    Allcourse.enabled = true;
    try{
      this.userService.saveAllCourse(Allcourse,this.loginUser.token).map(response=>response)
      .subscribe((response) =>{
        if(response){
          console.log("id"+response.id);

          localStorage.setItem("course_id",response.id);
          AllcourseForm.reset();
        }
        else{
          alert("course information couldn't be stored");
        }
      })
    }
     catch
     { 
        alert("course details couldn't be filled");
  
     }
      window.open("/courses","_self");
      
  }

  navigateTo(){
    this.router.navigate(['/courses']);
  }
}
