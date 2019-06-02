package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.HydrologyArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-21.
 */
@Component
@Mapper
public interface HydrologyDao {

    @Select("select * from aly_hydrology where jingdu=#{jingdu} and weidu=#{weidu}")
    List<HydrologyArgs> getHydrologyAll(Map<String, Object> map);

    @Select("select * from aly_hydrology where jingdu=#{jingdu} and weidu=#{weidu} order by uptime desc  limit #{offset}, #{limit}" )
    List<HydrologyArgs> getHydrology(Map<String, Object> map);

    @Select("select * from aly_hydrology where uptime>#{startTime} and uptime<#{endTime}")
    List<HydrologyArgs> getHydrologyByTime(String startTime, String endTime);

    @Select("select * from aly_hydrology where id=#{id}")
    HydrologyArgs getHydrologyById(String id);

    @Select("select count(*) from aly_hydrology where jingdu=#{jingdu} and weidu=#{weidu}")
    int getCount(Map<String, Object> map);

    @Insert("insert into aly_hydrology(currentspeed,flowto,flow,uplevel,downlevel,warning,uptime,jingdu,weidu) values(#{currentspeed},#{flowto},#{flow},#{uplevel},#{downlevel},#{warning},#{uptime},#{jingdu},#{weidu})")
    void insertHydrology(HydrologyArgs hydrologyArgs);

    @Delete("delete from aly_hydrology where id=#{id}")
    int remove(String id);



}
