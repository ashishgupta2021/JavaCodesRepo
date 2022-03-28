import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-view-child',
  templateUrl: './view-child.component.html',
  styleUrls: ['./view-child.component.css']
})
export class ViewChildComponent implements OnInit {

  @ViewChild('otherName') otherName: ElementRef;
  constructor() { }

  ngOnInit(): void {
  }

  showOtherName() {
    console.log(this.otherName.nativeElement.value);
  }

}
