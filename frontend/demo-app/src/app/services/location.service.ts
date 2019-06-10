import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import  { Observable,Observer } from 'rxjs';
interface Location{
  latitude:number;
  longitude:number;
  ip:any;
}

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http:HttpClient) { }
  getLocation(){
    return this.http.get<Location>("https://ipapi.co/json/");
  }

  getLocationUpdate():Observable<Position>{
    return Observable.create((observer: Observer<Position>) => {
      // Invokes getCurrentPosition method of Geolocation API.
      navigator.geolocation.watchPosition(
          (position: Position) => {
              observer.next(position);
              observer.complete();
          },
          (error: PositionError) => {
              console.log('Geolocation service: ' + error.message);
              observer.error(error);
          }
      );
  });
  
  }
}
