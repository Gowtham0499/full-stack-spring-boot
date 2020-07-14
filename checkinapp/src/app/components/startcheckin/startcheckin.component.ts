import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-startcheckin',
  templateUrl: './startcheckin.component.html',
  styleUrls: ['./startcheckin.component.css']
})
export class StartcheckinComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit(): void {
  }

  public reservationId: any;

  onSelect(id: any){
    this._router.navigate(['/checkin', this.reservationId]);
  }

}
