package com.lmylbm.dao;

import com.lmylbm.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @Description 用户
 * @author lmylbm
 * @since 2022-11-24
 */
@Mapper
@Component
public interface UsersMapper {

    /**
     * 模糊分页查询用户
     * @param keyword 关键字
     * @return
     */
    List<Users> findListByLike(String keyword);

    /**
     * 编辑用户
     * @param map
     * @return
     */
    int updateUsers(Map<String,Object> map);
}
