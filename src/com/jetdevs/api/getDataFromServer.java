package com.jetdevs.api;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class getDataFromServer {

	public JSONObject validateUser(JSONObject obj) {
		StringBuilder response = new StringBuilder();
		InputStream is = null;
		try {
			URL u = new URL("http://private-222d3-homework5.apiary-mock.com/api/login");
			byte[] postData = new String(obj.toString()).getBytes("UTF-8");
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setRequestMethod("POST");
			huc.setDoOutput(true);
			huc.setDoInput(true);
			huc.setRequestProperty("Content-Type", "application/json");
			huc.setRequestProperty("charset", "utf-8");
			huc.setRequestProperty("Content-Length", String.valueOf(postData.length));
			try (DataOutputStream os = new DataOutputStream(huc.getOutputStream())) {
				os.write(postData);
			}
			is = huc.getInputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) != -1) {
				response.append(new String(buffer, 0, length));
			}
			return new JSONObject(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
