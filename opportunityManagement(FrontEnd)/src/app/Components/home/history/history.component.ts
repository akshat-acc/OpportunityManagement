import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Audit } from 'src/app/Models/audit';
import { AuditService } from 'src/app/Service/audit.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss']
})
export class HistoryComponent implements OnInit {

  dataSource = new MatTableDataSource < Audit > ();

  @ViewChild(MatPaginator, {
    // static: true
  }) paginator: MatPaginator;

  @ViewChild(MatSort, {
    // static: true
  }) sort: MatSort;
  
  constructor(private auditService:AuditService) { }

  ngOnInit(): void {
    this.auditService.getAllAudit().subscribe(audits=>{
      this.dataSource.data =audits;
      console.log(this.dataSource.data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
    })
  }
  displayedColumns: string[] = ['No.', 'ManagerName', 'date', 'operation' , 'oldData','newData'];
  //
}
