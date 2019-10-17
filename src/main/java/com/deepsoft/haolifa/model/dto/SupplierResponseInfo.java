package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.model.domain.Supplier;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class SupplierResponseInfo extends Supplier {

  private List<Accessory> accessories;


}
