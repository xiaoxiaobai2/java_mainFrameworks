package cn.itcast.travel.dao;


import cn.itcast.travel.domain.RouteImg;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ImageDao {
    /**
     * 根据rid查询线路图片
     * @param rid
     * @return
     */
    @Select("select * from tab_route_img where rid=#{arg0}")
    List<RouteImg> findImg(int rid);
}
