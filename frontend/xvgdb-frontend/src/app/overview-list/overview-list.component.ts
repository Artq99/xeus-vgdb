import { Component, OnInit } from '@angular/core';
import { OverviewListService } from '../overview-list.service';

@Component({
  selector: 'app-overview-list',
  templateUrl: './overview-list.component.html',
  styleUrls: ['./overview-list.component.css']
})
export class OverviewListComponent implements OnInit {

  constructor(private overviewListService: OverviewListService) { }

  ngOnInit() {
    this.overviewListService.getOverviewList().subscribe(list => {
      console.log(list);
    })
  }

}
