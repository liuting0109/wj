package com.evan.wj.service;

import com.evan.wj.dao.BookDAO;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liuting
 * @Date: 2021/8/27 15:24
 * @Description:
 */

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return bookDAO.findAll(sort);
    }

    public void addOrUpdate(Book book){
        bookDAO.save(book);
        // save() 方法的作用是，当主键存在时更新数据，当主键不存在时插入数据。
        //这也就是核心的业务逻辑了
    }

    public void deleteById(Integer id){
        bookDAO.deleteById(id);
    }

    public List<Book> listByCategory(Integer cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> Search(String keywords){
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords+'%','%' + keywords + '%');
    }
}
