package com.allen.dayup.java8.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * @Auther: allen
 * @Date: 2020-09-13 17:55
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ByteArrayInputStramTest {

    private ByteArrayInputStream in;

    @Before
    public void init(){
        //通过byte数组初始化流，内容：i am allen
        byte[] inputs = new byte[]{105,32,97,109,32,97,108,108,101,110};
        in = new ByteArrayInputStream(inputs);
    }

    @Test
    public void testByteArrayInputStream() throws IOException {
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);

        assertEquals("i am allen",new String(bytes,0,len));
    }
}
