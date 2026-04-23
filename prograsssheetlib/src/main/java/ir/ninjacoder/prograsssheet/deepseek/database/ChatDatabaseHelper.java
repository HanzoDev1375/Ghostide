package ir.ninjacoder.prograsssheet.deepseek.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ir.ninjacoder.prograsssheet.deepseek.model.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ChatDatabaseHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "deepseek_chats.db";
  private static final int DATABASE_VERSION = 1;
  private static final String TABLE_CHATS = "chats";
  private static final String TABLE_MESSAGES = "messages";

  private static final String COLUMN_ID = "id";
  private static final String COLUMN_CHAT_ID = "chat_id";
  private static final String COLUMN_TITLE = "title";
  private static final String COLUMN_CREATED_AT = "created_at";
  private static final String COLUMN_UPDATED_AT = "updated_at";
  private static final String COLUMN_ROLE = "role";
  private static final String COLUMN_CONTENT = "content";
  private static final String COLUMN_REASONING_CONTENT = "reasoning_content";
  private static final String COLUMN_TIMESTAMP = "timestamp";
  private static final String COLUMN_IS_ERROR = "is_error";
  private static final String COLUMN_IS_SEARCH_ENABLED = "is_search_enabled";
  private static final String COLUMN_FILE_NAMES = "file_names";

  private final Gson gson;

  public ChatDatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.gson = new Gson();
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String createChatsTable =
        "CREATE TABLE "
            + TABLE_CHATS
            + " ("
            + COLUMN_ID
            + " TEXT PRIMARY KEY,"
            + COLUMN_TITLE
            + " TEXT NOT NULL,"
            + COLUMN_CREATED_AT
            + " INTEGER NOT NULL,"
            + COLUMN_UPDATED_AT
            + " INTEGER NOT NULL)";
    db.execSQL(createChatsTable);

    String createMessagesTable =
        "CREATE TABLE "
            + TABLE_MESSAGES
            + " ("
            + COLUMN_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CHAT_ID
            + " TEXT NOT NULL,"
            + COLUMN_ROLE
            + " TEXT NOT NULL,"
            + COLUMN_CONTENT
            + " TEXT NOT NULL,"
            + COLUMN_REASONING_CONTENT
            + " TEXT,"
            + COLUMN_TIMESTAMP
            + " INTEGER NOT NULL,"
            + COLUMN_IS_ERROR
            + " INTEGER DEFAULT 0,"
            + COLUMN_IS_SEARCH_ENABLED
            + " INTEGER DEFAULT 0,"
            + COLUMN_FILE_NAMES
            + " TEXT,"
            + "FOREIGN KEY("
            + COLUMN_CHAT_ID
            + ") REFERENCES "
            + TABLE_CHATS
            + "("
            + COLUMN_ID
            + ") ON DELETE CASCADE)";
    db.execSQL(createMessagesTable);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHATS);
    onCreate(db);
  }

  public String saveChat(String title, List<Message> messages) {
    String chatId = String.valueOf(System.currentTimeMillis());
    long now = System.currentTimeMillis();

    SQLiteDatabase db = this.getWritableDatabase();
    db.beginTransaction();
    try {
      ContentValues chatValues = new ContentValues();
      chatValues.put(COLUMN_ID, chatId);
      chatValues.put(COLUMN_TITLE, title);
      chatValues.put(COLUMN_CREATED_AT, now);
      chatValues.put(COLUMN_UPDATED_AT, now);
      db.insert(TABLE_CHATS, null, chatValues);

      for (Message message : messages) {
        ContentValues messageValues = new ContentValues();
        messageValues.put(COLUMN_CHAT_ID, chatId);
        messageValues.put(COLUMN_ROLE, message.getRole());
        messageValues.put(COLUMN_CONTENT, message.getContent());
        messageValues.put(COLUMN_REASONING_CONTENT, message.getReasoningContent());
        messageValues.put(COLUMN_TIMESTAMP, message.getTimestamp());
        messageValues.put(COLUMN_IS_ERROR, message.isError() ? 1 : 0);
        messageValues.put(COLUMN_IS_SEARCH_ENABLED, message.isSearchEnabled() ? 1 : 0);

        if (message.getFileNames() != null && !message.getFileNames().isEmpty()) {
          String fileNamesJson = gson.toJson(message.getFileNames());
          messageValues.put(COLUMN_FILE_NAMES, fileNamesJson);
        }

        db.insert(TABLE_MESSAGES, null, messageValues);
      }

      db.setTransactionSuccessful();
      return chatId;
    } finally {
      db.endTransaction();
    }
  }

  public void updateChat(String chatId, String title, List<Message> messages) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.beginTransaction();
    try {
      ContentValues chatValues = new ContentValues();
      chatValues.put(COLUMN_TITLE, title);
      chatValues.put(COLUMN_UPDATED_AT, System.currentTimeMillis());
      db.update(TABLE_CHATS, chatValues, COLUMN_ID + " = ?", new String[] {chatId});

      db.delete(TABLE_MESSAGES, COLUMN_CHAT_ID + " = ?", new String[] {chatId});

      for (Message message : messages) {
        ContentValues messageValues = new ContentValues();
        messageValues.put(COLUMN_CHAT_ID, chatId);
        messageValues.put(COLUMN_ROLE, message.getRole());
        messageValues.put(COLUMN_CONTENT, message.getContent());
        messageValues.put(COLUMN_REASONING_CONTENT, message.getReasoningContent());
        messageValues.put(COLUMN_TIMESTAMP, message.getTimestamp());
        messageValues.put(COLUMN_IS_ERROR, message.isError() ? 1 : 0);
        messageValues.put(COLUMN_IS_SEARCH_ENABLED, message.isSearchEnabled() ? 1 : 0);

        if (message.getFileNames() != null && !message.getFileNames().isEmpty()) {
          String fileNamesJson = gson.toJson(message.getFileNames());
          messageValues.put(COLUMN_FILE_NAMES, fileNamesJson);
        }

        db.insert(TABLE_MESSAGES, null, messageValues);
      }

      db.setTransactionSuccessful();
    } finally {
      db.endTransaction();
    }
  }

  public List<ChatInfo> getAllChats() {
    List<ChatInfo> chats = new ArrayList<>();
    SQLiteDatabase db = this.getReadableDatabase();

    String query = "SELECT * FROM " + TABLE_CHATS + " ORDER BY " + COLUMN_UPDATED_AT + " DESC";
    Cursor cursor = db.rawQuery(query, null);

    if (cursor.moveToFirst()) {
      do {
        String id = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
        long createdAt = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_CREATED_AT));
        long updatedAt = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_UPDATED_AT));

        ChatInfo chatInfo = new ChatInfo(id, title, createdAt, updatedAt);
        chats.add(chatInfo);
      } while (cursor.moveToNext());
    }
    cursor.close();

    return chats;
  }

  public List<Message> getChatMessages(String chatId) {
    List<Message> messages = new ArrayList<>();
    SQLiteDatabase db = this.getReadableDatabase();

    String query =
        "SELECT * FROM "
            + TABLE_MESSAGES
            + " WHERE "
            + COLUMN_CHAT_ID
            + " = ? "
            + " ORDER BY "
            + COLUMN_TIMESTAMP
            + " ASC";
    Cursor cursor = db.rawQuery(query, new String[] {chatId});

    if (cursor.moveToFirst()) {
      do {
        String role = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ROLE));
        String content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT));
        String reasoningContent =
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REASONING_CONTENT));
        long timestamp = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_TIMESTAMP));
        boolean isError = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IS_ERROR)) == 1;
        boolean isSearchEnabled =
            cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IS_SEARCH_ENABLED)) == 1;
        String fileNamesJson = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FILE_NAMES));

        Message message = new Message(role, content);
        message.setReasoningContent(reasoningContent);
        message.setTimestamp(timestamp);
        message.setError(isError);
        message.setSearchEnabled(isSearchEnabled);

        if (fileNamesJson != null && !fileNamesJson.isEmpty()) {
          Type listType = new TypeToken<List<String>>() {}.getType();
          List<String> fileNames = gson.fromJson(fileNamesJson, listType);
          message.setFileNames(fileNames);
        }

        messages.add(message);
      } while (cursor.moveToNext());
    }
    cursor.close();

    return messages;
  }

  public void deleteChat(String chatId) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_CHATS, COLUMN_ID + " = ?", new String[] {chatId});
  }

  public void deleteAllChats() {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_CHATS, null, null);
  }

  public static class ChatInfo {
    public String id;
    public String title;
    public long createdAt;
    public long updatedAt;

    public ChatInfo(String id, String title, long createdAt, long updatedAt) {
      this.id = id;
      this.title = title;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
    }

    public String getDisplayTitle() {
      if (title == null || title.isEmpty()) {
        return "چت جدید";
      }
      if (title.length() > 30) {
        return title.substring(0, 27) + "...";
      }
      return title;
    }
  }
}
