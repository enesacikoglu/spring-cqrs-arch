package com.byoskill.spring.cqrs.gate.impl.fakeapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.byoskill.spring.cqrs.api.CommandServiceSpec;
import com.byoskill.spring.cqrs.gate.api.Gate;

public class StringCommandHandler implements CommandServiceSpec<String, Integer> {
    private final List<String> commands = new ArrayList<>();

    private final Gate gate;

    @Autowired
    public StringCommandHandler(final Gate gate) {
	super();
	this.gate = gate;

    }

    @Override
    public Integer handle(final String command) {
	commands.add(command);
	gate.dispatchEvent("EVENT_" + command);
	return commands.size();
    }

}