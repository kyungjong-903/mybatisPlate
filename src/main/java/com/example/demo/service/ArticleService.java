package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Article;

@Service
public interface ArticleService {

	Map<String, Object> getPagingRs(int boardId, int page);

	List<Article> getArticles(Map<String, Object> pagingRs);

	void dowrite(Map<String, Object> param);

	Article getArticle(int articleId);

	void doModify(Map<String, Object> param);

}
