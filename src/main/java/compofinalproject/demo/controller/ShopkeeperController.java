package compofinalproject.demo.controller;

import compofinalproject.demo.entity.Customer;
import compofinalproject.demo.entity.Shopkeeper;
import compofinalproject.demo.service.CustomerService;
import compofinalproject.demo.service.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class ShopkeeperController {
    ShopkeeperService shopkeeperService;
    @Autowired
    public void setCustomerService(ShopkeeperService shopkeeperService) {
        this.shopkeeperService = shopkeeperService;
    }

    @GetMapping("/shopkeeper")
    public ResponseEntity<?> getCustomers() {

        List<Shopkeeper> shopkeepers = shopkeeperService.getShopkeepers();
        return ResponseEntity.ok(shopkeepers);
    }

    @PostMapping("/shopkeeper")
    public ResponseEntity<?> uploadOnlyShopkeeper(@RequestBody Shopkeeper shopkeeper) {
        shopkeeperService.addShopkeeper(shopkeeper);
        return ResponseEntity.ok(shopkeeper);
    }

}
