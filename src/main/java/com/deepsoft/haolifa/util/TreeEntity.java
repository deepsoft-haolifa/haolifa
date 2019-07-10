package com.deepsoft.haolifa.util;

import java.util.List;

public interface TreeEntity<E> {

    public String getId();

    public String getParentId();

    public void setChildList(List<E> childList);

}
