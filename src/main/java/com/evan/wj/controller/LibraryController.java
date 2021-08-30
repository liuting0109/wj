package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: liuting
 * @Date: 2021/8/27 15:32
 * @Description:
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception{
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception{
        bookService.deleteById(book.getId());
    }

    @GetMapping("api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") Integer cid)throws Exception{
        if (0 != cid){
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }

    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

    /*public List<Book> searchResult(@RequestBody JSONPObject keywords){
        System.out.println("kk: " + keywords.toString());
        String key = keywords.toString();
        // 关键词为空时查询出所有书籍
        if ("".equals(key)){
            return bookService.list();
        }else {
            return bookService.Search(key);
        }
    }*/
}
