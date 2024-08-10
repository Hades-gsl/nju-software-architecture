package com.example.webpos.db;

import com.example.webpos.model.Product;
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class JD implements PosDB {

  private List<Product> products = null;

  @Override
  @Cacheable(value = "products")
  public List<Product> getProducts() {
    try {
      if (products == null) products = parseJD("Java");
    } catch (IOException e) {
      products = new ArrayList<>();
    }

    return products;
  }

  @Override
  public Product getProduct(String productId) {
    for (Product p : getProducts()) {
      if (Objects.equals(p.getId(), productId)) {
        return p;
      }
    }
    return null;
  }

  public static List<Product> parseJD(String keyword) throws IOException {
    // 获取请求https://search.jd.com/Search?keyword=java
    String url = "https://search.jd.com/Search?keyword=" + keyword;
    // 设置cookie
    Map<String, String> cookies = new HashMap<>();
    cookies.put(
        "pt_key", "AAJmLJEWADBF4Hsbv3xfWYzXHBc7o3V3XraSwDPadvn0DXitQjbpCAzmOstUtfHsA2SH6wAhFcQ");
    cookies.put("pt_pin", "jd_UrVjYHUujwYk");
    // 解析网页
    Document document = Jsoup.connect(url).cookies(cookies).get();
    // 所有js的方法都能用
    Element element = document.getElementById("J_goodsList");
    // 获取所有li标签
    Elements elements = element.getElementsByTag("li");
    //        System.out.println(element.html());
    List<Product> list = new ArrayList<>();

    // 获取元素的内容
    for (Element el : elements) {
      // 关于图片特别多的网站，所有图片都是延迟加载的
      String id = el.attr("data-spu");
      String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
      String price = el.getElementsByAttribute("data-price").text();
      String title = el.getElementsByClass("p-name").eq(0).text();
      if (title.contains("，")) {
        title = title.substring(0, title.indexOf("，"));
      }

      Product product;
      try {
        product = new Product(id, title, Double.parseDouble(price), img, keyword, 1, 20);
      } catch (Exception e) {
        product = new Product(id, title, 0, img, keyword, 1, 20);
      }

      list.add(product);
    }
    return list;
  }
}
