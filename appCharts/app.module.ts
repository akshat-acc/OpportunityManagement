import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarchartComponent } from './barchart/barchart.component';
import { DoughnutComponent } from './doughnut/doughnut.component';
import { PiechartComponent } from './piechart/piechart.component';
import { PolarareaComponent } from './polararea/polararea.component';

@NgModule({
  declarations: [
    AppComponent,
    BarchartComponent,
    DoughnutComponent,
    PiechartComponent,
    PolarareaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
