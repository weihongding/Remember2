package com.example.remember.listener;

import android.app.Activity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.remember.R;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.example.remember.util.UserSetting;

public class MyLocationListener implements BDLocationListener {

    private Activity mActivity;
    private MapView mapView;
    private BaiduMap baiduMap;
    private boolean isFirstLocate = true;

    public MyLocationListener(Activity activity){
        mActivity = activity;
        mapView = activity.findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
    }


    @Override
    public void onReceiveLocation(final BDLocation location) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                UserSetting.UserLocation_country=location.getCountry();
                UserSetting.UserLocation_province=location.getProvince();
                UserSetting.UserLocation_city=location.getCity();
                UserSetting.UserLocation_district=location.getDistrict();
                UserSetting.UserLocation_street=location.getStreet();
//                地图数据显示
//                StringBuilder currentPosition = new StringBuilder();
//                currentPosition.append("纬度：").append(location.getLatitude()).append("\n");
//                currentPosition.append("经线：").append(location.getLongitude()).append("\n");
//                currentPosition.append("国家：").append(UserSetting.UserLocation_country).append("\n");
//                currentPosition.append("省：").append(UserSetting.UserLocation_province).append("\n");
//                currentPosition.append("市：").append(UserSetting.UserLocation_city).append("\n");
//                currentPosition.append("区：").append(UserSetting.UserLocation_district).append("\n");
//                currentPosition.append("街道：").append(UserSetting.UserLocation_street).append("\n");
//                currentPosition.append("定位方式：");
//                if (location.getLocType() == BDLocation.TypeGpsLocation){
//                    currentPosition.append("GPS");
//                }else if(location.getLocType()==BDLocation.TypeNetWorkLocation){
//                    currentPosition.append("网络");
//                }
//                TextView positionText = (TextView)mActivity.findViewById(R.id.text_position);
//                positionText.setText(currentPosition);

                if (location.getLocType() == BDLocation.TypeGpsLocation||location.getLocType()==BDLocation.TypeNetWorkLocation){
                    navigateTo(location);
                }

            }
        });
    }

    private void navigateTo(BDLocation location){
        if (isFirstLocate){
            LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;
        }
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.latitude(location.getLatitude());
        locationBuilder.longitude(location.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }



}
