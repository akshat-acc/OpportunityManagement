import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';  
import { HttpClient } from '@angular/common/http';  

@Component({
  selector: 'app-barchart',
  templateUrl: './barchart.component.html',
  styleUrls: ['./barchart.component.scss']
})
export class BarchartComponent implements OnInit {
  location:Array<string>=["Hyderabad","Chennai","Mumbai","Bangalore","Delhi"]
  count:Array<number>=[5,4,6,2,9]
  barchart = [];
  constructor() { }

  ngOnInit(): void {
    this.barchart = new Chart('canvas', {  
      type: 'bar', //'pie','bar' 
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
              // "#4C4CFF",  
              // "#00FFFF",  
              "#f990a7",  
              // "#aad2ed",  
              // "#FF00FF",  
              // "Blue",  
              // "Red",  
              // "Green",
              // "Yellow" 
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
  };  
  }
