package org.scoula.stock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.DTO.StockDTO;
import org.scoula.stock.domain.StockVO;
import org.scoula.stock.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor

public class StockServiceImpl implements StockService {
    final private StockMapper mapper;

    @Override
    public List<StockDTO> getList() {
        log.info("getList..........");
        return mapper.getList().stream()    // BoardVO의 스트림
                .map(StockDTO::of)  // BoardDTO의 스트림
                .toList();
    }

    @Override
    public StockVO get(Long no) {
        log.info("getDetail");
        return mapper.get(no);
    }
}
