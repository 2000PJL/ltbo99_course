package com.iot45.mapper;/*
 * @Systemname: BookShow
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  15:32 2022/1/4
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */


import com.iot45.entity.CollData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CollDataMapper {
    /**
     * @Author PJL
     * @Description //TODO 查询采集到的所有数据
     * @Date
     * @Param
     * @return List<CollData>
     **/
    List<CollData> selectAllCollData();

    /**
     * @Author PJL
     * @Description //TODO 查询数据总量，用于分页
     * @Date
     * @Param []
     * @return int
     **/
    int countCollData();

    /**
     * @Author PJL
     * @Description //TODO 根据id删除数据
     * @Date
     * @Param [id]
     * @return int
     **/
    int deleteCollDataById(int id);

    /**
     * @Author PJL
     * @Description //TODO 插入采集到的数据
     * @Date
     * @Param [collData]
     * @return int
     **/
    int insertCollData(CollData collData);

    /**
     * @Author PJL
     * @Description //TODO 根据id修改数据
     * @Date
     * @Param [collData]
     * @return int
     **/
    int updateCollDateById(CollData collData);
}
