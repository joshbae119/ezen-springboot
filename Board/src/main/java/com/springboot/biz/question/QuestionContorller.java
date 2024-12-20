package com.springboot.biz.question;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.biz.answer.AnswerForm;
import com.springboot.biz.user.SiteUser;
import com.springboot.biz.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionContorller {
	
	private final QuestionService questionService;
	private final UserService userService;
	
	//페이지네이션
	@GetMapping("/list")
	public String list(Model model,
	                   @RequestParam(value = "page", defaultValue = "0") int page) {
	    Page<Question> paging = this.questionService.getList(page);
	    model.addAttribute("paging", paging);
	    return "question_list";
	}
	
	//유효성검사 하는 메소드
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, 
			BindingResult bindingResult, Principal principal) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}
	
//	//유효성검사 안하는 메소드
//	@PostMapping("/create")
//	public String questionCreate(@RequestParam(value= "subject") String subject,
//			@RequestParam(value = "content") String content) {
//		//질문을 저장 실행 후 생성
//		this.questionService.create(subject, content);
//		return "redirect:/question/list";
//	}
	


	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	
		
	
	

}
