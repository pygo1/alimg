package com.alimg.blog.dto;

public class DeleteExecution {

    private int state;

    private String stateInfo;

    public DeleteExecution() {
    }

    public DeleteExecution(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "DeleteExecution{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
