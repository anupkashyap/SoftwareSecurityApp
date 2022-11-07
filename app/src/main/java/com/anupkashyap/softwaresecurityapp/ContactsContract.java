package com.anupkashyap.softwaresecurityapp;

import android.net.Uri;

public final class ContactsContract {


    public static final String AUTHORITY =
            "com.anupkashyap.softwaresecurity.provider";

    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY);

}
