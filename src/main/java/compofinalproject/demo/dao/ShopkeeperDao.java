package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Shopkeeper;
import java.util.List;

public interface ShopkeeperDao {
    List<Shopkeeper> getShopkeepers();
    Shopkeeper addShopkeeper(Shopkeeper shopkeeper);
    Shopkeeper deleteShopkeeper(Shopkeeper shopkeeper);
}
