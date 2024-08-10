package com.example.webpos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.webpos.biz.PosService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosController {

  private PosService posService;

  @Autowired
  public void setPosService(PosService posService) {
    this.posService = posService;
  }

  @GetMapping("/")
  public String pos(Model model) {
    model.addAttribute("products", posService.products());
    model.addAttribute("cart", posService.getCart());
    return "index";
  }

  @GetMapping("/add")
  public String add(@RequestParam("pid") String productId, Model model) {
    posService.add(productId, 1);
    return "redirect:/";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("pid") String productId, Model model) {
    posService.delete(productId);
    return "redirect:/";
  }

  @GetMapping("/minus")
  public String minus(@RequestParam("pid") String productId, Model model) {
    posService.minus(productId, 1);
    return "redirect:/";
  }

  @GetMapping("/charge")
  public String charge(Model model) {
    double total = posService.checkout(posService.getCart());
    model.addAttribute("products", posService.products());
    model.addAttribute("cart", posService.getCart());
    model.addAttribute("total", total);
    return "index";
  }

  @GetMapping("/clear")
  public String clear(Model model) {
    posService.newCart();
    return "redirect:/";
  }
}
