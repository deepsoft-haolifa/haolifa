package com.deepsoft.haolifa.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhaozhihong
 * @create 2018-08-15 20:08
 * @desc 分页返回对象
 **/
@Data
public class Page<E> {

    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 起始行
     */
    private int startRow;
    /**
     * 末行
     */
    private int endRow;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;


    private List<E> list;

}
