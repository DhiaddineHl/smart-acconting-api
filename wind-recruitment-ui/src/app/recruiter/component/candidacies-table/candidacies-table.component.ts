import {Component, inject, OnInit} from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";
import {CandidaciesResponsePage, CandidaciesServiceService} from "../../services/candidacy/candidacies-service.service";
import {Button} from "primeng/button";
import {FileServiceService} from "../../services/files/file-service.service";
import {BadgeModule} from "primeng/badge";


@Component({
  selector: 'app-candidacies-table',
  standalone: true,
  imports: [
    PrimeTemplate,
    TableModule,
    Button,
    BadgeModule
  ],
  templateUrl: './candidacies-table.component.html',
  styleUrl: './candidacies-table.component.css'
})
export class CandidaciesTableComponent implements OnInit{

  candidaciesService = inject(CandidaciesServiceService);
  fileService = inject(FileServiceService)

  candidaciesResponse : CandidaciesResponsePage = {};
  pageSize: number = 5;
  pageNumber: number = 0;

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

  getAllCandidacies = () => {
    this.candidaciesService.getAllCandidacies(this.pageSize, this.pageNumber)
      .subscribe({
        next: (response) => {
          this.candidaciesResponse = response;
          console.log(this.candidaciesResponse)
        }, error:(err) => {
          console.log("error fetching candidacies", err)
        }
      })
  }

  validateCandidacy = (candidacy_id: number) => {
    this.candidaciesService.validateCandidacy(candidacy_id)
      .subscribe({
        next : () => {
          this.ngOnInit();
          console.log("candidacy validated");
        },error : (err) => {
          console.log("error validating the candidacy", err)
        }
      })
  }


  getBudgeSeverity = (status: string) :"success" | "info" | "warning" | "danger" | "help" | "primary" | "secondary" | "contrast" | undefined  => {
    switch (status){
      case "pending": return "warning";
      case "tech_validated": return "primary";
      case "hr_validated": return "info";
      case "accepted": return "success";
      default: return undefined;
    }
  }

  ngOnInit(): void {
    this.getAllCandidacies()
  }

  openCandidateCv(file : Uint8Array){
    this.fileService.openFile(file)
  }

}
