package org.scoula.icecream.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.domain.IcecreamVO;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.mapper.IcecreamMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor

public class IcecreamImpl implements IcecreamService {
    final private IcecreamMapper mapper;

    @Override
    public List<IcecreamDTO> findAll() {
        return mapper.findAll().stream()    // BoardVO의 스트림
                .map(IcecreamDTO::of)            // BoardDTO의 스트림
                .toList();
    }

    @Override
    public IcecreamDTO get(Long no) {
        return null;
    }

    @Override
    public void create(IcecreamDTO dto) {
        IcecreamVO icecream = dto.toVo();
        mapper.create(icecream);
        log.info("create..." + icecream);
    }

    @Override
    public boolean update(IcecreamDTO dto) {
        return false;
    }

    @Override
    public boolean delete(Long no) {
        int result = mapper.delete(no);
        return result == 1;
    }
}
