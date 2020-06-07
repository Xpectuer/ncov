package com.zjut.azhen.ncov.mapping;

import com.zjut.azhen.ncov.bean.Region;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionMapper {
    Region getRegionRealtimeById(@Param("id") Integer id);

    int updateRegionById(@Param("id") Integer id,@Param("confrimed") Integer nrOfConfirm );

    List<Region> getRegions();

    List<Region> getWorld();

    //数据量较小不写缓存
    List<Region> getWorldRank(@Param("base") Integer base,@Param("offset") Integer offset);

    List<Region> getChinaRank(@Param("base") Integer base,@Param("offset") Integer offset);

    Region getWorldById(@Param("id") Integer id);




}
