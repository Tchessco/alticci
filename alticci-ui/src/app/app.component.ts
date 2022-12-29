import {Component} from '@angular/core';
import {AlticciService} from "../shared/services/alticci.service";
import {HttpClient} from "@angular/common/http";
import {AlticciResult} from "../shared/model/alticci-result";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'alticci-ui';

  value = '0';
  reltValue = '0';

  laoding = false;

  constructor(private httpClient: HttpClient, private alticeService: AlticciService) {
  }

  submitCalculation() {
    this.laoding = true;
    this.alticeService.computeSequence(Number(this.value))
      .subscribe({
        next: (res: AlticciResult) => {
          this.reltValue = String(res.value);
          this.laoding = false;
        }
      });
  }
}
