/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package signupandlogin;

import javax . swing.*;
import java.util.ArrayList;

public class Message {
    static ArrayList<String> messages = new ArrayList<>();
    static int messageCounter = 0;
    static JTextArea textArea = new JTextArea(20, 40);
    public static String generateMessageID() {
        return String.valueOf((long) (Math.random() * 1_000_000_0000L));
    }

    public static boolean checkRecipientCell(String number) {
        return number.startsWith("+27") && number.length() <= 13;
    }

    public static String createMessageHash(String id, int msgNum, String message) {
        String[] words = message.trim().split("\\s+");
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();
        return first + id.substring(0, 2) + ":" + msgNum + ":" + last;
    }

    public static String sendMessageFlow() {
        String recipient = JOptionPane.showInputDialog("Enter recipient phone number:");
        if (!checkRecipientCell(recipient)) {
            return "Invalid number.";
        }

        String messageText = JOptionPane.showInputDialog("Enter message (max 250 chars):");
        if (messageText.length() > 250)
            return "Message exceeds 250 characters.";

        String messageID = generateMessageID();
        String hash = createMessageHash(messageID, messageCounter, messageText);

        String[] options = {"Send", "Disregard", "Store"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose action:",
                "Message Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0 -> {
                messages.add("Message ID: " + messageID +
                        "\nHash: " + hash +
                        "\nTo: " + recipient +
                        "\nMessage: " + messageText);
                messageCounter++;
                return "Message sent!";
            }
            case 1 -> {
                return "Message disregarded.";
            }
            case 2 -> {
                return "Message stored (future feature).";
            }
            default -> {
                return "No action taken.";
            }
        }
    }

    public static int returnTotalMessages() {
        return messageCounter;
    }
  
         public static void initiateQuickChatFlow() {
        // Display the welcome message in the JTextArea
        textArea.setText("Welcome to Quick Chat! Please follow the steps to send a message.\n");

        // Show the JTextArea in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Quick Chat", JOptionPane.INFORMATION_MESSAGE);

        // Continue with other steps or flow...
        // No need to return anything
    }
}
       

        
    

