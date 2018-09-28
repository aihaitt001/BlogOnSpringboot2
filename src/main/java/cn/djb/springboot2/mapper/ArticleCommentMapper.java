package cn.djb.springboot2.mapper;


import cn.djb.springboot2.domain.ArticleComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleCommentMapper {
	List<ArticleComment> list();

	List<ArticleComment> listByParentid(int parentid);

	int deleteByPrimaryKey(Integer id);

	int insert(ArticleComment record);

	int insertSelective(ArticleComment record);

	ArticleComment selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ArticleComment record);

	int updateByPrimaryKey(ArticleComment record);
}