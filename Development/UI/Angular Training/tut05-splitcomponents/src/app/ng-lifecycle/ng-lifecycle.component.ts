import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-ng-lifecycle',
  templateUrl: './ng-lifecycle.component.html',
  styleUrls: ['./ng-lifecycle.component.css']
})
export class NgLifecycleComponent implements OnInit, OnChanges{

  constructor() {
    console.log('constructor called!');
   }

  ngOnInit(): void {
    console.log('ngOnInit called!');
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log('ngOnChanges called!');
    console.log(changes);
  }

}
