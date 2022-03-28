import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ServersComponent } from './servers/servers.component';
import { ServerComponent } from './server/server.component';
import { WarningAlertComponent } from './warning-alert/warning-alert.component';
import { SuccessAlertComponent } from './success-alert/success-alert.component';
import { FirstAssignmentComponent } from './first-assignment/first-assignment.component';
import { FormsModule } from '@angular/forms';
import { SecondAssignmentComponent } from './second-assignment/second-assignment.component';
import { BindingDemoComponent } from './binding-demo/binding-demo.component';
import { OtherExampleComponent } from './other-example/other-example.component';
import { BasicAssignmentComponent } from './basic-assignment/basic-assignment.component';
@NgModule({
  declarations: [
    AppComponent,
    ServersComponent,
    ServerComponent,
    WarningAlertComponent,
    SuccessAlertComponent,
    FirstAssignmentComponent,
    SecondAssignmentComponent,
    BindingDemoComponent,
    OtherExampleComponent,
    BasicAssignmentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
