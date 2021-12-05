package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.dto.PayManagerCalDTO;

public interface PayManagerCalService {
    PayManagerCal getInfo(PayManagerCalDTO payManagerCalDTO);
}
