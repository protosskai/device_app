package com.kotarou.devicemanage.entity;

public class Operation {
    private String OperationType;
    private String Operation;

    public Operation() {

    }

    public Operation(String OperationType, String Operation) {
        this.OperationType = OperationType;
        this.Operation = Operation;
    }

    public String getOperationType() {
        return OperationType;
    }

    public void setOperationType(String operationType) {
        OperationType = operationType;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }
}
