package com.deepsoft.haolifa.aspect;


import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * 解决多次调用requestBody不能读取的问题
 */
class BufferedServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    public BufferedServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream is = request.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buff[] = new byte[1024];
        int read;
        while ((read = is.read(buff)) > 0) {
            baos.write(buff, 0, read);
        }
        body = baos.toByteArray();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }


}