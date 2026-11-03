ABHI REMIX ADMIN — Android Studio project

This project wraps your supplied admin.html in an Android WebView app.
It enables JavaScript, session storage, internet access, and image/MP3 file selection.

BUILD APK:
1. Install Android Studio on a computer.
2. Open this folder: ABHI_REMIX_Admin_App
3. Allow Android Studio to install the Android Gradle Plugin / SDK if prompted.
4. Connect an Android phone with USB debugging enabled, or use an emulator.
5. Select Build > Build Bundle(s) / APK(s) > Build APK(s).
6. The debug APK will be created at:
   app/build/outputs/apk/debug/app-debug.apk

IMPORTANT:
- This is an Android Studio source project ZIP, not a compiled APK.
- A compiled APK cannot be produced in this environment because Android SDK/Gradle
  build tools are not installed.
- The app loads your existing admin.html locally. Supabase still requires internet.
- Keep your Supabase project policies and admin authentication secure.
