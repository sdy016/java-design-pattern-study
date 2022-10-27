package com.study.designpatterns.command.receiver;

public class LightReceiver {

    private String location;

    public LightReceiver(String feature) {
        this.location = feature;
    }

    public void on() {
        System.out.println(location + "의 전등이 켜졌습니다.");
    }

    public void off() {
        System.out.println(location + "의 전등이 꺼졌습니다.");
    }
}
