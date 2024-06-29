package com.spongebob.shardingjdbctest.db.dao;

import com.spongebob.shardingjdbctest.db.po.SoCalShoppingShardingOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;


@SpringBootTest
class SoCalShoppingShardingOrderDaoTest {

    @Resource
    SoCalShoppingShardingOrderDao dao;

    @Test
    void insertOrder() {
        for (int i = 0; i < 100; i++) {
            long orderId = i + 500L;
            SoCalShoppingShardingOrder order = SoCalShoppingShardingOrder.builder()
                    .orderStatus(0)
                    .orderNo("123")
                    .orderId(orderId)
                    .orderAmount(123L)
                    .commodityId(123L)
                    .createTime(new Date())
                    .payTime(new Date())
                    .userId(124L)
                    .build();
            dao.insertOrder(order);
        }
    }


    @Test
    void queryShardingOrder() {
    }
}