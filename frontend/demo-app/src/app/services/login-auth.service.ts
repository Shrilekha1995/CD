import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {

  private subject= new Subject<any>();
  isLoggedIn(){
    if(localStorage.getItem('currentUser')){
      this.subject.next({status: true});
      return true;
    }else{
      this.subject.next({status: false});
      return false;
    }
  }

  clearStatus(){
    this.subject.next();
  }

  getStatus(): Observable<any>{
    return this.subject.asObservable();
  }


  constructor() { }
}
