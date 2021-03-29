package com.kotarou.devicemanage.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.entity.DeviceInfo;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {

    private List<DeviceInfo> mDeviceList;

    public DeviceAdapter(List<DeviceInfo> deviceInfoList) {
        mDeviceList = deviceInfoList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_device, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DeviceInfo deviceInfo = this.mDeviceList.get(position);
        holder.deviceName.setText(deviceInfo.getDeviceName());
        holder.isAllowLend.setText(deviceInfo.getIsAllowLend() == 1 ? "是" : "否");
    }

    @Override
    public int getItemCount() {
        return mDeviceList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView deviceName;
        TextView isAllowLend;

        public ViewHolder(View view) {
            super(view);
            deviceName = view.findViewById(R.id.device_name_txt);
            isAllowLend = view.findViewById(R.id.is_allow_lend_txt);
        }

    }
}


