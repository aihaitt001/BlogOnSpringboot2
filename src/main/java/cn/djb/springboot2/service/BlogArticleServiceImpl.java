package cn.djb.springboot2.service;


import cn.djb.springboot2.domain.BlogArticle;
import cn.djb.springboot2.mapper.BlogArticleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogArticleServiceImpl implements BlogArticleService {

	@Autowired
	BlogArticleMapper articlemapper;

	@Override
	public int  add(BlogArticle article) {
		// TODO Auto-generated method stub
		return articlemapper.add(article);
	}

	@Override
	public int deleteByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articlemapper.deleteByArticleId(articleId);
	}

	@Override
	  public List<BlogArticle> listHomeArticles(){
		System.out.println("listhomearticles");
	return articlemapper.listHomeArticles();
	}
	@Override
	public List<BlogArticle> list() {
		// TODO Auto-generated method stub
		System.out.println(articlemapper);
		return articlemapper.list();
	}

	@Override
	public BlogArticle getByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		return articlemapper.getByArticleId(articleId);
	}

	@Override
	public int updateByArticleId(BlogArticle article) {
		// TODO Auto-generated method stub
		return articlemapper.updateByArticleId(article);
	}

	@Override
	public List<BlogArticle> listByAuthor(String author) {
		// TODO Auto-generated method stub
		return articlemapper.listByAuthor(author);
	}
/**
*@Decription:根据作者和页数，每页个数来查找
*@param:[username, pagenum, pagesize]:[]
*@return:java.util.List<cn.djb.ttblog.model.BlogArticle>
*@author: ovo
*@Date: 2018/9/18
**/
	@Override
	public List<BlogArticle> listArticleByPage(String username, int pagenum, int pagesize) {
		// TODO Auto-generated method stub
		// 分页查询

		return articlemapper.listByAuthor(username);
	}

	@Override
	public Integer flushDB() {
		return articlemapper.flushDB();

	}

}
