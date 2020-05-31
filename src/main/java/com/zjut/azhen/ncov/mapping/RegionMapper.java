package com.zjut.azhen.ncov.mapping;

import com.zjut.azhen.ncov.bean.Region;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionMapper {
    Region getRegionRealtimeById(@Param("id") Integer id);

    int updateRegionById(@Param("id") Integer id,@Param("confrimed") int nrOfConrfirm );

    List<Region> getRegions();

    List<Region> getWorld();


}
