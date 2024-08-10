package com.hades.webpos.webposorder.web;

import com.hades.webpos.webposorder.model.Order;
import java.net.URI;
import java.util.UUID;

import com.hades.webpos.webposorder.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderResource {
  private RestTemplate restTemplate;
  private StreamBridge streamBridge;

  @Autowired
  public OrderResource(RestTemplate restTemplate, StreamBridge streamBridge) {
    this.restTemplate = restTemplate;
    this.streamBridge = streamBridge;
  }

  @PostMapping("/order")
  public ResponseEntity<String> postOrder(@ModelAttribute OrderDto orderDto) {
    //    float sum = 0;
    //
    //    for (int i = 0; i < order.getCount().length; i++) {
    //      ResponseEntity<Float> price =
    //          restTemplate.getForEntity(
    //              URI.create("lb://webpos-product-server/product/" + order.getProductId()[i]),
    //              float.class);
    //      sum += price.getBody() * order.getCount()[i];
    //    }

    Order order =
        new Order(UUID.randomUUID().toString(), orderDto.getProductId(), orderDto.getCount());

    streamBridge.send("order-out-0", order.getId());

    return new ResponseEntity<>(order.getId(), HttpStatus.OK);
  }
}
