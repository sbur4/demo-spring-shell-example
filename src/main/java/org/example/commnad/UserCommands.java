package org.example.commnad;

import org.example.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserCommands {
    private final Storage storage;

    @Autowired
    public UserCommands(Storage storage) {
        this.storage = storage;
    }

    @ShellMethod("Displays Hello, World!")
    public String greet() {
        return "Hello, World!";
    }

    @ShellMethod("Adds a new user to the storage.")
    public String adduser(@ShellOption(value = {"-N", "--name"}) String name) {
        storage.addUser(name);
        return "Added user: " + name;
    }

    @ShellMethod("Finds a user by name.")
    public String finduser(@ShellOption String name) {
        return storage.findUserByName(name);
    }
}