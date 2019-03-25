package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.MeteorologicalArgs;
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
public interface MeteorologicalDao {

    @Select("select * from aly_meteorological")
    List<MeteorologicalArgs> getMeteorologicalAll();

    @Select("select * from aly_meteorological order by uptime desc  limit #{offset}, #{limit}" )
    List<MeteorologicalArgs> getMeteorologicall(Map<String, Object> map);

    @Select("select * from aly_meteorological where uptime>#{startTime} and uptime<#{endTime}")
    List<MeteorologicalArgs> getMeteorologicalByTime(String startTime, String endTime);


    @Select("select * from aly_meteorological where id=#{id}")
    MeteorologicalArgs getMeteorologicalById(String id);

    @Select("select count(*) from aly_meteorological")
    int getCount(Map<String, Object> map);

    @Insert("insert into aly_meteorological(windspeed,airtemperature,precipitation,evaporation,radiation,uptime) values(#{windspeed},#{airtemperature},#{precipitation},#{evaporation},#{radiation},#{uptime})")
    void insertMeteorological(MeteorologicalArgs meteorologicalArgs);

    @Delete("delete from aly_meteorological where id=#{id}")
    int remove(String id);



}
