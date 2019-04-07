package com.example.remember.ccs;

import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import com.alibaba.fastjson.JSONObject;
import com.example.remember.util.DataUtil;
import com.example.remember.util.SendThread;
import com.example.remember.util.RecieveThread;


public class TestClient {

    /**
     * 构造函数
     * @param host 要连接的服务端IP地址
     * @param port 要连接的服务端对应的监听端口
     * @throws Exception
     */
    public TestClient(String host, int port) throws Exception {
        // 与服务端建立连接
        this.socket = new Socket(host, port);
        System.out.println("Cliect[port:" + socket.getLocalPort() + "] 与服务端建立连接...");
    }

    private Socket socket;

    private Writer writer;

    public Socket getSocket(){
        return socket;
    }


    /**
     * 发送消息
     * @param msg
     * @throws Exception
     */
    public void send(String msg) throws Exception {
        // 建立连接后就可以往服务端写数据了
        if(writer == null) {
            writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        }
        writer.write(msg);
        writer.write("eof\n");
        writer.flush();// 写完后要记得flush
    }

    public void send(JSONObject json) throws IOException{
        Log.d(DataUtil.TAG, "user send");
        // 建立连接后就可以往服务端写数据了
        if(writer == null) {
            writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        }
        String jsonString = JSONObject.toJSONString(json);
        writer.write(jsonString);
        writer.write("eof\n");
        writer.flush();// 写完后要记得flush
    }

    /**
     * 接收消息
     * @throws Exception
     */
    public String receive() throws Exception {
        Log.d(DataUtil.TAG, "user receive");
        // 写完以后进行读操作
        Reader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
        // 设置接收数据超时间为10秒
        socket.setSoTimeout(10*1000);
        char[] chars = new char[64];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = reader.read(chars)) != -1) {
            sb.append(new String(chars, 0, len));
        }
        String jsonString = sb.toString();
        return jsonString;
//        intoPort(Integer.parseInt(json.getString("port")));

    }

    private void intoPort(int port){
        try {
            Socket s = new Socket("192.168.0.110", port);

            // 启动发送消息线程
            new SendThread(s).start();
            // 启动接受消息线程
            new RecieveThread(s).start();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
