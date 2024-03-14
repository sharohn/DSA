package designpatterns.behavioral;

public class MediatorDesignPatter {
    public static void main(String[] args) {
        // Create a chat room (mediator)
        ChatMediator chatRoom = new ChatRoom("New Joiners");

        // Create users (colleagues) and join the chat room
        User user1 = new ChatUser("Alice");
        User user2 = new ChatUser("Bob");
        User user3 = new ChatUser("Charlie");

        chatRoom.sendMessage(user1, "Hi! This is Alice");
        chatRoom.sendMessage(user2, "Hi everyone!");
        chatRoom.sendMessage(user3, "Hi everyone!");
    }
}


// Mediator interface
interface ChatMediator {
    void sendMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    String roomName;

    ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("New message from " + user.getName() + " in room : " + roomName);
        System.out.println(user.getName() + ": " + message);
    }
}

// Colleague interface
interface User {
    String getName();
}

// Concrete Colleague
class ChatUser implements User {
    private final String name;

    ChatUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

