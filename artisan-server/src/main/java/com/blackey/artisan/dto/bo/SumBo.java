package com.blackey.artisan.dto.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户中心统计数据
 *
 * @author blackey
 * @date 2018/11/10
 */
@Getter
@Setter
public class SumBo {

    private int orderCount;

    private int orderSum;
}
