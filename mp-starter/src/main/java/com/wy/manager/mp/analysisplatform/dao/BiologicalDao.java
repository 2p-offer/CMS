package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 2P on 19-3-21.
 */
@Component
@Mapper
public interface BiologicalDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("select * from aly_biological")
    List<BiologicalArgs> getBiologicalAll();

    @Select("select * from aly_biological where uptime>#{startTime} and uptime<#{endTime}")
    List<BiologicalArgs> getBiologicalByTime(String startTime,String endTime);


    @Select("select * from aly_biological where id=#{id}")
    BiologicalArgs getBiologicalById(String id);

    @Insert("insert into aly_biological(wetlandplants,phytoplankton,zooplankton,benthos,fish,uptime) values(#{wetlandplants},#{phytoplankton},#{zooplankton},#{benthos},#{fish},#{uptime})")
    void insertBiological(BiologicalArgs biologicalArgs);


}
