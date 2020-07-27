package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleDao {

	int getArticlesCountByBoardId(int boardId);

	List<Article> getArticles(Map<String, Object> pagingRs);

	void doWrite(Map<String, Object> param);

	Article getArticle(int articleId);

	void doModify(Map<String, Object> param);

	void hitUp(int articleId);

}
