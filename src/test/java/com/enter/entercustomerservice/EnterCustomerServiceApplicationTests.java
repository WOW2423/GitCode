package com.enter.entercustomerservice;

import com.enter.entercustomerservice.controller.BadReportController;
import com.enter.entercustomerservice.controller.FeedbackController;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterCustomerServiceApplicationTests {
	@Autowired
	private BadReportController badReportController;
	@Autowired
	private FeedbackController feedbackController;

	@Test
	public void contextLoads() {
		BadReportDTO badReportDTO = new BadReportDTO();
		badReportDTO.setId(1);
    }

    @Test
	public void test() throws Exception {
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		feedbackDTO.setId(2);
		feedbackDTO.setContent("asd312123");
		feedbackDTO.setPhoneNumber("1312123123");
		feedbackDTO.setProjectType("feedback");
		feedbackDTO.setWechatNumber("qwe1qwe23");
		feedbackController.deleteFeedback(feedbackDTO);
	}
}
