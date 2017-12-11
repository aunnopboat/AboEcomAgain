import {RouterModule, Routes} from "@angular/router";
import {ProductListComponent} from "./product/product-list/product-list.component";
import {CartListComponent} from "./cart/cart-list/cart-list.component";
import {ProductAddComponent} from "./product/product-add/product-add.component";
import {ProductDeleteComponent} from "./product/product-delete/product-delete.component";
import {ProductEditComponent} from "./product/product-edit/product-edit.component";

import {FileNotFoundComponent} from "./file-not-found/file-not-found/file-not-found.component";
import {UserAddComponent} from "./user/user-add/user-add.component";
import {UserDeleteComponent} from "./user/user-delete/user-delete.component";
import {TransactionComponent} from "./transection/transection/transaction.component";
import {NgModule} from "@angular/core";
import {ProductViewComponent} from './product/product-view/product-view.component';
import {LoginComponent} from './login/login.component';

const appRoute: Routes =[
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'detail/:id',
    component: ProductViewComponent
  },

  {
    path: 'product',
    component: ProductListComponent
  },
  {
    path: 'cart',
    component: CartListComponent
  },
  {
    path: 'add_product',
    component: ProductAddComponent
  },
  {
    path: 'delete_product',
    component: ProductDeleteComponent
  },
  {
    path: 'edit_product',
    component: ProductEditComponent
  },
  {
    path: 'add_user',
    component: UserAddComponent
  },
  {
    path: 'delete_user',
    component: UserDeleteComponent
  },
  {
    path: 'view_transaction',
    component: TransactionComponent
  },
  {
    path: '',
    redirectTo: '/product',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: FileNotFoundComponent
  },

];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoute)
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule {
}
