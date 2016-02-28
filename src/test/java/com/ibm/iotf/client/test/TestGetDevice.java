package com.ibm.iotf.client.test;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import com.ibm.iotf.client.api.Device;
import com.ibm.iotf.client.api.DeviceFactory;

public class TestGetDevice extends IIotFTestCase
{

    public void testGetDevice()
    {

        Properties opt = new Properties();

        opt.put("authKey", properties.getProperty("authKey"));
        opt.put("authToken", properties.getProperty("authToken"));

        DeviceFactory factory = new DeviceFactory(opt);

        Device device = factory.getDevice(properties.getProperty("deviceType"), properties.getProperty("deviceId"));
        if (device != null)
            System.out.println("Get Device...  " + device);
        else
            System.out.println("Not able to get Device... ");

        assertEquals("Getdevices", 0, factory.getDevices());

    }

}
