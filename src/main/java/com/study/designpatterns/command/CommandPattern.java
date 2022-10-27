package com.study.designpatterns.command;
import com.study.designpatterns.MainInterface;
import com.study.designpatterns.command.concrete.*;
import com.study.designpatterns.command.invoker.RemoteControlInvoker;
import com.study.designpatterns.command.receiver.BlueToothSpeakerReceiver;
import com.study.designpatterns.command.receiver.LightReceiver;

public class CommandPattern implements MainInterface {
    @Override
    public void mainExecute() {
        //0. Command : 명령에 필요한 책임들을 설정한다.

        //1. invoker 선언 (주문서)
        //- 명령이 들어 있으며 excute(), undo() 등 메서드를 호출함으로써
        //  커맨드 객체에게 특정 작업을 수행해달라는 요구를 하게 된다.
        RemoteControlInvoker remoteControlInvoker = new RemoteControlInvoker();

        //2. receiver 선언 (기본 동작)
        //- 요구 사항을 수행하기 위해 처리해야 할 일을 가지고 있다.
        //- ConcreteCommand에서 Receiver를 가지고 있으며 ConcreteCommand는 명령에 따라 Receiver의 기능을 수행한다.
        LightReceiver roomLight = new LightReceiver("안방");
        BlueToothSpeakerReceiver blueToothSpeaker = new BlueToothSpeakerReceiver("거실");

        //3. concrete 선언
        //- 특정 행동과 리시버 사이를 연결해 준다.
        //- Invoker에서 excute(), undo() 등 호출을 통해 요청이 들어오면
        //  ConcreteCommand에 있는 리시버 객체의 메서드를 호출해 작업을 처리하게 된다.
        LightOnCommand lightOnCommand = new LightOnCommand(roomLight);
        LightOffCommand lightOffCommand = new LightOffCommand(roomLight);
        SpeakerOnCommand speakerOnCommand = new SpeakerOnCommand(blueToothSpeaker);
        SpeakerOffCommand speakerOffCommand = new SpeakerOffCommand(blueToothSpeaker);
        MacroCommand macroOnCommand = new MacroCommand(lightOnCommand, speakerOnCommand);
        MacroCommand macroOffCommand = new MacroCommand(lightOffCommand, speakerOffCommand);

        //4. invoker에 각 command 주입

        //command 0번째에 lightOnCommand / lightOffCommand 커맨드 주입
        remoteControlInvoker.setCommand(0, lightOnCommand, lightOffCommand);
        //command 1번째에 speakerOnCommand / speakerOffCommand 커맨드 주입
        remoteControlInvoker.setCommand(1, speakerOnCommand, speakerOffCommand);
        //command 2번째에 macroOnCommand / macroOffCommand 커맨드 주입
        remoteControlInvoker.setCommand(2, macroOnCommand, macroOffCommand);

        //command 0번째 ON
        remoteControlInvoker.onButtonClick(0);

        //command 1번째 ON
        remoteControlInvoker.onButtonClick(1);

        //command 2번째 OFF
        remoteControlInvoker.offButtonClick(2);

        //command undo
        remoteControlInvoker.undoButtonClick();



        //5. 요점
        //- 커맨드 패턴을 통해 클라이언트는 구체적인 구현 사항을 알 필요가 없어졌다.
        //- 단지 명령어들을 세팅하기만 하고 버튼을 조작하기만 하면 된다.

        //“명령"을 오브젝트로서 표현하는 것으로
        // 명령의 이력을 취하거나 명령의 재실행을 실시할 수가 있다.
        // 또, 새로운 “명령"을 추가하고 싶은 경우는
        // Command 인터페이스를 구현한 클래스를 작성하면 되는 것만이므로,
        // 기능 확장이 실시하기 쉬워진다.
    }
}
