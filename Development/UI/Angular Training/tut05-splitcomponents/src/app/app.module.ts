import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CockpitComponent } from './cockpit/cockpit.component';
import { ServerElementComponent } from './server-element/server-element.component';
import { FormsModule } from '@angular/forms';
import { LocalReferenceComponent } from './local-reference/local-reference.component';
import { ViewChildComponent } from './view-child/view-child.component';
import { NgLifecycleComponent } from './ng-lifecycle/ng-lifecycle.component';
@NgModule({
  declarations: [
    AppComponent,
    CockpitComponent,
    ServerElementComponent,
    LocalReferenceComponent,
    ViewChildComponent,
    NgLifecycleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
