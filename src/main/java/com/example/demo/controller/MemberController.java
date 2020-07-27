package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("/member/login")
	public String showLogin() {	
		
		return "./member/Login";
	}
	
	@RequestMapping("/member/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param, HttpSession session, Model model) {
		
		Map<String, Object> rs =  memberservice.getMemberbyIdPw(param);
		
		model.addAttribute("alertMs", (String)rs.get("alertMs"));
		model.addAttribute("reDirectUrl", (String)rs.get("reDirectUrl"));
		
		if (rs.get("member") != null) {
			Member member = (Member)rs.get("member");
			session.setAttribute("loginedMemberId", member.getId());
			session.setAttribute("loginedMember", member);
		}
		
		return "/common/redirect";
	}
	
	@RequestMapping("/member/logout")
	public String doLogout(HttpSession session, Model model) {
		
		session.removeAttribute("loginedMemberId");
		session.removeAttribute("loginedMember");

		model.addAttribute("alertMsg", "로그아웃 되었습니다.");
		model.addAttribute("locationReplace", "/");
		
		return "/common/redirect";
	}
	
	@RequestMapping("/member/Join")
	public String showJoin() {
		
		return "/member/Join";
	}
	
	@RequestMapping("/member/doJoin")
	public String doJoin(@RequestParam Map<String, Object> param, Model model) {
		
		Map<String, Object> rs =  memberservice.doJoin(param);
		
		model.addAttribute("alertMs", (String)rs.get("alertMs"));
		model.addAttribute("reDirectUrl", (String)rs.get("reDirectUrl"));
		model.addAttribute("historyBack", rs.get("historyBack"));
		
		return "/common/redirect";
	}
}
