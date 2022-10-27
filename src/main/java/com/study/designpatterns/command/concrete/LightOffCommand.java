package com.study.designpatterns.command.concrete;

import com.study.designpatterns.command.Command;
import com.study.designpatterns.command.receiver.LightReceiver;

public class LightOffCommand implements Command {
    private LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
