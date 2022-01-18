package net.iot228.service.Impl;

import net.iot228.entity.TbData;
import net.iot228.mapper.TbDataMapper;
import net.iot228.service.TbDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 15:23 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Service
public class TbDataServiceImpl implements TbDataService {

    @Autowired
    TbDataMapper tbDataMapper;

    @Override
    public List<TbData> selectTbDataList(int page, int size) {
        page = size * (page - 1);
        return tbDataMapper.selectTbDataList(page, size);
    }

    @Override
    public int countCollData() {
        return tbDataMapper.countCollData();
    }

    @Override
    public int tbData(TbData tbData) {

        return tbDataMapper.tbData(tbData);
    }


}