import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-cancel-class',
  templateUrl: './cancel-class.component.html',
  styleUrls: ['./cancel-class.component.css']
})
export class CancelClassComponent implements OnInit {
  public cancel:any={
    
  }
  constructor(private userService: UserService) {
    this.cancel.sourceId=JSON.parse(localStorage.getItem('currentUser')).token;

   }

  ngOnInit() {
    //this.loginUser=JSON.parse(localStorage.getItem("currentUser"));
  }
  

  

  cancelClass(cancel:any,cancelForm:any)
  {
    console.log(this.cancel.sourceId);
    cancel.enabled = true;
    this.userService.cancelClass(cancel)
    .subscribe((Response) =>{
      if(Response){
        console.log(Response);
        alert("returned")
        alert(Response.message);
        cancelForm.reset();
      }
        
    })  
  }
  }
