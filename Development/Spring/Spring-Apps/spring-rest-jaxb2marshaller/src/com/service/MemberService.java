package com.service;

import java.util.Collection;

import com.model.Member;

public interface MemberService {
	Collection<Member> findAll();

	Member find(long id);
}
