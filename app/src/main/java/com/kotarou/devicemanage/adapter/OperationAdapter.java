package com.kotarou.devicemanage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.entity.Operation;

import java.util.List;

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.ViewHolder> {

    private List<Operation> mOperationList;

    public OperationAdapter(List<Operation> operationList) {
        mOperationList = operationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_operation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Operation operation = mOperationList.get(position);
        holder.operationType.setText(operation.getOperationType());
        holder.operation.setText(operation.getOperation());
    }

    @Override
    public int getItemCount() {
        return mOperationList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView operationType;
        TextView operation;

        public ViewHolder(View view) {
            super(view);
            operationType = view.findViewById(R.id.operation_type_txt);
            operation = view.findViewById(R.id.operation_txt);
        }
    }
}
