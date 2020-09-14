package com.allen.dayup.java8.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @Auther: allen
 * @Date: 2020-09-13 17:03
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FileInputStramTest {

    private FileInputStream in;

    @Before
    public void init() throws FileNotFoundException {

        in = new FileInputStream("test.txt");
    }

    @Test
    @DisplayName("返回流中首字符的ascii码值")
    public void testRead() throws IOException {
        int num = in.read();

        assertEquals(105, num);
    }

    @Test
    public void testReadWithArgs() throws IOException {
        byte[] bytes = new byte[1024];
        int n = in.read(bytes);
        assertEquals("i am allen", new String(bytes,0,n, "utf-8"));
    }

    @Test
    public void  testskip() throws IOException {
        in.skip(2);
        assertEquals(97, in.read());
    }

    @Test
    public void testAvaiable() throws IOException {
        assertEquals(10, in.available());
    }


    @After
    public void destroy() throws IOException {
        in.close();
    }
}
