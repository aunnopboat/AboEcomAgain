package compofinalproject.demo.dao;

import com.google.common.collect.Lists;
import compofinalproject.demo.entity.Shopkeeper;
import compofinalproject.demo.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ShopkeeperDaoImpl implements ShopkeeperDao {

    ShopkeeperRepository shopkeeperRepository;

    @Autowired
    public void setShopkeeperRepository(ShopkeeperRepository shopkeeperRepository){
        this.shopkeeperRepository=shopkeeperRepository;
    }

    @Override
    public List<Shopkeeper> getShopkeepers() {
        return Lists.newArrayList(shopkeeperRepository.findAll());
    }

    @Override
    public Shopkeeper addShopkeeper(Shopkeeper shopkeeper) {
        return shopkeeperRepository.save(shopkeeper);
    }

    @Override
    public Shopkeeper deleteShopkeeper(Shopkeeper shopkeeper) {
        return null;
    }
}
