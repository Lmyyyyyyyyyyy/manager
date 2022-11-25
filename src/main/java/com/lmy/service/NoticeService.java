package com.lmy.service;

import cn.hutool.core.bean.BeanUtil;

import com.lmy.dao.NoticeMapper;
import com.lmy.entity.Notice;
import com.lmy.repos.NoticeRepository;
import com.lmy.util.ro.PageIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description 用户业务类
  * @Date 2022/11/24 17:35
 * @Author by Soleil
 */
@Service
public class NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 添加用户
     * @param notice 公告
     * @return 返回添加的公告
     */
    public Notice addNotice(Notice notice) {
        return noticeRepository.saveAndFlush(notice);
    }

    /**
       * 编辑公告
     * @param users 公告对象
     * @return true or false
     */
    public boolean updateNotice(Notice notice) {
        return noticeMapper.updateNotice(BeanUtil.beanToMap(notice))>0;
    }

    /**
     * 公告详情
     * @param id 主键
     * @return 公告详情
     */
    public Notice findNoticeById(Integer id) {
        Optional<Notice> optional = noticeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 删除公告
     * @param id 主键
     * @return true or false
     */
    public void deleteNotice(Integer id) {
    	noticeRepository.deleteById(id);
    }


    /**
       * 公告搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageInfo<Notice> getNoticeList(PageIn pageIn) {

        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Notice> listByLike = noticeMapper.findListByLike(pageIn.getKeyword());
        return new PageInfo<>(listByLike);
    }

}
