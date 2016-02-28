package com.ibm.iotf.client.test;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import com.ibm.iotf.client.api.Device;
import com.ibm.iotf.client.api.DeviceFactory;

public class TestGetDevices extends IIotFTestCase
{

    public void testGetDevices()
    {

        Properties opt = new Properties();

        opt.put("authKey", properties.getProperty("authKey"));
        opt.put("authToken", properties.getProperty("authToken"));

        DeviceFactory factory = new DeviceFactory(opt);

        Device[] device = factory.getDevices();
        if (device != null)
            System.out.println("Get Devices  " + device);
        else
            System.out.println("Not able to get Device ");

        assertEquals("Get Devices", true, factory.getDevices() != null);

    }

}
