package ir.ninjacoder.prograsssheet.deepseek.manager;

import android.content.Context;
import ir.ninjacoder.prograsssheet.deepseek.database.ChatDatabaseHelper;
import ir.ninjacoder.prograsssheet.deepseek.model.Message;
import java.util.List;

public class ChatHistoryManager {
    private static ChatHistoryManager instance;
    private final ChatDatabaseHelper dbHelper;
    private String currentChatId;
    private String currentChatTitle;
    
    private ChatHistoryManager(Context context) {
        this.dbHelper = new ChatDatabaseHelper(context.getApplicationContext());
    }
    
    public static synchronized ChatHistoryManager getInstance(Context context) {
        if (instance == null) {
            instance = new ChatHistoryManager(context);
        }
        return instance;
    }
    
    public void startNewChat() {
        currentChatId = null;
        currentChatTitle = null;
    }
    
    public void setCurrentChat(String chatId, String title) {
        this.currentChatId = chatId;
        this.currentChatTitle = title;
    }
    
    public String getCurrentChatId() {
        return currentChatId;
    }
    
    public String getCurrentChatTitle() {
        return currentChatTitle;
    }
    
    public void saveCurrentChat(List<Message> messages) {
        if (messages == null || messages.isEmpty()) return;
        
        String title = generateChatTitle(messages);
        
        if (currentChatId == null) {
            currentChatId = dbHelper.saveChat(title, messages);
            currentChatTitle = title;
        } else {
            dbHelper.updateChat(currentChatId, title, messages);
        }
    }
    
    public List<ChatDatabaseHelper.ChatInfo> getAllChats() {
        return dbHelper.getAllChats();
    }
    
    public List<Message> loadChat(String chatId) {
        List<Message> messages = dbHelper.getChatMessages(chatId);
        if (messages != null && !messages.isEmpty()) {
            // پیدا کردن عنوان چت
            List<ChatDatabaseHelper.ChatInfo> chats = getAllChats();
            for (ChatDatabaseHelper.ChatInfo chat : chats) {
                if (chat.id.equals(chatId)) {
                    currentChatId = chatId;
                    currentChatTitle = chat.title;
                    break;
                }
            }
        }
        return messages;
    }
    
    public void deleteChat(String chatId) {
        dbHelper.deleteChat(chatId);
        if (chatId.equals(currentChatId)) {
            currentChatId = null;
            currentChatTitle = null;
        }
    }
    
    public void deleteAllChats() {
        dbHelper.deleteAllChats();
        currentChatId = null;
        currentChatTitle = null;
    }
    
    private String generateChatTitle(List<Message> messages) {
        for (Message message : messages) {
            if ("user".equals(message.getRole()) && message.getContent() != null && !message.getContent().isEmpty()) {
                String content = message.getContent().trim();
                if (content.length() > 50) {
                    return content.substring(0, 47) + "...";
                }
                return content;
            }
        }
        return "چت جدید";
    }
}