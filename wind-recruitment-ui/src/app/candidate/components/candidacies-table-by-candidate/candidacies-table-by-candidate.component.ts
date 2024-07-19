import { Component } from '@angular/core';
import {TableModule} from "primeng/table";

@Component({
  selector: 'app-candidacies-table-by-candidate',
  standalone: true,
  imports: [
    TableModule
  ],
  templateUrl: './candidacies-table-by-candidate.component.html',
  styleUrl: './candidacies-table-by-candidate.component.css'
})
export class CandidaciesTableByCandidateComponent {

  candidacies = [
    {
      code: "1",
      topic: "topic1",
      state: "Pending",
      createdAt: "14/07/2024"
    },
    {
      code: "2",
      topic: "topic2",
      state: "Validated",
      createdAt: "14/07/2024"
    },
    {
      code: "3",
      topic: "topic3",
      state: "Pending",
      createdAt: "14/07/2024"
    },
    {
      code: "4",
      topic: "topic4",
      state: "Accepted",
      createdAt: "15/03/2024"
    },
  ]

}
