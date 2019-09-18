package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class GraphNoRel {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String graphNo;

    private String graphNoM;

    private String graphNoJ;

    public GraphNoRel(Integer id, Date createTime, Date updateTime, String graphNo, String graphNoM, String graphNoJ) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.graphNo = graphNo;
        this.graphNoM = graphNoM;
        this.graphNoJ = graphNoJ;
    }

    public GraphNoRel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getGraphNo() {
        return graphNo;
    }

    public void setGraphNo(String graphNo) {
        this.graphNo = graphNo == null ? null : graphNo.trim();
    }

    public String getGraphNoM() {
        return graphNoM;
    }

    public void setGraphNoM(String graphNoM) {
        this.graphNoM = graphNoM == null ? null : graphNoM.trim();
    }

    public String getGraphNoJ() {
        return graphNoJ;
    }

    public void setGraphNoJ(String graphNoJ) {
        this.graphNoJ = graphNoJ == null ? null : graphNoJ.trim();
    }
}