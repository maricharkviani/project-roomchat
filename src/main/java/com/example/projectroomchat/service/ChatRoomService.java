package com.example.projectroomchat.service;

import com.example.projectroomchat.model.RoomChat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ChatRoomService {
    private static final ChatRoomService instance = new ChatRoomService();

    private EntityManagerFactory entityManagerFactory;
    public ChatRoomService(){
        entityManagerFactory = Persistence.createEntityManagerFactory("RoomChatPU");
    }

    public void createChatRoom(String name, int maxMembers){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        RoomChat roomChat = new RoomChat();
        roomChat.setName(name);
        roomChat.setMaxMembers(maxMembers);

        entityManager.persist(roomChat);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static ChatRoomService getInstance() {
        return instance;
    }

    public List<RoomChat> getAllRoomChats(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<RoomChat> query = entityManager.createQuery("SELECT c FROM RoomChat c", RoomChat.class);
        List<RoomChat> roomChats = query.getResultList();
        return roomChats;
    }

    public void createChatRoom(RoomChat roomChat) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(roomChat);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
