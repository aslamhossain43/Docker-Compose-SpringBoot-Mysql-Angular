import { Component, OnInit } from '@angular/core';
import { IEmployee } from './app.model';
import { ServiceService } from './service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  employees?: IEmployee[];
  constructor(protected service: ServiceService) {

  }
  title = 'app';
  ngOnInit(): void {
    this.getAllEmployee();
  }
  getAllEmployee(): void {
    this.service.getAll()
      .subscribe(employee => {
        this.employees = employee.body || [];
      })
  }
  add(): void {
    this.service.add()
      .subscribe(() => {
        this.getAllEmployee();
      })
  }
  
  delete(id?: any): void {
    this.service.delete(id).subscribe(() => { 
      this.getAllEmployee();
    });
  }

}
