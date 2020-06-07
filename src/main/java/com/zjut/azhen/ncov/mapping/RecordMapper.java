package com.zjut.azhen.ncov.mapping;

import com.zjut.azhen.ncov.bean.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author alex
 */
@Repository
public interface RecordMapper {

    List<Record> getWorldById(@Param("pid") Integer pid,@Param("base") Integer base,@Param("offset") Integer offset);

    List<Record> getChinaById(@Param("pid") Integer pid,@Param("base") Integer base,@Param("offset") Integer offset);

    List<Record> getWorldTotal(@Param("base") Integer base,@Param("offset") Integer offset);
}
