package com.lmylbm.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.lmylbm.dao.BookMapper;
import com.lmylbm.entity.Book;
import com.lmylbm.repos.BookRepository;
import com.lmylbm.util.vo.BookOut;
import com.lmylbm.util.vo.PageOut;
import com.lmylbm.util.consts.ConvertUtil;
import com.lmylbm.util.ro.PageIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @Description 图书业务类
 * @author lmylbm
 * @since 2022-11-24
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    /**
     * 添加用户
     * @param book 图书
     * @return 返回添加的图书
     */
    public Book addBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    /**
     * 编辑用户
     * @param book 图书对象
     * @return true or false
     */
    public boolean updateBook(Book book) {
        return bookMapper.updateBook(BeanUtil.beanToMap(book))>0;
    }

    /**
     * 图书详情
     * @param id 主键
     * @return 图书详情
     */
    public BookOut findBookById(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            BookOut out = new BookOut();
            BeanUtil.copyProperties(book,out);
            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
            return out;
        }
        return null;
    }

    public Book findBook(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * ISBN查询
     * @param isbn
     * @return
     */
    public BookOut findBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        BookOut out = new BookOut();
        if (book == null) {
            return out;
        }
        BeanUtil.copyProperties(book,out);
        out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
        return out;
    }

    /**
     * 删除图书
     * @param id 主键
     * @return true or false
     */
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }


    /**
     * 图书搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageOut getBookList(PageIn pageIn) {

        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Book> list = bookMapper.findBookListByLike(pageIn.getKeyword());
        PageInfo<Book> pageInfo = new PageInfo<>(list);

        List<BookOut> bookOuts = new ArrayList<>();
        for (Book book : pageInfo.getList()) {
            BookOut out = new BookOut();
            BeanUtil.copyProperties(book,out);
            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
            out.setType(ConvertUtil.typeStr(book.getType()));
            bookOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(bookOuts);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }


}
