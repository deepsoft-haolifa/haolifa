package com.deepsoft.haolifa.model.dto.order;

import com.deepsoft.haolifa.constant.CommonEnum;
import lombok.Data;

@Data
public class CheckMaterialLockDTO {
    private String materialGraphNo;

    /**
     * 1.机加工；2.喷涂
     */
    private byte type;
    /**
     * 正在机加工，喷涂的数量
     */
    private int lockQuantity;
}
