package org.scoula.icecream.service;

import org.scoula.icecream.dto.IcecreamDTO;

import java.util.List;

public interface IcecreamService {
    public List<IcecreamDTO> findAll();

    public IcecreamDTO get(Long no);

    public void create(IcecreamDTO board);

    public boolean update(IcecreamDTO board);

    public boolean delete(Long no);

}
