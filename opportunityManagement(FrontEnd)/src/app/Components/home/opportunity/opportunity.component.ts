import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog,MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { SocialUser } from 'angularx-social-login';
import { Audit } from 'src/app/Models/audit';
import { Opportunity } from 'src/app/Models/opportunity';
import { AuditService } from 'src/app/Service/audit.service';
import { OpportunityService } from 'src/app/Service/opportunity.service';
import { SharedServiceService } from 'src/app/Service/shared-service.service';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { EditComponentComponent } from '../edit-component/edit-component.component';

@Component({
  selector: 'app-opportunity',
  templateUrl: './opportunity.component.html',
  styleUrls: ['./opportunity.component.scss']
})
export class OpportunityComponent implements OnInit {

  opportunity:Opportunity=new Opportunity();
    data:Opportunity=new Opportunity();
    dataSource = new MatTableDataSource < Opportunity > ();
    loggedInUser:SocialUser;
    auditData:Audit=new Audit();

    @ViewChild(MatPaginator, {
      // static: true
    }) paginator: MatPaginator;
  
    @ViewChild(MatSort, {
      // static: true
    }) sort: MatSort;

  constructor(private opportunityService:OpportunityService, public dialog: MatDialog, private sharedService:SharedServiceService,private auditService:AuditService) { }

  ngOnInit(): void {
    this.loggedInUser = JSON.parse(localStorage.getItem("user"));
    this.opportunityService.getAllOppertunity().subscribe((opportunities=>{
      this.dataSource.data =opportunities;
      console.log(this.dataSource.data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
    }));
  }

  displayedColumns: string[] = ['No.', 'ManagerName', 'ManagerEmail', 'description', 'location', 'date', 'skills', 'demand','minExperience','edit','delete'];

  openDialog(opportunity,id:Number): void {
    console.log(opportunity,id);
    const dialogRef = this.dialog.open(EditComponentComponent, {
      width: '300px',
      data: {description: opportunity.description, location: opportunity.location,date:opportunity.date,skills:opportunity.skills,demand:opportunity.demand,minExperience:opportunity.minExperience},
    });
  
    this.sharedService.setEditOpportunity(opportunity);
    this.sharedService.setOpportunityId(id);
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // this.title = result;
    });
    this.opportunityService.getAllOppertunity().subscribe((opportunities=>{
      this.dataSource.data =opportunities;
      console.log(this.dataSource.data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
    }));
  }

  onDelete(opportunity,Opportunity_id: Number) {

    //Auditing the data
    this.auditData.newData=JSON.stringify({});
    this.auditData.oldData=JSON.stringify(opportunity);
    this.auditData.managerEmail=this.loggedInUser.email;
    this.auditData.operation="Delete ("+String(Opportunity_id)+")";
    this.auditData.date=new Date();

    //Calling Service
    this.auditService.addAudit(this.auditData).subscribe(resp=>{
      console.log("Data Audited from Delete "+resp);
    })
    this.opportunityService.deleteOpportunity(Opportunity_id).subscribe(resp => {
    
      console.log(resp);   
      // this.dataSource.data = this.dataSource.data.filter(v => {return v.oppId!=Opportunity_id});
      this.opportunityService.getAllOppertunity().subscribe((opportunities=>{
        this.dataSource.data =opportunities;
        console.log(this.dataSource.data);
            this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;
      }));
      
    // window.location.reload();
   });
  
  }

  openConfirmationDialog(opportunity,Opportunity_id: Number): void {
    // console.log(opportunity,Opportunity_id);
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      if(result){
        this.onDelete(opportunity,Opportunity_id);
      }
    });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
}
