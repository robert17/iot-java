package com.ibm.iotf.client.test;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.Test;

import com.ibm.iotf.client.api.DeviceFactory;

public class TestDeleteDevices extends IIotFTestCase
{
    @Test
    public void testDeleteDevice()
    {


            Properties opt = new Properties();

            opt.put("authKey", properties.getProperty("authKey"));
            opt.put("authToken", properties.getProperty("authToken"));

            DeviceFactory factory = new DeviceFactory(opt);

            assertEquals("Device didn't exist...", true, factory.deleteDevice(properties.getProperty("deviceType"), properties.getProperty("deviceId")));
            assertEquals("Device deregistered....", false, factory.deleteDevice(properties.getProperty("deviceType"), properties.getProperty("deviceId")));


    }

}
