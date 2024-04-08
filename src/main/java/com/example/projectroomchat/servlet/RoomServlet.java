package com.example.projectroomchat.servlet;

import com.example.projectroomchat.model.RoomChat;
import com.example.projectroomchat.service.ChatRoomService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {
    private ChatRoomService chatRoomService;

    @Override
    public void init() throws ServletException{
        super.init();
        chatRoomService = new ChatRoomService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            int maxMembers = Integer.parseInt(request.getParameter("maxMembers"));

            RoomChat roomChat = new RoomChat();
            roomChat.setName(name);
            roomChat.setMaxMembers(maxMembers);

            chatRoomService.getInstance();
            chatRoomService.createChatRoom(roomChat);

            response.getWriter().println("Chat room was created successfully");
        }catch (NumberFormatException e){
            response.getWriter().println("Invalid value for maxMembers");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
