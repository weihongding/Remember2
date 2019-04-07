package com.example.remember.ccs;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.example.remember.util.DataUtil;
import com.example.remember.util.UserSetting;


public class Client {

    private static String str=null;

    public static void sendMessage(final com.alibaba.fastjson.JSONObject json){

        new Thread(new Runnable() {
            public void run() {
                try {
                    TestClient client = new TestClient("192.168.0.110", 10086);
                    Log.d(DataUtil.TAG+"Client", json.toString());
                    client.send(json);
                    str = client.receive();
                    Log.d(DataUtil.TAG+"Client", str);
                    client.getSocket().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true){
            if (str!=null){
                Log.d(DataUtil.TAG+"While", str);
                JSONObject resultjson = JSONObject.parseObject(str);
                Log.d(DataUtil.TAG+"resultjson", resultjson.toString());
                UserSetting.user.setId(Integer.parseInt(resultjson.getString("id")));
                UserSetting.user.setName(resultjson.getString("name"));
                break;
            }
        }

    }

}
