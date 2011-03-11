package net.luniks.android.inetify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

public class ConnectivityActionReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, final Intent intent) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		boolean enabled  = sharedPreferences.getBoolean("settings_enabled", false);
		if(enabled) {
			NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
			if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI && networkInfo.isConnected()) {
				Log.d(Inetify.LOG_TAG, String.valueOf(networkInfo));
				context.startService(new Intent("net.luniks.android.inetify.InetifyService"));
			}
		}
	}

}