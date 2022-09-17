package com.deepsoft.haolifa.model.domain;

import java.util.Date;

public class OrderTechnicalDetailedRel {
    private Integer id;

    private String orderNo;

    private String seqNo;

    private String productName;

    private Integer productNum;

    private String productModel;

    private String specifications;

    private String upperFlangeStandard;

    private String connectingHole;

    private String angle;

    private String centerDistance;

    private String outputShaftType;

    private String outputShaftLength;

    private String axisDrawingNo;

    private String connectingSleeve;

    private String transitionPlate;

    private String staticTorque;

    private String actuatorModel;

    private String remark;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public OrderTechnicalDetailedRel(Integer id, String orderNo, String seqNo, String productName, Integer productNum, String productModel, String specifications, String upperFlangeStandard, String connectingHole, String angle, String centerDistance, String outputShaftType, String outputShaftLength, String axisDrawingNo, String connectingSleeve, String transitionPlate, String staticTorque, String actuatorModel, String remark, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.seqNo = seqNo;
        this.productName = productName;
        this.productNum = productNum;
        this.productModel = productModel;
        this.specifications = specifications;
        this.upperFlangeStandard = upperFlangeStandard;
        this.connectingHole = connectingHole;
        this.angle = angle;
        this.centerDistance = centerDistance;
        this.outputShaftType = outputShaftType;
        this.outputShaftLength = outputShaftLength;
        this.axisDrawingNo = axisDrawingNo;
        this.connectingSleeve = connectingSleeve;
        this.transitionPlate = transitionPlate;
        this.staticTorque = staticTorque;
        this.actuatorModel = actuatorModel;
        this.remark = remark;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderTechnicalDetailedRel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getUpperFlangeStandard() {
        return upperFlangeStandard;
    }

    public void setUpperFlangeStandard(String upperFlangeStandard) {
        this.upperFlangeStandard = upperFlangeStandard == null ? null : upperFlangeStandard.trim();
    }

    public String getConnectingHole() {
        return connectingHole;
    }

    public void setConnectingHole(String connectingHole) {
        this.connectingHole = connectingHole == null ? null : connectingHole.trim();
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle == null ? null : angle.trim();
    }

    public String getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(String centerDistance) {
        this.centerDistance = centerDistance == null ? null : centerDistance.trim();
    }

    public String getOutputShaftType() {
        return outputShaftType;
    }

    public void setOutputShaftType(String outputShaftType) {
        this.outputShaftType = outputShaftType == null ? null : outputShaftType.trim();
    }

    public String getOutputShaftLength() {
        return outputShaftLength;
    }

    public void setOutputShaftLength(String outputShaftLength) {
        this.outputShaftLength = outputShaftLength == null ? null : outputShaftLength.trim();
    }

    public String getAxisDrawingNo() {
        return axisDrawingNo;
    }

    public void setAxisDrawingNo(String axisDrawingNo) {
        this.axisDrawingNo = axisDrawingNo == null ? null : axisDrawingNo.trim();
    }

    public String getConnectingSleeve() {
        return connectingSleeve;
    }

    public void setConnectingSleeve(String connectingSleeve) {
        this.connectingSleeve = connectingSleeve == null ? null : connectingSleeve.trim();
    }

    public String getTransitionPlate() {
        return transitionPlate;
    }

    public void setTransitionPlate(String transitionPlate) {
        this.transitionPlate = transitionPlate == null ? null : transitionPlate.trim();
    }

    public String getStaticTorque() {
        return staticTorque;
    }

    public void setStaticTorque(String staticTorque) {
        this.staticTorque = staticTorque == null ? null : staticTorque.trim();
    }

    public String getActuatorModel() {
        return actuatorModel;
    }

    public void setActuatorModel(String actuatorModel) {
        this.actuatorModel = actuatorModel == null ? null : actuatorModel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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
}