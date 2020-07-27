package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Map<String, Object> getMemberbyIdPw(Map<String, Object> param) {
	
		
		String loginId = (String)param.get("loginId");
		String loginPw = (String)param.get("loginPw");
		
		Map<String, Object> rs = new HashMap<>();
		
		Member member = memberDao.findById(loginId);
		
		rs.put("member", member);

		if (member != null) {
			if (!member.getLoginPw().equals(loginPw)) {
				rs.put("alertMs", "비밀번호틀림.");
				rs.put("reDirectUrl", "./Join");
			}else {
				rs.put("alertMs", member.getLoginId() + " 님 환영합니다.");
				rs.put("reDirectUrl", "/");
			}
		}
		else {
			rs.put("alertMs", "회원이 아님");
			rs.put("reDirectUrl", "./Join");
		}
		return rs;
	}

	@Override
	public Map<String, Object> doJoin(Map<String, Object> param) {
		
		String loginId = (String)param.get("loginId");
		
		Map<String, Object> rs = new HashMap<>();
		
		Member member = memberDao.findById(loginId);
		
		if (member != null) {
			rs.put("alertMs", "아이디중복.");
			rs.put("historyBack", "true");
		}
		else {
			memberDao.dojoin(param);
			rs.put("alertMs", "축하 ");
			rs.put("reDirectUrl", "/member/login");
		}
		
		return rs;
	}
	
}
