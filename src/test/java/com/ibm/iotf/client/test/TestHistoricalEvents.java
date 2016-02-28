package com.ibm.iotf.client.test;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import com.ibm.iotf.client.api.DeviceFactory;
import com.ibm.iotf.client.api.HistoricalEvent;

public class TestHistoricalEvents extends IIotFTestCase
{

    public void testHistoricalEvent()
    {
        Properties opt = new Properties();

        opt.put("authKey", properties.getProperty("authKey"));
        opt.put("authToken", properties.getProperty("authToken"));
        DeviceFactory factory = new DeviceFactory(opt);

        HistoricalEvent[] event = factory.getHistoricalEvents(properties.getProperty("deviceType"), properties.getProperty("deviceId"));

        assertEquals("HistoricalEvents received", event.length > 0, factory.getHistoricalEvents(properties.getProperty("deviceType"), properties.getProperty("deviceId")));
        assertEquals("No HistoricalEvents received", event.length <= 0, factory.getHistoricalEvents(properties.getProperty("deviceType"), properties.getProperty("deviceId")));

    }

}
