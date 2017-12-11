import { Component, OnInit } from '@angular/core';
import {Product} from "../../product/product";
import {ProductDataService} from "../../service/product-data-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.css']
})
export class MainMenuComponent implements OnInit {

  products: Product[];

  constructor(private productDataService: ProductDataService,private router: Router) { }

  ngOnInit() {
  }

  // search: string;
  // onSearch(){
  //   this.productDataService.findProduct(this.search)
  //     .subscribe(
  //       products => this.products = products,
  //       (error) => {
  //         if (error.status === 401){
  //           // this.router.navigate(['login'],{queryParams:{source:'student'}});
  //         }
  //       })
  // }

}
