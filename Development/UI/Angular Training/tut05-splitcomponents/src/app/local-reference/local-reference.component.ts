import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-local-reference',
  templateUrl: './local-reference.component.html',
  styleUrls: ['./local-reference.component.css']
})
export class LocalReferenceComponent implements OnInit {

  name: string;
  constructor() { }

  ngOnInit(): void {
  }

  showName(name: HTMLInputElement) {
    alert('Your name is ' + name.value);
  }

}
