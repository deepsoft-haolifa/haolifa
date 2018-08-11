package com.deepsoft.haolifa.util;

import java.util.UUID;

public class UUIDGenerator {

    public static String getUUID32(){

        return UUID.randomUUID().toString().replace("-", "");

    }

}
