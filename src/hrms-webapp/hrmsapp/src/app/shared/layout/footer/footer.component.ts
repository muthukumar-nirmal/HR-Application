import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'hrms-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  today : Number = Date.now();

  constructor() { }

  ngOnInit() {
  }

}
