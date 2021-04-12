package com.jincou.common.domain;


import java.util.Date;

/**
 *  商品订单信息
 *
 * @author xub
 * @date 2021/3/29 下午10:29
 */
public class GoodsOrder {

    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * ⽀付⾦额，单位分
     */
    private Integer totalFee;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图⽚
     */
    private String goodsImg;

    /**
     * ⽤户id
     */
    private Integer userId;

    /**
     * 0表示未⽀付，1表示已⽀付
     */
    private Integer state;

    /**
     * 订单⽣成时间
     */
    private Date createTime;

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
        this.orderNo = orderNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}