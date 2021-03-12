import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SocialUser } from 'angularx-social-login';
import { Audit } from 'src/app/Models/audit';
import { Opportunity } from 'src/app/Models/opportunity';
import { AuditService } from 'src/app/Service/audit.service';
import { OpportunityService } from 'src/app/Service/opportunity.service';

@Component({
  selector: 'app-create-opportunity',
  templateUrl: './create-opportunity.component.html',
  styleUrls: ['./create-opportunity.component.scss']
})
export class CreateOpportunityComponent implements OnInit {

  data:Opportunity;
  opportunity:Opportunity=new Opportunity();
  locations:Array<string>=["Bangalore","Chennai","Delhi","Hyderbad","Mumbai"];
  OpportunityForm : FormGroup;
  minDate : Date;
  user:SocialUser;
  auditData:Audit=new Audit();

  constructor(private _fb: FormBuilder, private opportunityService: OpportunityService, private router:Router, private auditService:AuditService) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("user"));
    this.minDate = new Date();
    this.OpportunityForm  = this._fb.group({
      oppid: '0',
      description: new FormControl('', [Validators.required]),
      location: new FormControl('', [Validators.required]),
      date: new FormControl('', [Validators.required]),
      skills: new FormControl('', [Validators.required]),
      demand: new FormControl('', [Validators.required]),
      minExperience: new FormControl('', [Validators.required]),
    });
  }

  convert(str) {
    var mnths = {
        Jan: "01",
        Feb: "02",
        Mar: "03",
        Apr: "04",
        May: "05",
        Jun: "06",
        Jul: "07",
        Aug: "08",
        Sep: "09",
        Oct: "10",
        Nov: "11",
        Dec: "12"
      },
      date = str.toDateString().split(" ");
  
    return [date[3], mnths[date[1]], date[2]].join("-");
  }

  Submit(){

    // Input Data Processing
    this.opportunity=this.OpportunityForm.value;
    console.log(this.opportunity);
    this.data=this.opportunity;
    console.log(this.data);
    this.opportunity.email = String(this.user.email);
    this.opportunity.date=new Date(this.convert(this.data.date));
    console.log(this.opportunity.date);
    this.opportunity.location=this.opportunity.location.charAt(0).toUpperCase() + this.opportunity.location.slice(1);
    const words = this.opportunity.skills.split(",");
    this.opportunity.skills=words.map((word) => {
     return word[0].toUpperCase() + word.substring(1);
          }).join(",");
// console.log(this.data);
    const words2 = this.opportunity.description.split(" ");
        this.opportunity.description=words2.map((word) => {
        return word[0].toUpperCase() + word.substring(1);
    }).join(" ");


//Auditing the data
this.auditData.newData=JSON.stringify(this.opportunity);
this.auditData.oldData=JSON.stringify({});
this.auditData.managerEmail=this.user.email;
this.auditData.operation="Create";
this.auditData.date=new Date();

// Calling services
this.auditService.addAudit(this.auditData).subscribe(resp=>{
  console.log("Data Audited from Create "+resp);
})
  this.opportunityService.addOpportunity(this.opportunity).subscribe(resp=>{
    console.log(resp);
  });
  this.router.navigate(['/home/opportunity']);
  // window.location.reload();
  }

}