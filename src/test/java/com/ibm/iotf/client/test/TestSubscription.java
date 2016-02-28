package com.ibm.iotf.client.test;

import java.util.Properties;

import org.junit.Test;

import com.ibm.iotf.client.app.ApplicationClient;
import com.ibm.iotf.client.app.ApplicationStatus;
import com.ibm.iotf.client.app.Command;
import com.ibm.iotf.client.app.DeviceStatus;
import com.ibm.iotf.client.app.Event;
import com.ibm.iotf.client.app.EventCallback;
import com.ibm.iotf.client.app.StatusCallback;

public class TestSubscription extends IIotFTestCase{

	@Test
    public void testSubscribe() throws Exception{
		Properties opt = new Properties();
		ApplicationClient client = null;

		opt.put("auth-key", properties.getProperty("authKey"));
		opt.put("auth-token", properties.getProperty("authToken"));
		opt.put("id", properties.getProperty("id"));
		opt.put("auth-method", properties.getProperty("auth-method"));


		client = new ApplicationClient(opt);
		client.connect();


		client.setEventCallback(new MyEventCallback());
		client.setStatusCallback(new MyStatusCallback());
		client.subscribeToDeviceStatus();


		}

	private class MyEventCallback implements EventCallback {

		@Override
		public void processEvent(Event e) {
			System.out.println("Event " + e.getPayload());
		}

		@Override
		public void processCommand(Command cmd) {
			System.out.println("Command " + cmd.getPayload());
		}



	}

	private class MyStatusCallback implements StatusCallback {

		@Override
		public void processApplicationStatus(ApplicationStatus status) {
			System.out.println("Application Status = " + status.getPayload());
		}

		@Override
		public void processDeviceStatus(DeviceStatus status) {
			System.out.println("Device Status = " + status.getPayload());
		}
	}



}
