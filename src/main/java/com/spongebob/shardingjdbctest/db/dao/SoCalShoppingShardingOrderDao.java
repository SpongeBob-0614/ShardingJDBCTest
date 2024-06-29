package com.spongebob.shardingjdbctest.db.dao;


import com.spongebob.shardingjdbctest.db.po.SoCalShoppingShardingOrder;

public interface SoCalShoppingShardingOrderDao {
    int insertOrder(SoCalShoppingShardingOrder order);
    SoCalShoppingShardingOrder queryShardingOrder(Long orderId, Long userId);
}
