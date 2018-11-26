package com.deepsoft.haolifa.cache;

public interface NoCacheLoadCallBack<T> {
    T load() throws Exception;
}
