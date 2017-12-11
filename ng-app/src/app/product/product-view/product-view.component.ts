import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {ProductDataService} from '../../service/product-data-service';
import 'rxjs/add/operator/switchMap'
import {Product} from '../product';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.css']
})
export class ProductViewComponent implements OnInit {

  constructor(private route: ActivatedRoute, private productService:ProductDataService) {}
  product:Product;
  isNoData:boolean;

  ngOnInit() {
    this.route.params
      .switchMap((params:Params) => this.productService.getProduct(+params['id']))
      .subscribe((product:Product) => {
          if (product != null)
            this.product = product;
          else
            this.isNoData = true;
        }
      );
  }

}
