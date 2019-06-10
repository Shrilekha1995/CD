import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { headersToString } from "selenium-webdriver/http";
import { ScheduleDets } from 'src/models/scheduleDets';
@Injectable({
  providedIn: "root"
})
export class UserService {
  public loggedin: any = {};
  constructor(private http: HttpClient) {
    this.http = http;
  }

  saveUser(user: any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
    return this.http.post("http://localhost:8080/registration", user, {
      headers: headers
    });
  }

  saveAllCourse(Allcourse: any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
    return this.http.post("http://localhost:8080/addAllCourses", Allcourse, {
      headers: headers
    });
  }

  saveModule(module: any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
    return this.http.post("http://localhost:8080/addCourses", module, {
      headers: headers
    });
  }

  saveSchedule(schedule: any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
    return this.http.post("http://localhost:8080/schedule", schedule, {
      headers: headers
    });
  }

  loginUser(user: any): Observable<any> {
    const headers = new HttpHeaders({ "Access-Control-Allow-Origin": "*" });
    //this.loggedin =
    return this.http.post("http://localhost:8080/login", user, {
      headers: headers
    });
  //  console.log(this.loggedin.token);
   // return this.loggedin;
  }
  saveAddress(adrDets: any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
    return this.http.post("http://localhost:8080/address",adrDets,{headers: headers});
  }
  getAllUsers(token: any): Observable<any> {
    console.log(token);
    const headers = new HttpHeaders({ Authorization: "Bearer " + token });
    return this.http.get("http://localhost:8080/users", { headers: headers });
  }

  getUser(token: any): Observable<any> {
    console.log(token);
    const headers = new HttpHeaders({ Authorization: "Bearer " + token });
    return this.http.get("http://localhost:8080/getuser", { headers: headers });
  }

  submitAttendance(user: any):Observable<any> {
    const headers = new HttpHeaders({
      "Access-Control-Allow-Origin": "*",
      Authorization: "Bearer " + user.token
    });
    var httpOptions = {
      headers: new HttpHeaders({
        "Access-Control-Allow-Origin": "*",
        Authorization: "Bearer " + user.token
      }),
      responseType: "text"
    };
    return this.http.post("http://localhost:8080/attendance", user.user, {
      headers: headers,
      responseType: "text"
    });
  }

  getSchedule(date1:any,token:any): Observable<any> {
    console.log(token);
    
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
        return this.http.post<ScheduleDets>("http://localhost:8080/viewschedule",date1,{headers:headers});
    
  }

  saveRoomData(room:any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
    return this.http.post<ScheduleDets>("http://localhost:8080/saveRoomData",room,{headers: headers});
    
  }

  cancelClass(cancel: any): Observable<any> {
    //const headers = new HttpHeaders({'Access-Control-Allow-Origin':'*'});
    const headers = new HttpHeaders({'Authorization':'Bearer '+cancel.sourceId});
    return this.http.post("http://localhost:8080/cancelClass",cancel,{headers: headers,responseType:"text"});
  }

  getAttendanceDets(prn:any,token:any): Observable<any> {
    const headers = new HttpHeaders({'Authorization':'Bearer '+token,'Access-Control-Allow-Origin':'*'});
        return this.http.post<any>("http://localhost:8080/getatt",prn,{headers:headers});
    
  }

}
