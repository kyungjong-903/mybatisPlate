package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	Map<String, Object> getMemberbyIdPw(Map<String, Object> param);

	Map<String, Object> doJoin(Map<String, Object> param);
	
}
