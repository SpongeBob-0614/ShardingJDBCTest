package com.spongebob.shardingjdbctest.db.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class SoCalShoppingShardingOrder {
    private Long orderId;

    private String orderNo;

    private Integer orderStatus;

    private Long commodityId;

    private Long userId;

    private Long orderAmount;

    private Date createTime;

    private Date payTime;

}
