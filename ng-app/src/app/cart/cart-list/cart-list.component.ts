import { Component, OnInit } from '@angular/core';
import {ProductDataService} from '../../service/product-data-service';
import {Product} from '../../product/product';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {

  constructor(private productDataService: ProductDataService) { }

   cartList: Product[] =[];

  ngOnInit() {
    this.cartList= this.productDataService.getProductIncart();
  }

  upQuantity(product: Product) {
    product.amount++;
  }

  downQuantity(product: Product) {
    if (product.amount > 1)
      product.amount--;
  }

  removeFromCart(product: Product){
    const index: number = this.cartList.indexOf(product);
    if (index !== -1) {
      this.cartList.splice(index, 1);
    }
  }



}
