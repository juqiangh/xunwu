package com.learning.service.search;

import com.learning.service.ServiceMultiResult;
import com.learning.service.ServiceResult;
import com.learning.web.form.MapSearch;
import com.learning.web.form.RentSearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements  ISearchService{

    @Override
    public void index(Long houseId) {

    }

    @Override
    public void remove(Long houseId) {

    }

    @Override
    public ServiceMultiResult<Long> query(RentSearch rentSearch) {
        return null;
    }

    @Override
    public ServiceResult<List<String>> suggest(String prefix) {
        return null;
    }

    @Override
    public ServiceResult<Long> aggregateDistrictHouse(String cityEnName, String regionEnName, String district) {
        return null;
    }

    @Override
    public ServiceMultiResult<HouseBucketDTO> mapAggregate(String cityEnName) {
        return null;
    }

    @Override
    public ServiceMultiResult<Long> mapQuery(String cityEnName, String orderBy, String orderDirection, int start, int size) {
        return null;
    }

    @Override
    public ServiceMultiResult<Long> mapQuery(MapSearch mapSearch) {
        return null;
    }
}
