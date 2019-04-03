package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final  String OPENID = "220220";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("456321");
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerPhone("13681072324");
        orderMaster.setBuyerAddress("北京市");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster orderMaster1 = repository.save(orderMaster);
        Assert.assertNotNull(null,orderMaster1);
    }

    @Test
    public void findByBuyerOpenidTest() {
        //PageRequest request = new PageRequest(0,1);
        Pageable pageable = PageRequest.of(0,1);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,pageable);
        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}