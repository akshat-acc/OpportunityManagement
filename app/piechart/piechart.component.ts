import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';  
import { callbackify } from 'util';
import { TrendService } from '../trend.service';

@Component({
  selector: 'app-piechart',
  templateUrl: './piechart.component.html',
  styleUrls: ['./piechart.component.scss']
})
export class PiechartComponent implements OnInit {
  location:Array<string>=[];
  count:Array<number>=[];
  piechart = [];
  doughnutchart=[];
  constructor(private trendService:TrendService) { 
   this.trendService.getLocationLabel().subscribe(labels=>{
      this.location= labels;
      // console.log("from back"+labels);
      console.log(this.location);
      this.trendService.getLocationCount().subscribe(counts=>{
        this.count=counts;
        this.piechart = new Chart('canvas', {  
          type: 'pie',
          data: {  
            labels: this.location,  
            datasets: [  
              {  
                data: this.count,  
                borderColor: '#3cba9f',  
                backgroundColor: [  
                  "#3cb371",  
                  "#0000FF",  
                  "#9966FF",  
                  "#4C4CFF",  
                  "#00FFFF",  
                  // "#f990a7",  
                  // "#aad2ed",  
                  // "#FF00FF",  
                  // "Blue",  
                  // "Red",  
                  // "Green",
                  // "Yellow" 
                  // "DarkBlue" 
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
        // this.doughnutchart = new Chart('canvas', {  
        //   type: 'doughnut',
        //   data: {  
        //     labels: this.location,  
        //     datasets: [  
        //       {  
        //         data: this.count,  
        //         borderColor: '#3cba9f',  
        //         backgroundColor: [  
        //           "#3cb371",  
        //           "#0000FF",  
        //           "#9966FF",  
        //           "#4C4CFF",  
        //           "#00FFFF",  
        //           // "#f990a7",  
        //           // "#aad2ed",  
        //           // "#FF00FF",  
        //           // "Blue",  
        //           // "Red",  
        //           // "Green",
        //           // "Yellow" 
        //           // "DarkBlue" 
        //         ],  
        //         fill: true  
        //       }  
        //     ]  
        //   },  
        //   options: {  
        //     legend: {  
        //       display: true 
        //     },  
        //     scales: {  
        //       xAxes: [{  
        //         display: true  
        //       }],  
        //       yAxes: [{  
        //         display: true  
        //       }],  
        //     }  
        //   }  
        // }); 
        console.log(this.count);   
    });
  });

  }
  ngOnInit(): void {  
  };
}

