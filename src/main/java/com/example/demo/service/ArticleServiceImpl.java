package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleDao articleDao;

	@Override
	public Map<String, Object> getPagingRs(int boardId, int page) {
		
		Map<String, Object> rs = new HashMap<>();
		
		int pageLimit = 10;
		int range = 3;
		int count = articleDao.getArticlesCountByBoardId(boardId);
		int from = (page - 1) * pageLimit;
		int totalPage = (int) Math.ceil(count / pageLimit);
		int first = page - range;
		int last = page + range;
		if (first <= 0) {
			first = 1;
		}
		if (last > totalPage) {
			last = totalPage;
		}
		
		rs.put("pageLimit", pageLimit);
		rs.put("boardId", boardId);
		rs.put("page", page);
		rs.put("from", from);
		rs.put("first", first);
		rs.put("last", last);
		rs.put("totalPage", totalPage);

		return rs;
	}

	@Override
	public List<Article> getArticles(Map<String, Object> pagingRs) {
		
		
		List<Article> articles = articleDao.getArticles(pagingRs);
		
		
		return articles;
	}

	@Override
	public void dowrite(Map<String, Object> param) {
		articleDao.doWrite(param);
	}

	@Override
	public Article getArticle(int articleId) {
		
		articleDao.hitUp(articleId);
		
		return articleDao.getArticle(articleId);
	}

	@Override
	public void doModify(Map<String, Object> param) {
		articleDao.doModify(param);
	}

}
