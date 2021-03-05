import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { TrendService } from '../trend.service';

@Component({
  selector: 'app-doughnut',
  templateUrl: './doughnut.component.html',
  styleUrls: ['./doughnut.component.scss']
})
export class DoughnutComponent implements OnInit {
  skills:Array<string>=[];
  count:Array<number>=[];
  barchart = [];
  constructor(private trendService:TrendService) {
    this.trendService.getSkillLabel().subscribe(labels=>{
      this.skills= labels;
      // console.log("from back"+labels);
      console.log(this.skills);
      this.trendService.getSkillCount().subscribe(counts=>{
        this.count=counts;
        this.barchart = new Chart('canvas', {  
          type: 'doughnut',
          data: {  
            labels: this.skills,  
            datasets: [  
              {  
                data: this.count,  
                borderColor: '#3cba9f',  
                backgroundColor: [  
                  "#3cb371",  
                  "#0000FF",  
                  "#9966FF",  
                  "#f990a7",  
                  "#aad2ed",  
                  "#FF00FF",
                  "#4C4CFF",  
                  "#00FFFF",    
                  "Blue",  
                  "Red",  
                  "Green",
                  "Yellow" ,
                  "DarkBlue",
                  "#3cb371",  
                  "#0000FF",  
                  "#9966FF",  
                  "#f990a7",  
                  "#aad2ed",  
                  "#FF00FF",
                  "#4C4CFF",  
                  "#00FFFF",    
                  "Blue",  
                  "Red",  
                  "Green",
                  "Yellow" ,
                  "DarkBlue"
                ],  
                fill: true  
              }  
            ]  
          },  
          options: {  
            legend: {  
              display: true 
            },  
            scales: {  
              xAxes: [{  
                display: true  
              }],  
              yAxes: [{  
                display: true  
              }],  
            }  
          }  
        });  
        console.log(this.count);   
    });
  });
   }

  ngOnInit(): void {
  };  
}

