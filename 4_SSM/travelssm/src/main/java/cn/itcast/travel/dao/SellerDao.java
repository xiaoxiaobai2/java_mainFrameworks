package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;
import org.apache.ibatis.annotations.Select;

public interface SellerDao {
    /**
     * 根据卖家sid查询卖家信息
     * @return
     */
    @Select("select * from tab_seller where sid=#{arg0}")
    Seller findById(int sid);
}
