
package com.abhiremix.admin;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.net.Uri;
import android.content.Intent;

public class MainActivity extends Activity {
    WebView webView;
    ValueCallback<Uri[]> fileCallback;
    static final int FILE_PICKER = 1001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView view,
                ValueCallback<Uri[]> callback,
                FileChooserParams params) {
                fileCallback = callback;
                startActivityForResult(
                    params.createIntent(), FILE_PICKER);
                return true;
            }
        });

        webView.loadUrl("file:///android_asset/admin.html");
    }

    @Override
    protected void onActivityResult(int requestCode,
        int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_PICKER && fileCallback != null) {
            fileCallback.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode, data));
            fileCallback = null;
        }
    }
}
