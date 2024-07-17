import { Component } from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";

@Component({
  selector: 'app-validations-table',
  standalone: true,
  imports: [
    PrimeTemplate,
    TableModule
  ],
  templateUrl: './validations-table.component.html',
  styleUrl: './validations-table.component.css'
})
export class ValidationsTableComponent {

  validation = [
    {
      code: "1",
      candidate: "candidate1",
      topic: "topic1",
      validatedAt: "14/08/2024"
    },{
      code: "2",
      candidate: "candidate2",
      topic: "topic2",
      validatedAt: "14/08/2024"
    },{
      code: "3",
      candidate: "candidate3",
      topic: "topic2",
      validatedAt: "14/08/2024"
    },{
      code: "4",
      candidate: "candidate4",
      topic: "topic4",
      validatedAt: "14/08/2024"
    },
  ]

}
