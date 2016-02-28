package com.ibm.iotf.client.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

public class IIotFTestCase
{
    private static final org.apache.log4j.Logger l                    = LogManager.getLogger(IIotFTestCase.class.getName());

    public static final String                   TEST_PROPERTIES_FILE = "/test.properties";
    public Properties                            properties;

    @Before
    public void loadResources() throws IOException
    {
        InputStream inputStream = getClass().getResource(TEST_PROPERTIES_FILE).openStream();
        properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

    }

    @Test
    public void testLoadResources() throws IOException
    {
        assertTrue(properties.keySet().size() > 0);

    }

}
