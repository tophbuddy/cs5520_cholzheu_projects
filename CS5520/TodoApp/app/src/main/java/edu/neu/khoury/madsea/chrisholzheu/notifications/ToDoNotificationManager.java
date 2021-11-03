package edu.neu.khoury.madsea.chrisholzheu.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import edu.neu.khoury.madsea.chrisholzheu.Constants;
import edu.neu.khoury.madsea.chrisholzheu.MainActivity;
import edu.neu.khoury.madsea.chrisholzheu.R;

public class ToDoNotificationManager extends Worker {

    public ToDoNotificationManager(@NonNull Context appContext, @NonNull WorkerParameters parameters) {
        super(appContext, parameters);
    }

    @NonNull
    @Override
    public Result doWork() {
        createNotificationChannel();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(), 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(getApplicationContext(), Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getInputData().getString(Constants.TODO_TITLE))
                .setContentText(getInputData().getString(Constants.TODO_DETAILS))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
//                .setVibrate(new long[0]);
        NotificationManagerCompat.from(getApplicationContext())
                .notify(getInputData().getInt(Constants.TODO_ID, 0), builder.build());
        return Result.success();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            CharSequence name = getApplicationContext().getString(R.string.channel_name);
            String description =  getApplicationContext().getString(R.string.channel_description);
            int importance = android.app.NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel =
                    new NotificationChannel(Constants.CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Add the channel
            NotificationManager toDoNotificationManager = getApplicationContext()
                    .getSystemService(NotificationManager.class);
            toDoNotificationManager.createNotificationChannel(channel);

        }
    }
}
