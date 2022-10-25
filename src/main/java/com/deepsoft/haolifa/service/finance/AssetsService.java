package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.assets.*;

public interface AssetsService {
    ResultBean save(AssetsAddDTO model);

    ResultBean delete(int id);

    ResultBean update(AssetsUpDTO assetsUpDTO);

    ResultBean<PageDTO<AssetsRSDTO>> getList(AssetsRQDTO assetsRQDTO);

    ResultBean<AssetsSumDTO> getAssetsSum(AssetsRQDTO assetsRQDTO);

    void job();
}
