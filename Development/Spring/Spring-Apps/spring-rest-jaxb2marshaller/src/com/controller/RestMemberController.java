package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import com.model.Member;
import com.model.Members;
import com.service.MemberService;

@Controller
public class RestMemberController {

    private final MemberService memberService;

    @Autowired
    public RestMemberController(MemberService memberService) {
        super();
        this.memberService=memberService;
    }
    
    /* http://localhost:8080/spring-rest-jaxb2marshaller/members1.xml */
    @RequestMapping("/members1")
    @ResponseBody
    public Members getRestMembers() {
        Members members = new Members();
        members.addMembers(memberService.findAll());
        return members;
    }
    
    /*	http://localhost:8080/spring-rest-jaxb2marshaller/member1/3.xml	*/
    @RequestMapping("/member1/{id}")
    @ResponseBody
    public Member getRestMembers(@PathVariable("id") long id) {
    	System.out.println("RestMemberController.getRestMembers()");
        Member member = memberService.find(id);
        return member;
    }
    
    /* @ResponseBody doesn't require configuration in spring-servlet for view & jaxb2marshaller */
    @RequestMapping("/members2")
    @ResponseBody
    public Members getRestMembersWithResponseBody() {
    	Members members = new Members();
    	members.addMembers(memberService.findAll());
    	return members;
    }
    
    @RequestMapping("/member2/{memberid}")
    public ResponseEntity<Member> getMemberWithResponseEntity(@PathVariable("memberid") long memberId)	{
    	System.out.println("RestMemberController.getMemberWithResponseEntity()");
    	Member member = memberService.find(memberId);
    	if(member != null)	{
    		return new ResponseEntity<Member>(member, HttpStatus.OK);
    	}
    	return new ResponseEntity(HttpStatus.NOT_FOUND);
    }   
    
    @RequestMapping(value="/members3")
    @ResponseBody
    public Members getRestMembersXml(Model model)	{
    	System.out.println("RestMemberController.getRestMembersXml()");
    	Members members = new Members();
    	members.addMembers(memberService.findAll());
    	return members;
    }
    
}
