package DesignPattern.MediatorDesignPattern.ChatRoomApplication;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }
    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            // Message should not be received by the user who is sending it
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
