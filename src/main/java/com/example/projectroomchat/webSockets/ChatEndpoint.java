package com.example.projectroomchat.webSockets;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {
    @OnOpen
    public void onOpen(Session session){
// TODO: handle opening of new session
    }

    @OnMessage
    public void onMessage(String message, Session session){
// TODO: handle receiving a message
    }

    @OnClose
    public void onClose(Session session){
// TODO: handle closing of a session
    }
}
