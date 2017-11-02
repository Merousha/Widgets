package com.example.vanil_singh.widgets;

/**
 * Created by Vanil-Singh on 9/17/2017.
 */

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class WidgetActivity extends AppWidgetProvider {
    DateFormat df = new SimpleDateFormat( "hh:mm:ss" );
    public void onUpdate(Context context, AppWidgetManager
            appWidgetManager, int [] appWidgetIds) {
        final int N = appWidgetIds. length ;
        Log.i( "ExampleWidget" , "Updating widgets " +
                Arrays.asList(appWidgetIds));

// provider
        for ( int i = 0 ; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
// Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, MainActivity. class );
            PendingIntent pendingIntent =
                    PendingIntent.getActivity(context, 0 , intent, 0 );

// to the button
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout. widget_layout );
            views.setOnClickPendingIntent(R.id. button , pendingIntent);
// To update a label
            views.setTextViewText(R.id. widget1label , df .format( new
                    Date()));

// widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
