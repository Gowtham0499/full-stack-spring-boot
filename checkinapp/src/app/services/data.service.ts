import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  url:string = "http://localhost:8080/flightreservation/reservations/";

  constructor(private _http: HttpClient) { }

  public getReservation(id: number): any {
    return this._http.get(this.url + id).pipe(map(response => {
      return response;
    },
    (error: any)=>{
      console.error(error);
    }
    ))
  }

  public checkin(checkInRequest): any {
    return this._http.post(this.url, checkInRequest).pipe(map(response => {
      return response;
    }))
  }

}
