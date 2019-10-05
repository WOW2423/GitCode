package com.enter.entercustomerservice;

import com.enter.entercustomerservice.controller.BadReportController;
import com.enter.entercustomerservice.controller.FeedbackController;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterCustomerServiceApplicationTests {
	@Autowired
	private BadReportController badReportController;
	@Autowired
	private FeedbackController feedbackController;

	@Test
	public void contextLoads() throws IOException, MyException {

		String tracker  = EnterCustomerServiceApplicationTests.class.getResource("/tracker.conf").getPath();
		ClientGlobal.init(tracker);

		TrackerClient trackerClient =new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();

		StorageClient storageClient = new StorageClient(trackerServer,null);

		String filename = "D:/123.jpg";
		String[] uploadInfos = storageClient.upload_file(filename, "jpg", null);
		String url = "http://106.15.248.81";

		for (String uploadInfo: uploadInfos) {
			url += "/"+uploadInfo;
		}

		System.out.println(url);

    }

/*    @Test
	public void test() throws Exception {
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		feedbackDTO.setId(2);
		feedbackDTO.setContent("asd312123");
		feedbackDTO.setPhoneNumber("1312123123");
		feedbackDTO.setProjectType("feedback");
		feedbackDTO.setWechatNumber("qwe1qwe23");
		feedbackController.deleteFeedback(feedbackDTO);
	}*/
}
