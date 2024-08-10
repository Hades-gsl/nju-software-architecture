package com.hades.webpos.webposorder.web;

import com.hades.webpos.webposorder.model.Order;
import com.hades.webpos.webposorder.model.OrderDto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class OrderResource {
  private RestTemplate restTemplate;
  private StreamBridge streamBridge;

  @Autowired
  public OrderResource(RestTemplate restTemplate, StreamBridge streamBridge) {
    this.restTemplate = restTemplate;
    this.streamBridge = streamBridge;
  }

  @PostMapping("/order")
  public Mono<String> postOrder(@ModelAttribute OrderDto orderDto) {
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

    return Mono.just(order.getId());
  }

  @Data
  @AllArgsConstructor
  class Settings {
    private String app;
    private String store;
    private String addressOne;
    private String addressTwo;
    private String contact;
    private double tax;
    private String symbol;
    private int percentage;
    private String footer;
    private String img;
  }

  @Data
  @AllArgsConstructor
  class SettingsDto {
    private String id;
    private Settings settings;
  }

  @GetMapping("/settings")
  public ResponseEntity<List<SettingsDto>> getSettings() {
    List<SettingsDto> settings =
        List.of(
            new SettingsDto(
                "1",
                new Settings(
                    "Standalone Point of Sale",
                    "Store-Pos",
                    "10086",
                    "10087",
                    "15968774896",
                    0.0,
                    "$",
                    10,
                    "",
                    "")));
    return new ResponseEntity<>(settings, HttpStatus.OK);
  }

  @Data
  @AllArgsConstructor
  public class Category {
    private Integer id;
    private String name;
  }

  @GetMapping("/categories")
  public ResponseEntity<List<Category>> getCategories() {
    List<Category> categories = List.of(new Category(1, "drink"), new Category(2, "snack"));
    return new ResponseEntity<>(categories, HttpStatus.OK);
  }
}
