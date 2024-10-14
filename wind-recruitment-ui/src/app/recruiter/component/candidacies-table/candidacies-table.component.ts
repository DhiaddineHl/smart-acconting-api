import {Component, inject, OnInit} from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";
import {CandidaciesResponsePage, CandidaciesServiceService} from "../../services/candidacy/candidacies-service.service";
import {Button} from "primeng/button";
import {FileServiceService} from "../../services/files/file-service.service";
import {BadgeModule} from "primeng/badge";
import {PDFViewerComponent} from "../pdfviewer/pdfviewer.component";


@Component({
  selector: 'app-candidacies-table',
  standalone: true,
  imports: [
    PrimeTemplate,
    TableModule,
    Button,
    BadgeModule,
    PDFViewerComponent
  ],
  templateUrl: './candidacies-table.component.html',
  styleUrl: './candidacies-table.component.css'
})
export class CandidaciesTableComponent implements OnInit{

  candidaciesService = inject(CandidaciesServiceService);
  fileService = inject(FileServiceService)

  candidaciesResponse : CandidaciesResponsePage = {};
  pageSize: number = 10;
  pageNumber: number = 0;

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

  downloadCandidacyFile = (fileName: string) => {
    this.candidaciesService.downloadFile(fileName)
      .subscribe({
        next: (response) => {
          const url = window.URL.createObjectURL(response);
          const a = document.createElement('a');
          a.href = url;
          a.download = fileName;
          document.body.appendChild(a);
          a.click();
          window.URL.revokeObjectURL(url);
          a.remove();
        }, error: (err) => {
          console.log("File download error: ", err)
        }
      })
  }

  viewCandidacyFile = (fileName: string) => {
    this.candidaciesService.downloadFile(fileName)
      .subscribe({
        next: (response) => {
          const fileURL = window.URL.createObjectURL(response);
          window.open(fileURL, '_blank');
          window.URL.revokeObjectURL(fileURL);
        }, error: (err) => {
          console.log("File opening error: ", err)
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

}
