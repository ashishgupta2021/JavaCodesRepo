import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-basic-assignment',
  templateUrl: './basic-assignment.component.html',
  styleUrls: ['./basic-assignment.component.css']
})
export class BasicAssignmentComponent implements OnInit {

  showSecret = false;
  log = [];
  constructor() { }

  ngOnInit(): void {
  }

  onToggleDetails() {
    this.showSecret = !this.showSecret;
    this.log.push(this.log.length + 1);
  }

}
