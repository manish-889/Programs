package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {

	public static void sms(String message, String number) {
		try {
			String apiKey = "RLiYIsrlXpcNk5Z01QJ3uwM62Tfg4KVxHWvFmPGhoUOqyBDSE81iI4g87KSCjsOaVG0A9MpHc2zUwyFl";
			String sendId = "FSTSMS";
			message = URLEncoder.encode(message, "UTF-8");
			String language = "english";

			String route = "p";

			String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&sender_id=" + sendId
					+ "&message=" + message + "&language=" + language + "&route=" + route + "&numbers=" + number;

			URL url = new URL(myUrl);

			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			con.setRequestMethod("GET");

			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			System.out.println("Wait..............");

			int code = con.getResponseCode();

			System.out.println("Response code : " + code);

			StringBuffer response = new StringBuffer();

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				response.append(line);
			}

			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Program started.....");

		SendSms.sms("this message using java code ..." , "9429228211");

	}
}
