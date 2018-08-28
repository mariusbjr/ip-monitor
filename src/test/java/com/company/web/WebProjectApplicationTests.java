package com.company.web;

import com.company.web.controller.AppController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*
 In jUnit usually i'm using Mockito to mock the services, etc..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebProjectApplicationTests {

	@Autowired
	AppController appController;

	@Test
	public void testCleanIp() {
		String ip = "124";
		String result = appController.checkIp(ip);
		Assert.assertEquals("Clean IP, proceed with the workflow!", result);
	}

	@Test
	public void testBlacklistedIp() {
		String ip = "111.32.4.5";
		String result = appController.checkIp(ip);
		Assert.assertEquals("Ip blacklisted!", result);
	}

	@Test
	public void testAddIp() {
		String ip = "111";
		String result = appController.checkIp(ip);
		Assert.assertEquals("Clean IP, proceed with the workflow!", result);

		appController.addIp(ip);
		String addResult = appController.checkIp(ip);
		Assert.assertEquals("Ip blacklisted!", addResult);
	}

}
