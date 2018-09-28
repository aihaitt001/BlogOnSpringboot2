package cn.djb.springboot2.service;


import cn.djb.springboot2.domain.BlogArticle;

import java.util.List;


public interface BlogArticleService {
    public int add(BlogArticle article);

    public Integer flushDB();

    public int deleteByArticleId(Integer articleId);

    public List<BlogArticle> listHomeArticles();

    public List<BlogArticle> list();

    public List<BlogArticle> listByAuthor(String author);

    public BlogArticle getByArticleId(Integer articleId);

    public int updateByArticleId(BlogArticle article);

    public List<BlogArticle> listArticleByPage(String username, int pagenum, int pagesize);
}
