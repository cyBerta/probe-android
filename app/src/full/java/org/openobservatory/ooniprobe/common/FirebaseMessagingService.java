package org.openobservatory.ooniprobe.common;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

import java.util.Map;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
	private static final String TAG = "FCM";

	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		// TODO(developer): Handle FCM messages here.
		// Not getting messages here? See why this may be: https://goo.gl/39bRNJ
		Log.d(TAG, "Message from: " + remoteMessage.getFrom());
		Log.d(TAG, "Message data payload: " + remoteMessage.getData());
		Map<String, String> params = remoteMessage.getData();
		// Check if message contains a data payload.
		if (remoteMessage.getData().size() > 0) {
			try {
				//TODO-FUTURE we can use click_action instead of type
				JSONObject data = new JSONObject(params.toString());
			} catch (Exception e) {
				System.out.println("JSONException " + e);
			}
		}
	}

	@Override public void onNewToken(String token) {
		((Application) getApplicationContext()).getPreferenceManager().setToken(token);
	}
}
