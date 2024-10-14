import {Component, Input} from '@angular/core';
import {PdfViewerModule} from "ng2-pdf-viewer";
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";

@Component({
  selector: 'app-pdfviewer',
  standalone: true,
  imports: [
    PdfViewerModule,
    Button,
    DialogModule
  ],
  templateUrl: './pdfviewer.component.html',
  styleUrl: './pdfviewer.component.css'
})
export class PDFViewerComponent{

  @Input({required: true}) pdfSrc: string = '';

  src = window.URL.createObjectURL(new Blob([this.pdfSrc], { type: 'application/pdf' }))

  pdfSrcEx: string = "blob:http://localhost:8080/2965c645-256b-4ef8-824b-65002e71afb4";

  isVisible: boolean = false;

  showModal() {
    this.isVisible = true
    console.log(this.src)
  }


}
