import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AccountService} from "../_services/account.service";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit, OnDestroy {

  account: any;
  private sub: any;

  constructor(private _route: ActivatedRoute, private accountService: AccountService) {
  }

  ngOnInit() {
    this.sub = this._route.params.subscribe(params => {
      this.accountService.getAccount(+params['id']).subscribe(
        data => {
          this.account = data;
        },
        err => {
          this.account = JSON.parse(err.error).message;
        }
      );
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
