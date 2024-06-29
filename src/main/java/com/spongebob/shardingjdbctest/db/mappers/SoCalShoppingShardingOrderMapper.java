package com.spongebob.shardingjdbctest.db.mappers;


import com.spongebob.shardingjdbctest.db.po.SoCalShoppingShardingOrder;

public interface SoCalShoppingShardingOrderMapper {

    int insert(SoCalShoppingShardingOrder record);

    SoCalShoppingShardingOrder queryOrder(Long orderId, Long userId);

    int insertSharding(SoCalShoppingShardingOrder order);
}
