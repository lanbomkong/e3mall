package cn.biosh.e3mall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @date 2019/4/15
 */
@Controller
@RequestMapping("/web")
public class WebController {

  @GetMapping("/{page}")
  public String returnPage(@PathVariable(name = "page") String page) {
    return page;
  }

}
