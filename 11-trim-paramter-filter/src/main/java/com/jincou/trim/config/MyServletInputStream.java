package com.jincou.trim.config;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *  自定义流
 * 
 * @author xub
 * @date 2022/10/24 下午4:11
 */
public class MyServletInputStream extends ServletInputStream {
    
    private ByteArrayInputStream bis;

    public MyServletInputStream(ByteArrayInputStream bis) {
        this.bis = bis;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener listener) {

    }

    @Override
    public int read() throws IOException {
        return bis.read();
    }
}
