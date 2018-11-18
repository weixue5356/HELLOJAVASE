package com.atguigu;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 演示通信协议
 */
public class TestTCP01 {


    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("127.0.0.1", 9091);
            outputStream = socket.getOutputStream();
            outputStream.write("我是客户端,请多多关照! ".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 服务端
     */
    @Test
    public void service() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(9091);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
                System.out.println("我是服务端接收到" + accept.getInetAddress().getHostAddress() + "的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
