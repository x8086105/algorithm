package com.example.socket.mutileChat;

import javax.annotation.security.RunAs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler2 implements Runnable {

    private AIOChatClient chatClient ;

    public UserInputHandler2(AIOChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String input = consoleReader.readLine();
                chatClient.send(input);
                if(chatClient.readyToQuit(input)){
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
