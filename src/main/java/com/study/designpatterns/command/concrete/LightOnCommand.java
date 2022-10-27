package com.study.designpatterns.command.concrete;

import com.study.designpatterns.command.Command;
import com.study.designpatterns.command.receiver.LightReceiver;

public class LightOnCommand implements Command {

    private LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
