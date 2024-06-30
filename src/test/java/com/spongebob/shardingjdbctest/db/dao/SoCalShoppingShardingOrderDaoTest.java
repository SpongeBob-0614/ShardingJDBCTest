package com.spongebob.shardingjdbctest.db.dao;

import com.spongebob.shardingjdbctest.db.mappers.SoCalShoppingShardingOrderMapper;
import com.spongebob.shardingjdbctest.db.po.SoCalShoppingShardingOrder;
import com.spongebob.shardingjdbctest.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
@Slf4j
class SoCalShoppingShardingOrderDaoTest {


    @Resource
    SoCalShoppingShardingOrderDao orderDao;

    @Test
     void insertOrder() {
        for (int i = 0; i < 100; i++) {
            long orderId = i + 500L;
            SoCalShoppingShardingOrder order = SoCalShoppingShardingOrder.builder()
                    .orderNo("123")
                    .orderId(orderId)
                    .orderAmount(123L)
                    .commodityId(123L)
                    .createTime(new Date())
                    .payTime(new Date())
                    .userId(124L)
                    .orderStatus(0)
                    .build();
            orderDao.insert(order);
        }
    }


    @Test
    void queryShardingOrder() {
        Long orderId = 101L;
       SoCalShoppingShardingOrder onlineShoppingShardingOrder1 = orderDao.queryOrder(orderId, 123L);
        SoCalShoppingShardingOrder onlineShoppingShardingOrder2 = orderDao.queryOrder(orderId+1, 123L);
//        log.info("order1:", objectMapper.writeValueAsString(onlineShoppingShardingOrder1));
//        log.info("order2:", objectMapper.writeValueAsString(onlineShoppingShardingOrder2));
        log.info("order1:{}", onlineShoppingShardingOrder1);
        log.info("order2:{}", onlineShoppingShardingOrder2);
    }

    @Test
    void insert_order_schema_online_shopping_SnowFlake() {
        SnowflakeIdWorker snowFlake = new SnowflakeIdWorker(1, 1); // 模拟。定死了workerid和datacenterid
        List<SoCalShoppingShardingOrder> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            long orderId = snowFlake.nextId();
            System.out.println(orderId);
            SoCalShoppingShardingOrder order =
                    SoCalShoppingShardingOrder.builder()
                            .orderStatus(0)
                            .orderNo("123")
                            .orderId(orderId)
                            .orderAmount(123L)
                            .commodityId(123L)
                            .createTime(new Date())
                            .payTime(new Date())
                            .userId(124L)
                            .orderStatus(0)
                            .build();
            orders.add(order);
        }
        for (int i = 0; i < 100; i++) {
            orderDao.insertSharding(orders.get(i));
        }
    }
}