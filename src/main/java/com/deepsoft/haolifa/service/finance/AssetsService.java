package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.assets.AssetsUpDTO;

public interface AssetsService {
    ResultBean save(AssetsAddDTO model);

    ResultBean delete(int id);

    ResultBean update(AssetsUpDTO assetsUpDTO);

    ResultBean<PageDTO<AssetsRSDTO>> getList(AssetsRQDTO assetsRQDTO);
}
