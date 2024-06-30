package com.spongebob.shardingjdbctest.db.dao.impl;


import com.spongebob.shardingjdbctest.db.dao.SoCalShoppingShardingOrderDao;
import com.spongebob.shardingjdbctest.db.mappers.SoCalShoppingShardingOrderMapper;
import com.spongebob.shardingjdbctest.db.po.SoCalShoppingShardingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class SoCalShoppingShardingOrderDaoImpl implements SoCalShoppingShardingOrderDao {

    @Autowired
    private SoCalShoppingShardingOrderMapper mapper;

    @Override
    public int insertOrder(SoCalShoppingShardingOrder order) {
        return mapper.insert(order);
    }

    @Override
    public SoCalShoppingShardingOrder queryOrder(Long orderId, Long userId) {
        return mapper.queryOrder(orderId,userId);
    }
}
