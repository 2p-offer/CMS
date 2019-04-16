package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.WaterQualityArgs;
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
public interface WaterQualityDao {

    @Select("select * from aly_waterQuality order by uptime desc  limit #{offset}, #{limit}" )
    List<WaterQualityArgs> getWaterQuality(Map<String, Object> map);

    @Select("select * from aly_waterQuality order by uptime" )
    List<WaterQualityArgs> getWaterQualityAll();

    @Select("select * from aly_waterQuality where id=#{id}")
    WaterQualityArgs getWaterQualityById(String id);

    @Select("select count(*) from aly_waterQuality")
    int getCount(Map<String, Object> map);

    @Insert("insert into aly_waterQuality(ph,dissolvedoxygen,conductivity,turbidity,temperature,salinity,ammonianitrogen,totalphosphorus,totalnitrogen,kmno4,uptime) values(#{ph},#{dissolvedoxygen},#{conductivity},#{turbidity},#{temperature},,#{salinity},#{ammonianitrogen},#{totalphosphorus},#{totalnitrogen},#{kmno4},#{uptime})")
    void insertWaterQuality(WaterQualityArgs waterQualityArgs);

    @Delete("delete from aly_waterQuality where id=#{id}")
    int remove(String id);



}
