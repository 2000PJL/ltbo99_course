package com.iot310.datacoll.service;

import com.iot310.datacoll.entity.CollData;

import java.util.List;

/**
 * @author TanXY
 * @date 2021/4/28 - 18:51
 */
public interface CollDataService {
    /**
     * 查询数据列表
     *
     * @author TanXY
     * @date 2021/4/28 19:06
     * @param page 页码
     * @param size 每页数据量
     * @return java.util.List<com.iot310.datacoll.entity.CollData>
     */
    List<CollData> selectCollDataList(int page, int size);

    /**
     * 查询数据总量用于分页
     * @author TanXY
     * @date 2021/4/28 19:07
     * @return int
     */
    int countCollData();

    /**
     * 采集数据
     *
     * @author TanXY
     * @date 2021/4/28 19:07
     * @param collData 采集的数据
     * @return int
     */
    int insertData(CollData collData);
}
