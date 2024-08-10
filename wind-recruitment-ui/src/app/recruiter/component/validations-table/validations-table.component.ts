import {Component, inject, OnInit} from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";
import {ValidationResponse, ValidationServiceService} from "../../services/validation/validation-service.service";

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
export class ValidationsTableComponent implements OnInit{

  validationsService = inject(ValidationServiceService)
  validations : Array<ValidationResponse> | undefined = [];

  size : number = 10;
  number : number = 0;

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

  getValidation(){
    this.validationsService.getValidationsByRecruiter(this.size, this.number)
      .subscribe({
        next:(response) => {
          this.validations = response.content
          console.log("response", response)
        }, error:(err) => {
          console.log("error fetching validations", err)
        }
      })
  }

  ngOnInit(): void {
    this.getValidation()
  }

}
