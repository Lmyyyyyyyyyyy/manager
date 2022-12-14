package com.lmylbm.controller;

import com.lmylbm.entity.Book;
import com.lmylbm.service.BookService;
import com.lmylbm.service.BorrowService;
import com.lmylbm.util.R;
import com.lmylbm.util.http.CodeEnum;
import com.lmylbm.util.ro.PageIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  用户管理
 * </p>
 *
 * @author lmylbm
 * @since 2022-11-24
 */
@Api(tags = "图书管理")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @Autowired
    private BorrowService borrowService;

    @ApiOperation("图书搜索列表")
    @PostMapping("/list")
    public R getBookList(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }

        return R.success(CodeEnum.SUCCESS,bookService.getBookList(pageIn));
    }

    @ApiOperation("添加图书")
    @PostMapping("/add")
    public R addBook(@RequestBody Book book) {
        return R.success(CodeEnum.SUCCESS,bookService.addBook(book));
    }

    @ApiOperation("编辑图书")
    @PostMapping("/update")
    public R modifyBook(@RequestBody Book book) {
        return R.success(CodeEnum.SUCCESS,bookService.updateBook(book));
    }


    @ApiOperation("图书详情")
    @GetMapping("/detail")
    public R bookDetail(Integer id) {
        return R.success(CodeEnum.SUCCESS,bookService.findBookById(id));
    }

    @ApiOperation("图书详情 根据ISBN获取")
    @GetMapping("/detailByIsbn")
    public R bookDetailByIsbn(String isbn) {
        return R.success(CodeEnum.SUCCESS,bookService.findBookByIsbn(isbn));
    }

    @ApiOperation("删除图书")
    @GetMapping("/delete")
    public R delBook(Integer id) {
        bookService.deleteBook(id);
        borrowService.deleteBorrowByBookId(id);
        return R.success(CodeEnum.SUCCESS);
    }

}
