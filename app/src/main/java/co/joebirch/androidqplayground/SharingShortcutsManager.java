package co.joebirch.androidqplayground;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.Person;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides the Sharing Shortcuts items to the system.
 * <p>
 * Use the ShortcutManagerCompat to make it work on older Android versions
 * without any extra work needed.
 * <p>
 * Interactions with the ShortcutManager API can happen on any thread.
 */
public class SharingShortcutsManager {

    private static final int MAX_SHORTCUTS = 4;

    private static final String CATEGORY_TEXT_SHARE_TARGET =
            "co.joebirch.androidqplayground.category.TEXT_SHARE_TARGET";

    @SuppressLint("NewApi")
    public void pushDirectShareTargets(@NonNull Context context) {
        ArrayList<ShortcutInfoCompat> shortcuts = new ArrayList<>();

        // Category that our sharing shortcuts will be assigned to
        Set<String> contactCategories = new HashSet<>();
        contactCategories.add(CATEGORY_TEXT_SHARE_TARGET);

        // Adding maximum number of shortcuts to the list
        for (int id = 0; id < MAX_SHORTCUTS; ++id) {

            Intent staticLauncherShortcutIntent = new Intent(Intent.ACTION_DEFAULT);

            shortcuts.add(new ShortcutInfoCompat.Builder(context, Integer.toString(id))
                    .setShortLabel(String.valueOf(id))
                    .setIcon(IconCompat.createWithResource(context, R.drawable.ic_android_black_24dp))
                    .setIntent(staticLauncherShortcutIntent)
                    .setLongLived()
                    .setCategories(contactCategories)
                    .setPerson(new Person.Builder()
                            .setName(String.valueOf(id))
                            .build())
                    .build());
        }

        ShortcutManagerCompat.addDynamicShortcuts(context, shortcuts);
    }

    /**
     * Remove all dynamic shortcuts
     */
    public void removeAllDirectShareTargets(@NonNull Context context) {
        ShortcutManagerCompat.removeAllDynamicShortcuts(context);
    }
}