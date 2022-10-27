package com.study.designpatterns.command.concrete;

import com.study.designpatterns.command.Command;
import com.study.designpatterns.command.receiver.BlueToothSpeakerReceiver;

public class SpeakerOnCommand implements Command {

    private BlueToothSpeakerReceiver blueToothSpeaker;

    public SpeakerOnCommand(BlueToothSpeakerReceiver blueToothSpeaker) {
        this.blueToothSpeaker = blueToothSpeaker;
    }

    @Override
    public void execute() {
        blueToothSpeaker.on();
        blueToothSpeaker.connectWithPhone();
        blueToothSpeaker.playingMusic();
    }

    @Override
    public void undo() {
        blueToothSpeaker.off();
    }
}


