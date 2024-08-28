package DesignPattern.MediatorDesignPattern.ChatRoomApplication;

public class ChatMediatorDemo {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatRoom();

        User user1 = new ChatUser(chatMediator, "Alice");
        User user2 = new ChatUser(chatMediator, "Bob");
        User user3 = new ChatUser(chatMediator, "Charlie");
        User user4 = new ChatUser(chatMediator, "Diana");

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);
        chatMediator.addUser(user4);

        user1.sendMessage("Hello, everyone!");
        System.out.println("----------------------");
        user3.sendMessage("Good, morning!");
    }
}
