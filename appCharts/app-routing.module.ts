import { NgModule } from '@angular/core';  
import { Routes, RouterModule } from '@angular/router';  
import { BarchartComponent } from "./barchart/barchart.component";  
import { PiechartComponent } from "./piechart/piechart.component";  
import { DoughnutComponent } from "./doughnut/doughnut.component";  
import { PolarareaComponent } from './polararea/polararea.component';
const routes: Routes = [   
  {  
    path: 'BarChart', component: BarchartComponent  
  },  
  {  
    path: 'Location', component: PiechartComponent  
  },  
  {  
    path: 'Skills', component: DoughnutComponent  
  },  
   { 
     path:'Polarchart',component:PolarareaComponent 
  }

];  

@NgModule({  
  imports: [RouterModule.forRoot(routes)],  
  exports: [RouterModule]  
})  
export class AppRoutingModule { } 
