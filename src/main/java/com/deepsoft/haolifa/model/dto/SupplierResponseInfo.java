package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.model.domain.Supplier;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SupplierResponseInfo extends Supplier {

  private List<Accessory> accessories;


}
