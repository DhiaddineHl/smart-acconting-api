import {Component, inject, OnInit} from '@angular/core';
import {TableModule} from "primeng/table";
import {ProgressBarModule} from "primeng/progressbar";
import {
  CandidaciesResponsePage,
  CandidaciesServiceService
} from "../../../recruiter/services/candidacy/candidacies-service.service";
import {BadgeModule} from "primeng/badge";


interface Candidacy {
  code? : string
  topic?: string
  state?: string
  createdAt?: string
  progress?: number
}

@Component({
  selector: 'app-candidacies-table-by-candidate',
  standalone: true,
  imports: [
    TableModule,
    ProgressBarModule,
    BadgeModule
  ],
  templateUrl: './candidacies-table-by-candidate.component.html',
  styleUrl: './candidacies-table-by-candidate.component.css'
})
export class CandidaciesTableByCandidateComponent implements OnInit{

  candidaciesService = inject(CandidaciesServiceService);
  candidaciesByCandidate : CandidaciesResponsePage = {};

  page_size : number = 5;
  page_number : number = 0;

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

  getMyCandidacies = () => {
    this.candidaciesService.getMyCandidacies(this.page_size, this.page_number)
      .subscribe({
        next: (response) => {
          this.candidaciesByCandidate = response;
          console.log(this.candidaciesByCandidate)
        }, error: (err) => {
          console.log("error fetching candidacies", err)
        }
      })
  }

  ngOnInit(): void {
    this.getMyCandidacies()
  }

}
