package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(@Param("id") Long id);
}
