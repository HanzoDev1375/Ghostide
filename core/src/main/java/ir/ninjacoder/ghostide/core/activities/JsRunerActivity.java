package ir.ninjacoder.ghostide.core.activities;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;


public class JsRunerActivity extends BaseCompat {

    private String para = "";

    private WebView consoleView;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.jsruner);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {
        consoleView = findViewById(R.id.consoleView);
        consoleView.getSettings().setJavaScriptEnabled(true);
        consoleView.getSettings().setSupportZoom(true);

    }

    private void initializeLogic() {

        WebSettings settings = this.consoleView.getSettings();
        settings.setJavaScriptEnabled(true);
        consoleView.setWebChromeClient(new WebChromeClient());

        para =
                "<html>\n	<head>\n    <style>\n    body {\n        background-color : black;\n    }\n    </style>\n	</head>\n	<body>\n		<script src=\"eruda.js\">\n		</script>\n		<script>\n		eruda.init(\n                     {\n           defaults: {\n    displaySize: 100,\n    transparency: 1,\n    theme: 'Dracula'\n                      }\n                      })\n		</script>\n		<script>eruda.show()</script>\n		\n		<script>\n        eruda.remove('info')\n		eruda.remove('network')\n		eruda.remove('elements')\n		eruda.remove('resources')\n		eruda.remove('sources')\n		eruda.remove('snippets')\n		</script>\n		\n		\n\n	<script>let consoles = eruda.get('console');\n        11\n        \n       var now =  new Date();\n       var hour = now.getHours();\n       var minute = now.getMinutes();\n       console.log(\"Task Runed in Time \" + hour + \" : \",minute) \n</script>\n	</body>\n</html>\n";
        para = para.replace("11", getIntent().getStringExtra("sendCode"));
        consoleView.loadDataWithBaseURL(
                "file:///android_asset/eruda.js", para, "text/html", "utf-8", (String) null);
    }
}
