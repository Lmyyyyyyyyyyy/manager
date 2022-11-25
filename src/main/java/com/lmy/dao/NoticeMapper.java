package com.lmy.dao;

import com.lmy.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2022/11/42 17:35
 * @Author by Soleil
 */
@Mapper
@Component
public interface NoticeMapper {

    /**
     * 模糊分页查询公告
     * @param keyword 关键字
     * @return
     */
    List<Notice> findListByLike(String keyword);

    /**
      * 编辑公告
     * @param map
     * @return
     */
    int updateNotice(Map<String,Object> map);
}
