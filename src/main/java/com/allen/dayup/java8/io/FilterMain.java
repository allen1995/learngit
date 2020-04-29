package com.allen.dayup.java8.io;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: allen
 * @Date: 2020-04-06 12:46
 * @Description:
 */
public class FilterMain {

    public static void main(String[] args) throws IOException {
        byte[] data = "Hllo World".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(data);

        try ( CountInputStream inputStream = new CountInputStream(bis)) {
            int n;
            while ( (n = inputStream.read()) != -1 ){
                System.out.println((char)n);
            }
            System.out.println("总共读取：" + inputStream.getByteCount() + "bytes");
        }

    }

    static class CountInputStream extends FilterInputStream {

        private int count = 0;

        /**
         * Creates a <code>FilterInputStream</code>
         * by assigning the  argument <code>in</code>
         * to the field <code>this.in</code> so as
         * to remember it for later use.
         *
         * @param in the underlying input stream, or <code>null</code> if
         *           this instance is to be created without an underlying stream.
         */
        protected CountInputStream(InputStream in) {
            super(in);
        }

        public int getByteCount() {
            return this.count;
        }

        @Override
        public int read() throws IOException {
            int n;
            n = in.read();
            if( n != -1 ){
                count++;
            }

            return n;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            int n = super.read(b, off, len);
            this.count += n;
            return n;
        }
    }
}
