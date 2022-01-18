package net.iot228.mapper;

import net.iot228.entity.TbEquState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 11:36 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Repository
@Mapper
public interface TbEquStateMapper {
    /**
     * 根据id查询设备状态
     * @author TanXY
     * @date 2021/5/13 9:41
     * @param id 设备id
     * @return
     */
    TbEquState selectTbEquStateById(int id);

    /**
     * 更新设备状态
     * @author TanXY
     * @date 2021/5/13 9:42
     * @param equipState 设备状态对象
     * @return
     */
    int updateEquipState(TbEquState equipState);
}
