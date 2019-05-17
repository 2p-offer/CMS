package com.wy.manager.mp.analysisplatform.dao;

import com.wy.manager.mp.analysisplatform.api.PointArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyan
 * @Date: 2019/5/16
 */
public interface PointDao {

    @Select("select * from aly_point")
    List<PointArgs> getAll();

    @Select("select * from aly_point where id=#{id}")
    PointArgs getPointById(String id);

    @Select("select count(*) from aly_point")
    int getCount(Map<String, Object> map);

    @Insert("insert into aly_point(jingdu,weidu) values(#{jingdu},#{weidu})")
    void insertPoint(PointArgs soilArgs);

    @Delete("delete from aly_point where jingdu=#{jingdu} and weidu=#{weidu}")
    int remove(PointArgs soilArgs);

}
