package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.List;


public interface RouteService {
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);
    Route findRouteInf(int rid);

    /**
     * 判断该线路是否被当前用户收藏
     * @param rid
     * @param uid
     * @return
     */
    Boolean isFavorite(int rid,int uid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void addFavorite(int rid,int uid);

    /**
     * 查询我的收藏
     * @param uid
     * @return 收藏的线路列表
     */
    List<Route> findMyFavorite(int uid);

    PageBean<Route> findAllRoute(int maxPrice,int minPrice,String rname,int currentPage,int cid,int pageSize);

}
