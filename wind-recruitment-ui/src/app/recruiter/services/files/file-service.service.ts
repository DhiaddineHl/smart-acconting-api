import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FileServiceService {

  constructor() { }

  byteArrayToBlob(byteArray: Uint8Array): Blob {
    return new Blob([byteArray], { type: 'application/pdf' });
  }

  openFile(byteArray: Uint8Array): void {
    const blob = this.byteArrayToBlob(byteArray);
    const url = URL.createObjectURL(blob)
    window.open(url, '_blank');
  }

}
