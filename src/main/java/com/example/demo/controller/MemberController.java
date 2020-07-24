package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("/login")
	public String showLogin() {	
		
		return "./Login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param, HttpSession session, Model model) {
		
		Map<String, Object> rs =  memberservice.getMemberbyIdPw(param);
		
		model.addAttribute("alertMs", (String)rs.get("alertMs"));
		model.addAttribute("reDirectUrl", (String)rs.get("reDirectUrl"));
		
		return "./common/redirect";
	}
	
	@RequestMapping("/Join")
	public String showJoin() {	
		
		return "/Join";
	}
	
	@RequestMapping("/doJoin")
	public String doJoin(@RequestParam Map<String, Object> param, Model model) {
		
		System.out.println(param);
		
		Map<String, Object> rs =  memberservice.doJoin(param);
		
		model.addAttribute("alertMs", (String)rs.get("alertMs"));
		model.addAttribute("reDirectUrl", (String)rs.get("reDirectUrl"));
		model.addAttribute("historyBack", rs.get("historyBack"));
		
		return "./common/redirect";
	}
}
