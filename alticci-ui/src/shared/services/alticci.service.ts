import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from "@angular/common/http";
import {AlticciResult} from "../model/alticci-result";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AlticciService {

  private ALTICE_URL = environment.apiUrl + "/alticci/";

  constructor(private http: HttpClient) {}

  computeSequence(number: number): Observable<AlticciResult> {
    return this.http.get<AlticciResult>(this.ALTICE_URL + number);
  }
}
