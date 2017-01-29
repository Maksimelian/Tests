package package1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestIpAddress {

    IpAddress ip1,ip2;

    @Test(expected = RuntimeException.class)
    public void testCreateIp_text() {
        ip1 = new IpAddress("просто текст");
    }

    @Test(expected = RuntimeException.class)
    public void testCreateIp_format() {
        ip1 = new IpAddress("127,0,0,0");
    }

    @Test(expected = RuntimeException.class)
    public void testCreateIp_format2() {
        ip1 = new IpAddress("127.0.0.0.0");
    }

    @Test(expected = RuntimeException.class)
    public void testCreateIp_format3() {
        ip1 = new IpAddress("256.0.0.1");
    }

    @Test(expected = RuntimeException.class)
    public void testCreateIp_empty() {
        ip1 = new IpAddress("");
    }


    @Test
    public void testCompareTo_ip1_More_ip2() {

        ip1 = new IpAddress("127.0.0.9");
        ip2 = new IpAddress("127.0.0.8");

        assertEquals(1, ip1.compareTo(ip2));
    }

    @Test
    public void testCompareTo_ip1_Less_ip2() {

        ip1 = new IpAddress("127.0.1.8");
        ip2 = new IpAddress("127.0.1.9");

        assertEquals(-1, ip1.compareTo(ip2));
    }

    @Test
    public void testCompareTo_ip1_Equals_ip2() {

        ip1 = new IpAddress("111.15.11.5");
        ip2 = new IpAddress("111.15.11.5");

        assertEquals(0, ip1.compareTo(ip2));
    }

    @Test
    public void testInc()  {

        ip1 = new IpAddress("127.0.0.8");
        ip2 = new IpAddress("127.0.0.9");

        ip1.inc();

        assertEquals(0,ip2.compareTo(ip1));
    }

    @Test(expected = RuntimeException.class)
    public void testInc_max()  {

        ip1 = new IpAddress("255.255.255.255");
        ip1.inc();

    }

}