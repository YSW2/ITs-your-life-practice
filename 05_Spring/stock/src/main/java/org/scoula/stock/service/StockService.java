package org.scoula.stock.service;

import org.scoula.stock.DTO.StockDTO;
import org.scoula.stock.domain.StockVO;

import java.util.List;

public interface StockService {
    List<StockDTO> getList();

    StockVO get(Long no);
}
