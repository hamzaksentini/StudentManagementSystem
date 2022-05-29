import {Component, OnInit} from '@angular/core';
import {AccountService} from "../_services/account.service";

@Component({
  selector: 'app-board-client',
  templateUrl: './board-client.component.html',
  styleUrls: ['./board-client.component.css']
})
export class BoardClientComponent implements OnInit {

  accounts?: Array<any>;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
    this.accountService.getAccounts().subscribe(
      data => {
        this.accounts = data;
      },
      err => {
        this.accounts = JSON.parse(err.error).message;
      }
    );
  }
}
