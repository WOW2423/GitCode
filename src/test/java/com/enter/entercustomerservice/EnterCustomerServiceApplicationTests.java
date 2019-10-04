package com.enter.entercustomerservice;

import com.enter.entercustomerservice.controller.BadReportController;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.entity.BadReport;
import com.enter.entercustomerservice.service.BadReportService;
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
	private BadReportService badReportService;

	@Test
	public void test() throws Exception{
		/*
		BadReportDTO aa = new BadReportDTO();
		aa.setContent("asd");
		aa.setId(3);
		aa.setImgPath("C://");
		aa.setProjectType(333);
		aa.setWechatNumber("zjw");
		*/
		try {
			//badReportController.addOne(aa);添加一个数据

			//badReportController.deleteOne(aa);删除一个数据

			//aa.setProjectType(6);
			//badReportController.updateOne(aa);//更新某个数据的值

			//aa.setId(3);
			//badReportController.getOne(aa);//根据ID获取某个数据

			//badReportController.getAll();//显示数据库中所有数据

		} catch (Exception e) {
			e.printStackTrace();
		}





	}

}
