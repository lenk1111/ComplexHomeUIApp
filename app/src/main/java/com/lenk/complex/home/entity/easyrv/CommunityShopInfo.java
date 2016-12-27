package com.lenk.complex.home.entity.easyrv;

import java.util.List;

/**
 * Created by liling on 2016/12/27.
 */

public class CommunityShopInfo {
    private int clickNum;
    private String companyLogoPic;
    private String companyName;
    private String discount;
    private int distance;
    private List<SingleGoodsInfo> goodsInfo;
    private String isFreight;
    private String serviceName;
    private String shopFee;
    private int shoppingNum;
    private String sid;
    private String userApproveStatus;
    private String userHeadPic;
    private String userHeadPicUrl;
    private String userNickName;
    private String userSid;

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public String getCompanyLogoPic() {
        return companyLogoPic;
    }

    public void setCompanyLogoPic(String companyLogoPic) {
        this.companyLogoPic = companyLogoPic;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<SingleGoodsInfo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<SingleGoodsInfo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getIsFreight() {
        return isFreight;
    }

    public void setIsFreight(String isFreight) {
        this.isFreight = isFreight;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getShopFee() {
        return shopFee;
    }

    public void setShopFee(String shopFee) {
        this.shopFee = shopFee;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUserApproveStatus() {
        return userApproveStatus;
    }

    public void setUserApproveStatus(String userApproveStatus) {
        this.userApproveStatus = userApproveStatus;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    public String getUserHeadPicUrl() {
        return userHeadPicUrl;
    }

    public void setUserHeadPicUrl(String userHeadPicUrl) {
        this.userHeadPicUrl = userHeadPicUrl;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserSid() {
        return userSid;
    }

    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }
}
