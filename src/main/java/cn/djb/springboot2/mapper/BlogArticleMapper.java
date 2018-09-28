package cn.djb.springboot2.mapper;


import cn.djb.springboot2.domain.BlogArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper

public interface BlogArticleMapper {
    public Integer flushDB();

    public int add(BlogArticle blogArticle);

    public int deleteByArticleId(Integer articleId);

    public List<BlogArticle> listHomeArticles();

    public List<BlogArticle> list();

    public List<BlogArticle> listByAuthor(String author);

    public BlogArticle getByArticleId(Integer articleId);

    public int updateByArticleId(BlogArticle blogArticle);
}
