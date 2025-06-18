package org.scoula.stock.mapper;

import org.scoula.stock.domain.BuyVO;

import java.util.List;

public interface BuyMapper {
    public int insert(BuyVO vo);

    public List<BuyVO> getList();

    public int delete(Long id);
}
