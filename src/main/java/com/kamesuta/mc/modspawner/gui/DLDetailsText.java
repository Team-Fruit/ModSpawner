package com.kamesuta.mc.modspawner.gui;

import javax.swing.JTextArea;

public class DLDetailsText extends JTextArea {

	String server = "";
	String speed = "";
	String timeremaining = "";
	String timeremainingAll = "";
	String status = "";

	public void updateDetails(String key, String value)
	{
		this.setText(new StringBuilder()
		.append(server)
		.append("速度 : " + speed)
		.append("現在のダウンロードの推定残り時間 : " + timeremaining)
		.append("すべてのダウンロードの推定残り時間 : " + timeremainingAll)
		.append(status).toString()
		);
	}
}
