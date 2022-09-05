package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyUpDTO;

public interface CompanyService {
    ResultBean save(CompanyAddDTO model);

    ResultBean delete(int id);

    ResultBean update(CompanyUpDTO assetsUpDTO);

    ResultBean<PageDTO<CompanyRSDTO>> getList(CompanyRQDTO assetsRQDTO);
}
