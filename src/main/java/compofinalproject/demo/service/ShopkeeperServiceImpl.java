package compofinalproject.demo.service;


import compofinalproject.demo.dao.CustomerDao;
import compofinalproject.demo.dao.ShopkeeperDao;
import compofinalproject.demo.entity.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@ConfigurationProperties(prefix = "server")
@Service
public class ShopkeeperServiceImpl implements ShopkeeperService {
    @Autowired
    ShopkeeperDao shopkeeperDao;

    @Override
    public List<Shopkeeper> getShopkeepers() {
        return shopkeeperDao.getShopkeepers();
    }

    @Override
    public Shopkeeper addShopkeeper(Shopkeeper shopkeeper) {
        return shopkeeperDao.addShopkeeper(shopkeeper);
    }
}
