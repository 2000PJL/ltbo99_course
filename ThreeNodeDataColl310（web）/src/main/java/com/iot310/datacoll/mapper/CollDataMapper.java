package com.iot310.datacoll.mapper;

import com.iot310.datacoll.entity.CollData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TanXY
 * @date 2021/4/28 - 18:50
 */
@Repository
@Mapper
public interface CollDataMapper {

    /**
     * 查询数据列表
     *
     * @author TanXY
     * @date 2021/4/28 19:06
     * @param page 页码
     * @param size 每页数据量
     * @return java.util.List<com.iot310.datacoll.entity.CollData>
     */
    List<CollData> selectCollDataList(@Param("page") int page,@Param("size") int size);

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
