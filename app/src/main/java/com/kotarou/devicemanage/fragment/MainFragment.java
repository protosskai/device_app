package com.kotarou.devicemanage.fragment;

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
import com.kotarou.devicemanage.adapter.OperationAdapter;
import com.kotarou.devicemanage.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment {

    private List<Operation> operationList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView barName = view.findViewById(R.id.bar_name);
        barName.setText("主页");
        initOperations();
        RecyclerView recyclerView = view.findViewById(R.id.operation_record_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        OperationAdapter operationAdapter = new OperationAdapter(operationList);
        recyclerView.setAdapter(operationAdapter);
        return view;
    }

    private void initOperations() {
        for (int i = 0; i < 20; i++) {
            operationList.add(new Operation("借出", "张凯"));
        }
    }


}
