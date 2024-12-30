package com.springboot.biz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.biz.answer.AnswerRepository;
import com.springboot.biz.question.QuestionService;

@SpringBootTest
class BoardApplicationTests {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerRepository answerRepository;
	        
	@Test
	void contextLoads() {
		
//		//DB에 데이터 대량 넣기
//		for (int i=0; i<=300 ; i++) {
//			String subject = String.format("테스트 데이트입니다[%03d]", i);
//			String content = "내용 없음";
//			this.questionService.create(subject, content);
//		}
		
		
//		Question q1 = new Question();
//		q1.setSubject("국가");
//		q1.setContent("미국이 있습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);

		//데이터모두지우기
//		this.questionRepository.deleteAll();
//		
//		Question q2 = new Question();
//		q2.setSubject("스프링 부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요? ");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
		
//		List<Question> all = this.questionRepository.findAll();
//		System.out.println("총 객체수" + all.size());
//		
//		assertEquals(4, all.size());
//		Question q = all.get(0);
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
//		System.out.println(q.getCreateDate());
//		System.out.println(q.getId());
//		
//		assertEquals("게시판이 무엇인가요?", q.getSubject());
		
//		Question q = this.questionRepository.findBySubject("주세");
		//Question q = this.questionRepository.findBySubjectAndContent("주제", "내용");
//		System.out.println(q.getId());
//		System.out.println(q.getCreateDate());
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
		
//		//assertequal
//		assertEquals(1, this.questionRepository.count());
//		System.out.println("삭제전 게시판 개수": + this.questionRepository.count());
		
		//FindBysubject
		
//		//Like
//		List<Question> qList = this.questionRepository.findBySubjectLike("게시판%");
//		Question q = qList.get(0);
//		System.out.println(q.getSubject());
//		System.out.println(q.getId());
//		
//		assertEquals("게시판이 무엇인가요?", q.getSubject());
		
		//insert into 테이블 values 필드값
		
//		//update
//		Optional<Question> oq = this.questionRepository.findById(9);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
		
//		//assertequals
//		assertEquals(6, this.questionRepository.count());
//		System.out.println("삭제전 게시판 개수: " + this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(12);
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		System.out.println("삭제전 게시판 개수: " + this.questionRepository.count());
		
		/////////////// 답변 //////////////////////
//		Optional<Question> oq = this.questionRepository.findById(11);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		System.out.println("질문글 존재??  : " + q.getId());
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//		
//		Optional<Answer> oa = this.answerRepositiry.findById(2);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		System.out.println("답변 글 번호 : " + a.getQuestion().getId());
		
	}

}
