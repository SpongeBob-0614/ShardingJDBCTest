package com.spongebob.shardingjdbctest.db.dao;


import com.spongebob.shardingjdbctest.db.po.SoCalShoppingShardingOrder;

public interface SoCalShoppingShardingOrderDao {
    int insert(SoCalShoppingShardingOrder order);
    SoCalShoppingShardingOrder queryOrder(Long orderId, Long userId);

    int insertSharding(SoCalShoppingShardingOrder order);

}
