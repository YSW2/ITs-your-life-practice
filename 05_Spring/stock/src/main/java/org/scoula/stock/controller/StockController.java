package org.scoula.stock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    final private StockService service;

    @GetMapping("list")
    public String listGet(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
        return "stock/list";
    }

    @GetMapping("get")
    public String detailGet(@RequestParam("no") Long no, Model model) {
        model.addAttribute("stock", service.get(no));
        return "stock/get";
    }
}
