import {HttpHeaders, HttpInterceptorFn} from '@angular/common/http';
import {inject} from "@angular/core";
import {TokenService} from "../token/token.service";

export const httpTokenInterceptorInterceptor: HttpInterceptorFn = (req, next) => {

  const tokenService = inject(TokenService);
  const access_token = tokenService.getToken('access_token');

  if (access_token){
    const authRequest = req.clone({
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + access_token
      })
    });
    return next(authRequest);
  }

  return next(req);
};
