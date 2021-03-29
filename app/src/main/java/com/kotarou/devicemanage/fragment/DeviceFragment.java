package com.kotarou.devicemanage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.activity.DeviceInfoActivity;
import com.kotarou.devicemanage.adapter.DeviceAdapter;
import com.kotarou.devicemanage.entity.DeviceInfo;
import com.kotarou.devicemanage.presenter.DevicePresenter;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import com.kotarou.devicemanage.adapter.RecyclerItemClickListener;

public class DeviceFragment extends BaseFragment {

    private List<DeviceInfo> deviceInfoList = new ArrayList<>();
    private DevicePresenter devicePresenter = new DevicePresenter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device, container, false);
        TextView barName = view.findViewById(R.id.bar_name);
        barName.setText("设备列表");
        initDeviceList(view);
        return view;
    }

    public void initDeviceList(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.device_info_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DeviceAdapter deviceAdapter = new DeviceAdapter(deviceInfoList);
        recyclerView.setAdapter(deviceAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DeviceInfoActivity.class);
                DeviceInfo deviceInfo = deviceInfoList.get(position);
                intent.putExtra("deviceInfo", deviceInfo);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        devicePresenter.getDeviceList(new Observer<DeviceInfo>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull DeviceInfo deviceInfo) {
                deviceInfoList.add(deviceInfo);
                deviceAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
