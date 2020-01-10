package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FavoriteDao {
    /**
     * 根据 uid 和 rid  查询  Favorite
     * @param rid
     * @return
     */
    @Select("select * from tab_favorite where rid=#{arg0} and uid=#{arg1}")
    Favorite findById(int rid,int uid);

    /**
     * 添加一条新的收藏记录
     * @param favorite
     */
    @Insert(" insert into tab_favorite(rid,date,uid) values(#{rid},#{date},#{uid})")
    void add(Favorite favorite);

    /**
     * 查找到 uid 对应的所有 rid
     * @param uid
     * @return
     */
    @Select("select * from tab_favorite where uid=#{arg0}")
    List<Favorite> findByuid(int uid);
}
