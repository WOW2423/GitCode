package com.enter.entercustomerservice;

import com.enter.entercustomerservice.controller.BadReportController;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
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

	@Test
	public void contextLoads() {
		BadReportDTO badReportDTO = new BadReportDTO();
		badReportDTO.setId(1);
		badReportController.deleteByPrimary(badReportDTO);
    }

}
