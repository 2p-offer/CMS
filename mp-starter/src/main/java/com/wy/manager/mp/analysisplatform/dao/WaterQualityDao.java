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

    @Select("select * from aly_waterquality where jingdu=#{jingdu} and weidu=#{weidu} order by uptime desc  limit #{offset}, #{limit}" )
    List<WaterQualityArgs> getWaterQuality(Map<String, Object> map);

    @Select("select * from aly_waterquality where jingdu=#{jingdu} and weidu=#{weidu} order by uptime" )
    List<WaterQualityArgs> getWaterQualityAll(Map<String, Object> map);

    @Select("select * from aly_waterquality where id=#{id}")
    WaterQualityArgs getWaterQualityById(String id);

    @Select("select count(*) from aly_waterquality where jingdu=#{jingdu} and weidu=#{weidu}")
    int getCount(Map<String, Object> map);
    @Insert("insert into aly_waterquality(ph,dissolvedoxygen,conductivity,turbidity,temperature,salinity,ammonianitrogen,totalphosphorus,totalnitrogen,kmno4,k,ca,na,mg,cl,so4,no3,co3,doc,shen,ge2,tong,qian,xin,nie,ge4,gai,mei,tie,lv,quandan,quanlin,quanliu,uptime,jingdu,weidu,warning) values(#{ph},#{dissolvedoxygen},#{conductivity},#{turbidity},#{temperature},#{salinity},#{ammonianitrogen},#{totalphosphorus},#{totalnitrogen},#{kmno4},#{k},#{ca},#{na},#{mg},#{cl},#{so4},#{no3},#{co3},#{doc},#{shen},#{ge2},#{tong},#{qian},#{xin},#{nie},#{ge4},#{gai},#{mei},#{tie},#{lv},#{quandan},#{quanlin},#{quanliu},#{uptime},#{jingdu},#{weidu},#{warning})")
    void insertWaterQuality(WaterQualityArgs waterQualityArgs);

    @Delete("delete from aly_waterquality where id=#{id}")
    int remove(String id);



}
