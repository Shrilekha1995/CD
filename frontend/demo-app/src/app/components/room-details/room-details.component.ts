import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {

   public loginUser:any={};
   public room:any={ };

  constructor(private userService:UserService,private router:Router) {
    this.loginUser = JSON.parse(localStorage.getItem("currentUser"));
     
  }

  ngOnInit() {
   
  }

  saveRoomData(room:any,roomForm:any){
    alert("saved");
    this.userService.saveRoomData(room,this.loginUser.token).map(response=>response).subscribe((response) =>{
      if(response){
          console.log(response);
          this.router.navigate(['/admindashboard']);
           roomForm.reset();     
        }
      
     }
    )
  }


}
