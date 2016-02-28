package com.ibm.iotf.client.test;

import java.util.Properties;

import org.junit.Test;

import com.ibm.iotf.client.app.ApplicationClient;

public class TestPublish extends IIotFTestCase
{

    @Test
    public void testPublish() throws Exception
    {
        Properties opt = new Properties();
        ApplicationClient client = null;

        opt.put("auth-key", properties.getProperty("authKey"));
        opt.put("auth-token", properties.getProperty("authToken"));
        opt.put("id", properties.getProperty("id"));
        opt.put("auth-method", properties.getProperty("auth-method"));

        client = new ApplicationClient(opt);
        client.connect();
        client.publishEvent(properties.getProperty("deviceType"), properties.getProperty("deviceId"), properties.getProperty("event"), 0);

    }

}
