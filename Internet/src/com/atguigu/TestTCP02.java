package com.atguigu;

import com.sun.corba.se.spi.orbutil.fsm.FSM;
import org.junit.Test;
import sun.misc.OSEnvironment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 从客户端发送文件给服务端,服务端收到后发送信息给客户端,并关闭相应的连接
 */
public class TestTCP02 {

    /**
     * 客户端
     * @throws Exception
     */
    @Test
    public void client () throws Exception{

        Socket socket = new Socket("127.0.0.1", 8989);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = fis = new FileInputStream(new File("1.jpg"));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        byte[] b1 = new byte[1024];
        int len2 = 0;
        while ((len2 = is.read(b1)) != -1) {
            System.out.println(new String(b1,0,len2));
        }


        socket.close();
         os.close();
         fis.close();


    }

    /**
     * 服务端
     */
     @Test
    public  void service () throws  Exception{
         ServerSocket serverSocket = new ServerSocket(8989);
         Socket accept = serverSocket.accept();
         InputStream is = accept.getInputStream();

         FileOutputStream fos = new FileOutputStream(new File("2.jpg"));

         byte[] b = new byte[1024];
         int len = 0;
         while ((len = is.read(b)) != -1) {
             fos.write(b,0,len);
         }
         OutputStream os = accept.getOutputStream();

         os.write("发送成功!".getBytes());

          serverSocket.close();
          accept.close();
          is.close();
          os.close();
          fos.close();

         
     }



}
