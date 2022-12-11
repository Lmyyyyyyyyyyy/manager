package com.lmylbm.repos;

import com.lmylbm.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 书籍
 * @Date 2022/11/25 09:35
 * @Author by Soleil
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    /**
     * ISBN编码查询
     * @param isbn
     * @return
     */
    Book findByIsbn(String isbn);
}
