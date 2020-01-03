package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.model.domain.SporadicMaterial;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.SporadicMaterialPageDto;
import com.deepsoft.haolifa.service.SporadicMaterialService;
import org.springframework.stereotype.Service;

/**
 * @author murphy.he
 **/
@Service
public class SporadicMaterialServiceImpl implements SporadicMaterialService {
    @Override
    public void add(SporadicMaterial material) {
        
    }

    @Override
    public void update(SporadicMaterial material) {

    }

    @Override
    public PageDTO<SporadicMaterial> pageList(SporadicMaterialPageDto pageDto) {
        return null;
    }
}
