package com.lmylbm.repos;

import com.lmylbm.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 借阅管理 jpa查询
 * @Date 2022/11/25 09:36
 * @Author by Soleil
 */
@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Integer>{

    /**
     * 查询借阅信息
     * @param userId 用户id
     * @return
     */
    List<Borrow> findBorrowByUserId(Integer userId);

    /**
     * 查询已借阅信息
     * @param userId 用户id
     * @param ret 是否归还, 0 已归还/ 1 未归还
     * @return
     */
    List<Borrow> findBorrowsByUserIdAndRet(@Param("userId") Integer userId,@Param("ret")Integer ret);

    /**
     * 查询用户某一条借阅信息
     * @param userId 用户id
     * @param bookId 图书id
     */
    Borrow findBorrowByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
}
