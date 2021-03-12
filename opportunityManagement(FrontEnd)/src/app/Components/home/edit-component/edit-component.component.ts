import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SocialUser } from 'angularx-social-login';
import { Audit } from 'src/app/Models/audit';
import { Opportunity } from 'src/app/Models/opportunity';
import { AuditService } from 'src/app/Service/audit.service';
import { OpportunityService } from 'src/app/Service/opportunity.service';
import { SharedServiceService } from 'src/app/Service/shared-service.service';

@Component({
  selector: 'app-edit-component',
  templateUrl: './edit-component.component.html',
  styleUrls: ['./edit-component.component.scss']
})
export class EditComponentComponent implements OnInit {
  minDate:Date;
  dbOpportunity:Opportunity=new Opportunity();
  opportunity:Opportunity;
  id:number;
  OpportunityForm : FormGroup;
  auditData:Audit=new Audit();
  loggedInUser:SocialUser;

  constructor(private auditService:AuditService,private sharedService: SharedServiceService, private opportunityService:OpportunityService, private _fb: FormBuilder, @Inject(MAT_DIALOG_DATA) public data: Opportunity) {
    // console.log(data.location);
    this.dbOpportunity=data;
    console.log(this.dbOpportunity);
    this.auditData.oldData=JSON.stringify(this.dbOpportunity);
   }

  ngOnInit(): void {
    this.loggedInUser = JSON.parse(localStorage.getItem("user"));
    this.minDate=new Date();
    this.auditData.managerEmail=this.loggedInUser.email;
    // this.OpportunityForm=this._fb.group(this.opportunity);
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

  onEdit() {
        this.opportunity = this.sharedService.getEditOpportunity();
        this.id=this.sharedService.getOpportunityId();
        console.log(this.opportunity,this.id);
        this.opportunity.location = this.dbOpportunity.location;
        this.opportunity.description = this.dbOpportunity.description;
        this.opportunity.skills=this.dbOpportunity.skills;
        this.opportunity.date=this.dbOpportunity.date;
        this.opportunity.demand=this.dbOpportunity.demand;
        this.opportunity.date=this.dbOpportunity.date;
        this.opportunity.minExperience=this.dbOpportunity.minExperience;
        // console.log(typeof(this.opportunity.date));
        // console.log(this.opportunity,this.id);
        // this.opportunity.date=new Date(this.convert((this.opportunity.date)));
        console.log(this.opportunity.date);
        this.opportunity.location=this.opportunity.location.charAt(0).toUpperCase() + this.opportunity.location.slice(1);

        console.log(this.opportunity.location);

        const words = this.opportunity.skills.split(",");
        this.opportunity.skills=words.map((word) => {
        return word[0].toUpperCase() + word.substring(1);
    }).join(",");
    const words2 = this.opportunity.description.split(" ");
        this.opportunity.description=words2.map((word) => {
        return word[0].toUpperCase() + word.substring(1);
    }).join(" ");
    console.log(this.opportunity,this.id);

        this.auditData.operation="Update ("+String(this.id)+")";
        this.auditData.date=new Date();
        this.auditData.newData=JSON.stringify(this.opportunity);
        this.auditService.addAudit(this.auditData).subscribe(resp=>{
          console.log("Data Audited from Update "+resp);
        })

    this.opportunityService.EditDetails(this.opportunity,this.id).subscribe(resp => {
      console.log(resp);
    })

    console.log(this.opportunity);
    window.location.reload();

  }
}
