package com.iot310.datacoll.service.impl;

import com.iot310.datacoll.entity.CollData;
import com.iot310.datacoll.mapper.CollDataMapper;
import com.iot310.datacoll.service.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TanXY
 * @date 2021/4/28 - 18:52
 */
@Service
public class CollDataServiceImpl implements CollDataService {

    @Autowired
    CollDataMapper collDataMapper;

    @Override
    public List<CollData> selectCollDataList(int page, int size) {
        page = (page - 1) * size;
        return collDataMapper.selectCollDataList(page, size);
    }

    @Override
    public int countCollData() {
        return collDataMapper.countCollData();
    }

    @Override
    public int insertData(CollData collData) {
        return collDataMapper.insertData(collData);
    }
}
