import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css']
})
export class CheckinComponent implements OnInit {

  data:any;
  checkInResponse:any;

  public noOfBags:any;

  constructor(private route:ActivatedRoute, private service:DataService, private router: Router) { }

  ngOnInit(): void {
    let id = Number.parseInt(this.route.snapshot.paramMap.get("id"));
    this.service.getReservation(id).subscribe((res: any)=>{
      this.data = res;
    }) 
  }

  checkin(noOfBags: any){
    var checkInRequest:any = new Object();
    checkInRequest.id = this.data.id;
    checkInRequest.checkedIn = true;
    checkInRequest.numberOfBags = noOfBags;

    this.service.checkin(checkInRequest).subscribe((res: any)=>{
      this.checkInResponse = res;
    }) 
    this.router.navigate(['/confirm'])
  }

}
