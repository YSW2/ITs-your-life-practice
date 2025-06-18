package org.scoula.stock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.DTO.BuyDTO;
import org.scoula.stock.DTO.StockDTO;
import org.scoula.stock.service.BuyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class BuyController {

    final private BuyService service;

    @PostMapping("/buy")
    public String buyPost(StockDTO stockDTO) {
        log.info("stockDTO: " + stockDTO);

        BuyDTO buyDTO = BuyDTO.builder()
                .stockCode(stockDTO.getStockCode())
                .stockName(stockDTO.getStockName())
                .price(stockDTO.getPrice())
                .build();

        log.info("buy Contoroller" + buyDTO);
        service.buy(buyDTO);

        return "redirect:buyList";
    }

    @GetMapping("/buyList")
    public String buyListGet(Model model) {
        model.addAttribute("list", service.getList());

        return "stock/buyList";
    }

    @PostMapping("/sell")
    public String sellPost(Long no) {
        service.sell(no);

        return "redirect:/stock/buyList";
    }
}
