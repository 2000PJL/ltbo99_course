package net.iot228.mapper;

import net.iot228.entity.TbData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 11:30 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Mapper
@Repository
public interface TbDataMapper {
    /**
     * 查询数据列表
     * @author TanXY
     * @date 2021/5/12 14:10
     * @param offset 偏移量
     * @param size 数据量
     * @return java.util.List<net.iot228.entity.TbData>
     */
    List<TbData> selectTbDataList(@Param("offset") int offset, @Param("size") int size);

    /**
     * 统计总总数据条数
     * @author TanXY
     * @date 2021/5/12 14:27
     * @return int 采集数据总量
     */
    int countCollData();

    /**
     * 采集数据
     * @author TanXY
     * @date 2021/5/12 14:30
     * @param tbData 数据对象
     * @return int
     */
    int tbData(TbData tbData);

}
