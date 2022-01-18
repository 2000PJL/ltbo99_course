package net.iot228.service.Impl;

import net.iot228.entity.TbEquState;
import net.iot228.mapper.TbEquStateMapper;
import net.iot228.service.TbEquStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 15:24 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Service
public class TbEquStateServiceImpl implements TbEquStateService {


    @Autowired
    TbEquStateMapper tbEquStateMapper;

    @Override
    public TbEquState selectTbEquStateById(int id) {
        return tbEquStateMapper.selectTbEquStateById(id);
    }

    @Override
    public int updateEquipState(TbEquState equipState) {
        return tbEquStateMapper.updateEquipState(equipState);
    }
}

