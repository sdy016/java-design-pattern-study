package com.study.designpatterns;

import com.study.designpatterns.command.Command;
import com.study.designpatterns.command.CommandPattern;
import com.study.designpatterns.execute.Execute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);
		Execute commonExecute = new Execute(new CommandPattern());
		commonExecute.mainExecute();
	}

}
