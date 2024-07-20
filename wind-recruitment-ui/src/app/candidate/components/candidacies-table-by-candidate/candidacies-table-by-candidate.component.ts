import { Component } from '@angular/core';
import {TableModule} from "primeng/table";
import {ProgressBarModule} from "primeng/progressbar";

interface Candidacy {
  code : string
  topic: string
  state: string
  createdAt: string
  progress: number
}

@Component({
  selector: 'app-candidacies-table-by-candidate',
  standalone: true,
  imports: [
    TableModule,
    ProgressBarModule
  ],
  templateUrl: './candidacies-table-by-candidate.component.html',
  styleUrl: './candidacies-table-by-candidate.component.css'
})
export class CandidaciesTableByCandidateComponent {

  candidacies : Candidacy[] = [
    {
      code: "1",
      topic: "topic1",
      state: "Pending",
      createdAt: "14/07/2024",
      progress: 50
    },
    {
      code: "2",
      topic: "topic2",
      state: "Validated",
      createdAt: "14/07/2024",
      progress: 80
    },
    {
      code: "3",
      topic: "topic3",
      state: "Pending",
      createdAt: "14/07/2024",
      progress: 20
    },
    {
      code: "4",
      topic: "topic4",
      state: "Accepted",
      createdAt: "15/03/2024",
      progress: 60
    },
  ]

}
