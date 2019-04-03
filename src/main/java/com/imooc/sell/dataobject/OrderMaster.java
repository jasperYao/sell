package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单库实体
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;//买家电话
    private String buyerAddress;//买家地址
    private String buyerOpenid;//买家微信openid
    private BigDecimal orderAmount;//订单总金额
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();//订单状态 0:新下单
    private Integer payStatus = PayStatusEnum.WAIT.getCode();//支付状态0:未支付
    private Date createTime;
    private Date updateTime;

    //忽略查找数据库字段.@Transient
    //private List<OrderDetail> orderDetailList;
}
