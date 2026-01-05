package com.linkedlist.singlylinkedlist.socialmediafriendconnections;


public class SocialMedia {

    private UserNode head;

   
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    public UserNode searchById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public UserNode searchByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // FRIEND OPERATIONS

    public void addFriendConnection(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        addFriend(u1, id2);
        addFriend(u2, id1);
    }

    private void addFriend(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;
    }

    public void removeFriendConnection(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        removeFriend(u1, id2);
        removeFriend(u2, id1);
    }

    private void removeFriend(UserNode user, int friendId) {
        FriendNode temp = user.friendHead, prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if (prev == null)
            user.friendHead = temp.next;
        else
            prev.next = temp.next;
    }

    /* ---------------- MUTUAL FRIENDS ---------------- */

    public void findMutualFriends(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Mutual Friends:");
        FriendNode f1 = u1.friendHead;

        while (f1 != null) {
            FriendNode f2 = u2.friendHead;
            while (f2 != null) {
                if (f1.friendId == f2.friendId)
                    System.out.println("Friend ID: " + f1.friendId);
                f2 = f2.next;
            }
            f1 = f1.next;
        }
    }

    /* ---------------- DISPLAY FRIENDS ---------------- */

    public void displayFriends(int userId) {
        UserNode user = searchById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendHead;
        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    /* ---------------- COUNT FRIENDS ---------------- */

    public void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }
}
