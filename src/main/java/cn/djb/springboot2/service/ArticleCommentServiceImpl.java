package cn.djb.springboot2.service;


import cn.djb.springboot2.domain.ArticleComment;
import cn.djb.springboot2.mapper.ArticleCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {


	@Autowired
	ArticleCommentMapper mapper;

	@Override
	public List<ArticleComment> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ArticleComment record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(ArticleComment record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public ArticleComment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ArticleComment record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ArticleComment record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ArticleComment> listByParentid(int parentid) {
		// TODO Auto-generated method stub
		return mapper.listByParentid(parentid);
	}

}
