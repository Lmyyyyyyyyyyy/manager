package com.lmylbm.service;

import cn.hutool.core.bean.BeanUtil;

import com.lmylbm.dao.NoticeMapper;
import com.lmylbm.entity.Notice;
import com.lmylbm.repos.NoticeRepository;
import com.lmylbm.util.ro.PageIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @Description 公告业务类
 * @author lmylbm
 * @since 2022-11-24
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
     * @param notice 公告对象
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
