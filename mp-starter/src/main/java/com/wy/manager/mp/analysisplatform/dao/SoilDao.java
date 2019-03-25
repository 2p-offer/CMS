package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.SoilArgs;
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
public interface SoilDao {


    @Select("select * from aly_soil order by uptime desc  limit #{offset}, #{limit}" )
    List<SoilArgs> getSoil(Map<String, Object> map);


    @Select("select * from aly_soil where id=#{id}")
    SoilArgs getSoilById(String id);

    @Select("select count(*) from aly_soil")
    int getCount(Map<String, Object> map);

    @Insert("insert into aly_soil(cnps,heavymetal,ph,saltion,watercontent,fish,uptime) values(#{cnps},#{heavymetal},#{ph},#{saltion},#{watercontent},#{uptime})")
    void insertSoil(SoilArgs soilArgs);

    @Delete("delete from aly_soil where id=#{id}")
    int remove(String id);



}
