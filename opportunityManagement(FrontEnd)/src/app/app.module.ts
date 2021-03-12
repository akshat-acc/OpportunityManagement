import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component'
import { MenuComponent } from './Components/menu/menu.component';

import { SocialAuthServiceConfig} from 'angularx-social-login';
import { SocialLoginModule, GoogleLoginProvider} from 'angularx-social-login';
import { HttpClientModule} from '@angular/common/http';

import { MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatDatepickerModule } from '@angular/material/datepicker';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule} from '@angular/material/sort';
import { MatCardModule} from '@angular/material/card';
import {MatDialogModule} from '@angular/material/dialog';
import {MatNativeDateModule} from '@angular/material/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';


import { HomeComponent } from './Components/home/home.component';
import { SearchComponent } from './Components/home/search/search.component';
import { TrendsComponent } from './Components/home/trends/trends.component';
import { LocationChartComponent } from './Components/home/trends/location-chart/location-chart.component';
import { SkillChartComponent } from './Components/home/trends/skill-chart/skill-chart.component';
import { YoYChartComponent } from './Components/home/trends/yoy-chart/yoy-chart.component';
import { OpportunityComponent } from './Components/home/opportunity/opportunity.component';
import { CreateOpportunityComponent } from './Components/home/create-opportunity/create-opportunity.component';
import { ConfirmationDialogComponent } from './Components/home/confirmation-dialog/confirmation-dialog.component';
import { EditComponentComponent } from './Components/home/edit-component/edit-component.component';
import { HistoryComponent } from './Components/home/history/history.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    HomeComponent,
    SearchComponent,
    TrendsComponent,
    LocationChartComponent,
    SkillChartComponent,
    YoYChartComponent,
    OpportunityComponent,
    CreateOpportunityComponent,
    ConfirmationDialogComponent,
    EditComponentComponent,
    HistoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SocialLoginModule,
    HttpClientModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatSelectModule,
    MatButtonModule,
    FormsModule, ReactiveFormsModule,
    MatTableModule,MatPaginatorModule,MatSortModule,MatDatepickerModule,MatInputModule,
    MatFormFieldModule,MatDialogModule,
    MatCardModule,MatNativeDateModule
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '679122196935-26inhqrfc6hb1vq4qpf0l43kt96p72h8.apps.googleusercontent.com'
            )
          }
        ]
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
