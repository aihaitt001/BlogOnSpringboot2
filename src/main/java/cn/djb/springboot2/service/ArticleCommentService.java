package cn.djb.springboot2.service;



import cn.djb.springboot2.domain.ArticleComment;

import java.util.List;


public interface ArticleCommentService {
	List<ArticleComment> list();

	List<ArticleComment> listByParentid(int parentid);

	int deleteByPrimaryKey(Integer id);

	int insert(ArticleComment record);

	int insertSelective(ArticleComment record);

	ArticleComment selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ArticleComment record);

	int updateByPrimaryKey(ArticleComment record);
}
