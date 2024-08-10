package com.example.webpos.controller;

import com.example.webpos.api.SettingsApi;
import com.example.webpos.biz.PosService;
import com.example.webpos.dto.SettingsGet200ResponseInnerDto;
import com.example.webpos.dto.SettingsGet200ResponseInnerSettingsDto;
import com.example.webpos.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hades @Date: 2024/4/22 19:19 @Description:
 */
@RestController
@CrossOrigin
public class SettingsController implements SettingsApi {
  private PosService posService;

  @Autowired
  public SettingsController(PosService posService) {
    this.posService = posService;
  }

  @Override
  public ResponseEntity<List<SettingsGet200ResponseInnerDto>> settingsGet() {
    List<Settings> settings = posService.getSettings();

    List<SettingsGet200ResponseInnerDto> res = new ArrayList<>();
    for (Settings setting : settings) {
      res.add(
          new SettingsGet200ResponseInnerDto()
              .id(String.valueOf(setting.getId()))
              .settings(
                  new SettingsGet200ResponseInnerSettingsDto()
                      .app(setting.getApp())
                      .store(setting.getStore())
                      .addressOne(setting.getAddressOne())
                      .addressTwo(setting.getAddressTwo())
                      .contact(setting.getContact())
                      .tax(BigDecimal.valueOf(setting.getTax()))
                      .symbol(setting.getSymbol())
                      .percentage(setting.getPercentage())
                      .footer(setting.getFooter())
                      .img(setting.getImg())));
    }

    return new ResponseEntity<>(res, HttpStatus.OK);
  }
}
