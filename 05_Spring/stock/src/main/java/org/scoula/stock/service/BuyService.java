package org.scoula.stock.service;

import org.scoula.stock.DTO.BuyDTO;

import java.util.List;

public interface BuyService {
    void buy(BuyDTO dto);

    List<BuyDTO> getList();

    void sell(Long id);
}
