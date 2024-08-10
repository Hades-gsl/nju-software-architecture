package com.hades.webpos.webposdelivery.web;

import com.hades.webpos.webposdelivery.db.MemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@RestController
public class deliveryResource {
  private MemDb memDb;

  @Autowired
  public deliveryResource(MemDb memDb) {
    this.memDb = memDb;
  }

  @GetMapping("/delivery/{orderId}")
  public ResponseEntity<String> getDelivery(@PathVariable String orderId) {
    Long orderTime = memDb.get(orderId);
    if (orderTime == null) {
      return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Order time: " + orderTime, HttpStatus.OK);
  }
}
