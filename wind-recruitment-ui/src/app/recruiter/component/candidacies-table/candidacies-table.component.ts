import { Component } from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";

@Component({
  selector: 'app-candidacies-table',
  standalone: true,
    imports: [
        PrimeTemplate,
        TableModule
    ],
  templateUrl: './candidacies-table.component.html',
  styleUrl: './candidacies-table.component.css'
})
export class CandidaciesTableComponent {

  candidacies = [
    {
      code: "1",
      candidate: "candidate1",
      topic: "topic1",
      state: "Pending",
      createdAt: "14/07/2024"
    },
    {
      code: "2",
      candidate: "candidate2",
      topic: "topic2",
      state: "Validated",
      createdAt: "14/07/2024"
    },
    {
      code: "3",
      candidate: "candidate3",
      topic: "topic3",
      state: "Pending",
      createdAt: "14/07/2024"
    },
    {
      code: "4",
      candidate: "candidate4",
      topic: "topic4",
      state: "Accepted",
      createdAt: "15/03/2024"
    },
  ]

}
