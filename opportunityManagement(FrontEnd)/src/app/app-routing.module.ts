import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateOpportunityComponent } from './Components/home/create-opportunity/create-opportunity.component';
import { HistoryComponent } from './Components/home/history/history.component';
import { HomeComponent } from './Components/home/home.component';
import { OpportunityComponent } from './Components/home/opportunity/opportunity.component';
import { SearchComponent } from './Components/home/search/search.component';
import { LocationChartComponent } from './Components/home/trends/location-chart/location-chart.component';
import { SkillChartComponent } from './Components/home/trends/skill-chart/skill-chart.component';
import { TrendsComponent } from './Components/home/trends/trends.component';
import { YoYChartComponent } from './Components/home/trends/yoy-chart/yoy-chart.component';
import { LoginComponent } from './Components/login/login.component';
import { MenuComponent } from './Components/menu/menu.component';
import { AuthguardService } from './Service/authguard.service';

const routes: Routes = [
  { path:'',component: LoginComponent},
  { path:'login',component: LoginComponent},
  {path:'menu',component:MenuComponent,canActivate:[AuthguardService]},
  { path:'home',component:HomeComponent,canActivate:[AuthguardService],children:[

        { path:'',redirectTo:'home/opportunity',pathMatch:'full'},
        // { path: 'search', component: SearchComponent,canActivate:[AuthguardService]},
        { path: 'opportunity', component: OpportunityComponent,canActivate:[AuthguardService] },
        {path: 'createOpportunity', component: CreateOpportunityComponent, canActivate:[AuthguardService]},
        { path: 'trends', component: TrendsComponent,canActivate:[AuthguardService],children:[
              {  
                path: 'YoY', component: YoYChartComponent,canActivate:[AuthguardService]
              },  
              {  
                path: 'Location', component: LocationChartComponent,canActivate:[AuthguardService]
              },  
              {  
                path: 'Skills', component: SkillChartComponent,canActivate:[AuthguardService]
              },  
        ]},
        { path: 'audit', component: HistoryComponent,canActivate:[AuthguardService]}
    
      ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
