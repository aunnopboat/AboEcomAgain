import {Component, OnInit} from '@angular/core';
import {ProductDataService} from "../../service/product-data-service";
import {Product} from "../product";
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private productDataService: ProductDataService, private router: Router) {
  }

  products: Product[];


  ngOnInit() {
    this.productDataService.getProductData()
      .subscribe(products => this.products = products);


  }

  showDetail(product: Product) {
    this.router.navigate(['/detail', product.productId]);

  }



  addToCart(product: Product) {
      this.productDataService.getProductIncart().push(product);
    //}
  }

  search: string;

  onSearch() {
    this.productDataService.findProduct(this.search).subscribe(products => this.products = products, (error) => {
      if (error.status === 401) {
        this.router.navigate(['prosuct'], {queryParams: {source: 'product'}})
      }
    })
  }


}
