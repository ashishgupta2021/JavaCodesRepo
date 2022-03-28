import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-other-example',
  templateUrl: './other-example.component.html',
  styleUrls: ['./other-example.component.css']
})
export class OtherExampleComponent implements OnInit {

  serverId: number = 10;
  serverStatus: string = 'offline';
  constructor() { 
    this.serverStatus = Math.random() > 0.5 ? 'online': 'offline';
  }

  ngOnInit(): void {
  }

  getServerStatus() {
    return this.serverStatus;
  }

  getColor() {
    return this.serverStatus === 'online' ? 'green' : 'red';
  }
}
