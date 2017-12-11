package compofinalproject.demo.service;

import compofinalproject.demo.entity.Customer;
import compofinalproject.demo.entity.Shopkeeper;

import java.util.List;

public interface ShopkeeperService {
    List<Shopkeeper> getShopkeepers();
    Shopkeeper addShopkeeper(Shopkeeper shopkeeper);
}
