package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RouteDao {

    /**
     * 查找当前 目录的所有路线数
     * @return
     */

    @Select("<script>" +
            "select count(*) from tab_route " +
            "<where> " +
            "<if test='arg0!=0'>" +
            " cid=#{arg0} " +
            "</if>" +
            "<if test='arg1!=null and arg1.length()>0'>" +
            " and rname like #{arg1} " +
            "</if>" +
            "</where>" +
            "</script>")
    int findTotalRoute(int cid, String rname);


    @Select("<script>" +
            "select * from tab_route " +
            "<where> " +

            "<if test='param1!=0'>" +
            " and cid=#{arg0} " +
            "</if>" +




            "<if test='param4!=null and param4.length()>0 and !param4.equalsIgnoreCase(\"null\")'>" +
            " and rname like #{arg3} " +
            "</if>" +

            " limit #{arg1},#{arg2}" +
            "</where>" +
            "</script>")
    List<Route> findRouteByPage(int cid,int start,int pageSize, String rname);

    /**
     * 根据rid查询线路
     * @param rid
     * @return
     */
    @Select("select * from tab_route where rid=#{arg0}")
    Route findRouteById(int rid);

    /**
     * 该线路被收藏的次数+1
     */
    @Update("update tab_route set count=#{arg0} where rid=#{arg1}")
    void updateCount(int count,int rid);




    @Select("<script>" +
            "select count(*) from tab_route " +
            "<where> " +

            "<if test='param1!=0'>" +
            "cid=#{arg0} " +
            "</if>" +

            "<if test='param4!=null and param4.length()>0 and !param4.equalsIgnoreCase(\"null\")'>" +
            " and rname like #{arg3} " +
            "</if>" +

            "<if test='!(param2 &lt; 0)'>" +
            " and price &lt; #{param2} " +
            "</if>" +

            "<if test='!(param3 &lt; 0)'>" +
            " and price &gt; #{param3} " +
            "</if>" +

            " ORDER BY count desc" +
            "</where>" +
            "</script>")
    int findAllRouteNum(int cid,int maxPrice,int minPrice,String rname);

    /**
     * 查询指定条数 符合要求的线路，
     * @param cid
     * @param maxPrice
     * @param minPrice
     * @param rname
     * @return
     */
    @Select("<script>" +
            "select * from tab_route " +
            "<where> " +

            "<if test='param1!=0'>" +
            " cid=#{arg0} " +
            "</if>" +

            "<if test='param4!=null and param4.length()>0 and !param4.equalsIgnoreCase(\"null\")'>" +
            " and rname like #{arg3} " +
            "</if>" +


            "<if test='!(param2 &lt; 0)'>" +
            " and price &lt; #{param2} " +
            "</if>" +

            "<if test='!(param3 &lt; 0)'>" +
            " and price &gt; #{param3} " +
            "</if>" +

            " ORDER BY count desc limit #{param5},#{param6}  " +
            "</where>" +

            "</script>")
    List<Route> findAllRoutePage(int cid,int maxPrice,int minPrice,String rname,int start,int pageSize);
}
