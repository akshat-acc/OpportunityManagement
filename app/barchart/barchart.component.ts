import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';  
import { HttpClient } from '@angular/common/http';  
import { TrendService } from '../trend.service';

@Component({
  selector: 'app-barchart',
  templateUrl: './barchart.component.html',
  styleUrls: ['./barchart.component.scss']
})
export class BarchartComponent implements OnInit {
  location: string="";
  years:Array<string>=[]
  count:Array<number>=[]
  barchart :Chart;
  label:string
  constructor(private trendService:TrendService) {
    this.trendService.getYoYLabel().subscribe(labels=>{
      this.years= labels;
      // console.log("from back"+labels);
      console.log(this.years);
      this.trendService.getYoYCount().subscribe(counts=>{
        this.count=counts;
        this.barchart = new Chart('canvas', {  
          type: 'bar',
          data: {  
            labels: this.years,  
            datasets: [  
              { 
                label: '# of MS Hiring YearOnYear', 
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
                fill: true ,
                fillOpacity: 0.3,
                // maxBarThickness: 58,
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
                display: true ,
                ticks:{
                  beginAtZero: true
                } 
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
  loadChart(){
    this.barchart.destroy();
    console.log(this.location);
    if(this.location!=""){
        this.label='# of MS Hiring YearOnYear of '+this.location;
    }
    else{
        this.label='# of MS Hiring YearOnYear';
    }
    this.trendService.getYoYLocationLabel(this.location).subscribe(labels=>{
      this.years= labels;
      // console.log("from back"+labels);
      console.log(this.years);
      this.trendService.getYoYLocationCount(this.location).subscribe(counts=>{
        this.count=counts;
        this.barchart = new Chart('canvas', {  
          type: 'bar',
          data: {  
            labels: this.years,  
            datasets: [  
              { 
                label:this.label, 
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
                fill: true ,
                fillOpacity: 0.3,
                // maxBarThickness: 58,
              }  
            ]  
          },  
          options: {  
            legend: {  
              display: true
            },  
          //   tooltips: {
          //     enabled: false
          //  },
            scales: {  
              xAxes: [{  
                display: true  
              }],  
              yAxes: [{  
                display: true ,
                ticks:{
                  beginAtZero: true
                } 
              }],  
            }  
          }  
        });  
        console.log(this.count);   
        this.location="";
    });
  });
  }
  }
