package com.deepsoft.haolifa.dao.repository.extend;

import org.apache.ibatis.annotations.Select;

public interface MyUserMapper {

    @Select("UPDATE `sys_user` SET `is_delete` = !`is_delete` WHERE id = #{id}")
    int closeOrOpenUser(Integer id);

}
