package com.deepsoft.haolifa.model.dto.storage;

import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductStorageListDTO extends EntryOutStoreRecord {

  @ApiModelProperty("成品是否可出库操作：0 可以出库 1 不可以出库")
  private Integer execute;

}
