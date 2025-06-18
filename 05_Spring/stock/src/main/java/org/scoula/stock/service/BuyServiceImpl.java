package org.scoula.stock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.DTO.BuyDTO;
import org.scoula.stock.mapper.BuyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor

public class BuyServiceImpl implements BuyService {
    final private BuyMapper mapper;

    @Override
    public void buy(BuyDTO dto) {
        log.info("buy");
        log.info(mapper.insert(dto.toVo()));
    }

    @Override
    public List<BuyDTO> getList() {
        log.info("getList");
        return mapper.getList().stream().map(BuyDTO::of).toList();
    }

    @Override
    public void sell(Long id) {
        log.info("sell");
        log.info(mapper.delete(id));
    }
}
