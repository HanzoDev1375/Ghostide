package ir.ninjacoder.prograsssheet.deepseek.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.deepseek.adapter.ChatHistoryDrawerAdapter;
import ir.ninjacoder.prograsssheet.deepseek.database.ChatDatabaseHelper;
import ir.ninjacoder.prograsssheet.deepseek.manager.ChatHistoryManager;
import ir.ninjacoder.prograsssheet.deepseek.setting.PrefManager;
import java.util.List;

public class DeepSeekActivity extends AppCompatActivity
    implements ChatFragment.ChatFragmentListener {

  private DrawerLayout drawerLayout;
  private Toolbar toolbar;
  private RecyclerView drawerChatsRecyclerView;
  private TextView drawerEmptyText;
  private MaterialButton navNewChatButton;
  private MaterialButton navSettingsButton;
  private MaterialButton navClearAllButton;
  public static final String EXSTRAKEYCHAT = "chat";
  private ChatHistoryDrawerAdapter drawerAdapter;
  private ChatHistoryManager historyManager;
  private ActionBarDrawerToggle drawerToggle;
  private ChatFragment chatFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_deepseek);

    initViews();
    setupToolbar();
    setupDrawer();

    historyManager = ChatHistoryManager.getInstance(this);

    if (savedInstanceState == null) {
      loadChatFragment();
    }

    checkApiKeyOnFirstRun();
  }

  private void initViews() {
    drawerLayout = findViewById(R.id.drawerLayout);
    toolbar = findViewById(R.id.toolbar);
    drawerChatsRecyclerView = findViewById(R.id.drawerChatsRecyclerView);
    drawerEmptyText = findViewById(R.id.drawerEmptyText);
    navNewChatButton = findViewById(R.id.navNewChatButton);
    navSettingsButton = findViewById(R.id.navSettingsButton);
    navClearAllButton = findViewById(R.id.navClearAllButton);
  }

  private void setupToolbar() {
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setHomeButtonEnabled(true);
    }
  }

  private void setupDrawer() {
    drawerToggle =
        new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
    drawerLayout.addDrawerListener(drawerToggle);
    drawerToggle.syncState();

    // Load chat history when drawer opens
    drawerLayout.addDrawerListener(
        new DrawerLayout.SimpleDrawerListener() {
          @Override
          public void onDrawerOpened(View drawerView) {
            loadChatHistory();
          }
        });

    // Setup RecyclerView
    drawerChatsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    drawerAdapter = new ChatHistoryDrawerAdapter();
    drawerAdapter.setOnChatClickListener(
        new ChatHistoryDrawerAdapter.OnChatClickListener() {
          @Override
          public void onChatClick(ChatDatabaseHelper.ChatInfo chat) {
            drawerLayout.closeDrawer(GravityCompat.START);
            if (chatFragment != null) {
              chatFragment.loadChat(chat.id);
              drawerAdapter.setSelectedChat(chat.id);
              updateToolbarTitle(chat.title);
            }
          }

          @Override
          public void onChatDelete(ChatDatabaseHelper.ChatInfo chat) {
            confirmDeleteChat(chat);
          }
        });
    drawerChatsRecyclerView.setAdapter(drawerAdapter);

    // Setup buttons
    navNewChatButton.setOnClickListener(
        v -> {
          drawerLayout.closeDrawer(GravityCompat.START);
          if (chatFragment != null) {
            chatFragment.startNewChat();
          }
        });

    navSettingsButton.setOnClickListener(
        v -> {
          drawerLayout.closeDrawer(GravityCompat.START);
          if (chatFragment != null) {
            chatFragment.showSettings();
          }
        });

    navClearAllButton.setOnClickListener(
        v -> {
          drawerLayout.closeDrawer(GravityCompat.START);
          confirmDeleteAllChats();
        });
  }

  private void confirmDeleteChat(ChatDatabaseHelper.ChatInfo chat) {
    new MaterialAlertDialogBuilder(this)
        .setTitle("حذف چت")
        .setMessage("آیا از حذف این چت اطمینان دارید؟")
        .setPositiveButton(
            "حذف",
            (dialog, which) -> {
              historyManager.deleteChat(chat.id);
              loadChatHistory();

              String currentChatId = historyManager.getCurrentChatId();
              if (currentChatId == null || currentChatId.equals(chat.id)) {
                if (chatFragment != null) {
                  chatFragment.startNewChat();
                }
                updateToolbarTitle("DeepSeek Chat");
              }

              Toast.makeText(this, "چت حذف شد", Toast.LENGTH_SHORT).show();
            })
        .setNegativeButton("لغو", null)
        .show();
  }

  private void confirmDeleteAllChats() {
    new MaterialAlertDialogBuilder(this)
        .setTitle("حذف همه چت ها")
        .setMessage("آیا از حذف تمام چت ها اطمینان دارید؟")
        .setPositiveButton(
            "حذف همه",
            (dialog, which) -> {
              historyManager.deleteAllChats();
              loadChatHistory();

              if (chatFragment != null) {
                chatFragment.startNewChat();
              }
              updateToolbarTitle("DeepSeek Chat");

              Toast.makeText(this, "همه چت ها حذف شدند", Toast.LENGTH_SHORT).show();
            })
        .setNegativeButton("لغو", null)
        .show();
  }

  private void loadChatFragment() {
    chatFragment = new ChatFragment();
    chatFragment.setChatFragmentListener(this);
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fragmentContainer, chatFragment)
        .commit();
    loadChatByIntent();
  }

  void loadChatByIntent() {
    var fr = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
    if (fr instanceof ChatFragment) {
      if (getIntent().hasExtra(EXSTRAKEYCHAT)) {
        ((ChatFragment) fr).setMassges(EXSTRAKEYCHAT);
      }
    }
  }

  private void loadChatHistory() {
    List<ChatDatabaseHelper.ChatInfo> chats = historyManager.getAllChats();

    if (drawerAdapter != null) {
      drawerAdapter.setChats(chats);
    }

    if (chats == null || chats.isEmpty()) {
      drawerEmptyText.setVisibility(View.VISIBLE);
      drawerChatsRecyclerView.setVisibility(View.GONE);
    } else {
      drawerEmptyText.setVisibility(View.GONE);
      drawerChatsRecyclerView.setVisibility(View.VISIBLE);
    }

    String currentChatId = historyManager.getCurrentChatId();
    if (currentChatId != null && drawerAdapter != null) {
      drawerAdapter.setSelectedChat(currentChatId);
    }
  }

  private void updateToolbarTitle(String title) {
    if (getSupportActionBar() != null) {
      if (title != null && !title.isEmpty()) {
        getSupportActionBar().setTitle(title);
      } else {
        getSupportActionBar().setTitle("DeepSeek Chat");
      }
    }
  }

  private void checkApiKeyOnFirstRun() {
    PrefManager prefManager = PrefManager.getInstance(this);
    if (!prefManager.hasApiKey()) {
      Toast.makeText(this, "لطفاً API Key را در تنظیمات وارد کنید", Toast.LENGTH_LONG).show();
    }
  }

  @Override
  public void onChatSaved() {
    loadChatHistory();
    String currentChatId = historyManager.getCurrentChatId();
    if (currentChatId != null && drawerAdapter != null) {
      drawerAdapter.setSelectedChat(currentChatId);
    }
    updateToolbarTitle(historyManager.getCurrentChatTitle());
  }

  @Override
  public void onChatLoaded(String chatId, String title) {
    loadChatHistory();
    if (drawerAdapter != null) {
      drawerAdapter.setSelectedChat(chatId);
    }
    updateToolbarTitle(title);
  }

  @Override
  public void onNewChatStarted() {
    if (drawerAdapter != null) {
      drawerAdapter.setSelectedChat(null);
    }
    updateToolbarTitle("DeepSeek Chat");
    loadChatHistory();
  }

  @Override
  public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else if (chatFragment != null && chatFragment.hasMessages()) {
      new MaterialAlertDialogBuilder(this)
          .setTitle("خروج از برنامه")
          .setMessage("آیا مطمئن هستید میخواهید خارج شوید؟")
          .setPositiveButton("بله", (dialog, which) -> finish())
          .setNegativeButton("خیر", null)
          .show();
    } else {
      super.onBackPressed();
    }
  }
}
