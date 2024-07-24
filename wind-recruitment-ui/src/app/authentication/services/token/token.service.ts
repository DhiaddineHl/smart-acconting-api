import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  setToken(key: string, token: string){
    localStorage.setItem(key, token)
  }

  getToken(key: string): string{
    return localStorage.getItem(key) as string;
  }

}
