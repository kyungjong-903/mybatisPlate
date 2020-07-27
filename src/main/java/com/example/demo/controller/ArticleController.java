package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/list")
	public String showList(Model model, @RequestParam Map<String, Object> param) {
		
		if(!param.containsKey("boardId")) {
			param.put("boardId", "2");
		}
		
		if (!param.containsKey("page")) {
			param.put("page", "1");
		}
		
		int boardId = Integer.parseInt((String)param.get("boardId"));
		int page = Integer.parseInt((String)param.get("page"));
		
		Map<String , Object> pagingRs = articleService.getPagingRs(boardId, page);
		
		List<Article> articles = articleService.getArticles(pagingRs);
		
		model.addAttribute("articles", articles);
		
		return "article/list";
	}
	
	@RequestMapping("/article/detail")
	public String showDetail(int articleId, Model model) {
		
		Article article = articleService.getArticle(articleId);
		
		model.addAttribute("article", article);
		
		return "/article/detail";
	}
	
	@RequestMapping("/article/write")
	public String showWrite(){
		
		return "article/write";
	}
	
	@RequestMapping("/article/doWrite")
	public String doWrite(@RequestParam Map<String , Object> param, HttpSession session, Model model) {
		
		articleService.dowrite(param);
		
		model.addAttribute("alertMsg", "글이 작성되었습니다.");
		model.addAttribute("locationReplace", "/");
		
		return "common/redirect";
	}
	
	@RequestMapping("/article/modify")
	public String showWrite(@RequestParam Map<String, Object> param, Model model, HttpSession session){
		
		if (param.get("memberId") != session.getAttribute("loginedMemberId")) {
			model.addAttribute("alertMsg", "권한이 없습니다.");
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}
		else {
			model.addAttribute("article", param);
			
			return "article/modify";
		}
	}
	
	@RequestMapping("/article/doModify")
	public String doModify(@RequestParam Map<String , Object> param) {
		
		articleService.doModify(param);
		
		return "common/redirect";
	}
	
}	
