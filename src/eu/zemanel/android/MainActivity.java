package eu.zemanel.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// final Button button = (Button) findViewById(R.id.contactButton);
		// button.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		// // Perform action on click
		// }
		// });
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		Log.d("MainActivity", item.toString());
		Intent intent;
		Uri uri;
		switch (item.getItemId()) {
		case R.id.menu_option_blog:
			uri = Uri.parse("http://www.zemanel.eu");
			intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(Intent.createChooser(intent, "Browse http://www.zemanel.eu"));
			//startActivity(intent);
			return true;
		case R.id.menu_option_email:
			intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("plain/text");
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"zemanel@zemanel.eu"});			
			//startActivity(intent);
			startActivity(Intent.createChooser(intent, "E-mail zemanel@zemanel.eu"));
			return true;
		case R.id.menu_option_twitter:
			uri = Uri.parse("http://www.twitter.com/zemanel");
			intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(Intent.createChooser(intent, "Browse http://www.twitter.com/zemanel"));
			return true;
		case R.id.menu_option_facebook:
			uri = Uri.parse("http://www.facebook.com/ELZeManel");
			intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(Intent.createChooser(intent, "Browse http://www.facebook.com/ELZeManel"));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.contact_menu, menu);
		return true;
	}
}