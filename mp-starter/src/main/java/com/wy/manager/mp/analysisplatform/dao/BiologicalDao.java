package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.PointArgs;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-21.
 */
@Component
@Mapper
public interface BiologicalDao {

    @Select("select * from aly_biological where jingdu=#{jingdu} and weidu=#{weidu}")
    List<BiologicalArgs> getBiologicalAll(Map<String, Object> map);

    @Select("select * from aly_biological where jingdu=#{jingdu} and weidu=#{weidu}  order by uptime desc  limit #{offset}, #{limit} " )
    List<BiologicalArgs> getBiological(Map<String, Object> map);

    @Select("select * from aly_biological where uptime>#{startTime} and uptime<#{endTime}")
    List<BiologicalArgs> getBiologicalByTime(String startTime,String endTime);


    @Select("select * from aly_biological where id=#{id}")
    BiologicalArgs getBiologicalById(String id);

    @Select("select count(*) from aly_biological where jingdu=#{jingdu} and weidu=#{weidu}")
    int getCount(Map<String, Object> map);

    @Insert("insert into aly_biological(wetlandplants,phytoplankton,zooplankton,benthos,fish,uptime,jingdu,weidu) values(#{wetlandplants},#{phytoplankton},#{zooplankton},#{benthos},#{fish},#{uptime},#{jingdu},#{weidu})")
    void insertBiological(BiologicalArgs biologicalArgs);

    @Delete("delete from aly_biological where id=#{id}")
    int remove(String id);



}
