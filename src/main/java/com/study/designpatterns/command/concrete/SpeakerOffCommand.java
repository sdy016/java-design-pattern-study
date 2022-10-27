package com.study.designpatterns.command.concrete;

import com.study.designpatterns.command.Command;
import com.study.designpatterns.command.receiver.BlueToothSpeakerReceiver;

public class SpeakerOffCommand implements Command {

    private BlueToothSpeakerReceiver blueToothSpeaker;

    public SpeakerOffCommand(BlueToothSpeakerReceiver blueToothSpeaker) {
        this.blueToothSpeaker = blueToothSpeaker;
    }

    @Override
    public void execute() {
        blueToothSpeaker.off();
    }

    @Override
    public void undo() {
        blueToothSpeaker.on();
        blueToothSpeaker.connectWithPhone();
        blueToothSpeaker.playingMusic();
    }
}
