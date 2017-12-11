import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {ProductDataService} from '../../service/product-data-service';
import {Product} from '../product';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  product: any = {};

  constructor(private productDataService: ProductDataService, private router: Router) {
  };

  ngOnInit() {
    this.product = new Product();
  }


  @ViewChild('fileInput') inputEl: ElementRef;
  addProduct(product: Product) {
    let result: Product;
    console.log(product)
    let inputEl: HTMLInputElement = this.inputEl.nativeElement;
    this.productDataService.addProduct(product, inputEl.files.item(0))
      .subscribe(resultProduct => {
        result = resultProduct
        if (result != null) {
          this.router.navigate(['/product']);
        } else {
          alert('Error in adding the Product');
        }
      });
  }


  onFileChange(event, product: any) {
    var filename = event.target.files[0].name;
    console.log(filename);
    this.product.image = filename;
  }

}
