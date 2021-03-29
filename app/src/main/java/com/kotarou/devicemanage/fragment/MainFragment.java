package com.kotarou.devicemanage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.activity.CaptureActivity;
import com.kotarou.devicemanage.adapter.OperationAdapter;
import com.kotarou.devicemanage.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    private final String TAG = "com.kotarou.devicemanage.fragment.MainFragment";

    private List<Operation> operationList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView barName = view.findViewById(R.id.bar_name);
        barName.setText("主页");
        initEvent(view);
        initOperations(view);
        return view;
    }

    // 初始化UI事件
    private void initEvent(View view) {
        ImageButton scanBtn = view.findViewById(R.id.scan_btn);
        scanBtn.setOnClickListener(this);
    }

    // 初始化操作列表
    private void initOperations(View view) {
        for (int i = 0; i < 20; i++) {
            operationList.add(new Operation("借出", "张凯"));
        }
        RecyclerView recyclerView = view.findViewById(R.id.operation_record_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        OperationAdapter operationAdapter = new OperationAdapter(operationList);
        recyclerView.setAdapter(operationAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 扫码按钮
            case R.id.scan_btn:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent);
                break;
        }
    }
}
