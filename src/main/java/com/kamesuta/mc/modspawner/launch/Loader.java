package com.kamesuta.mc.modspawner.launch;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.net.URLConnection;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import com.kamesuta.mc.modspawner.asm.MdspCorePlugin;
import com.kamesuta.mc.modspawner.download.Status;
import com.kamesuta.mc.modspawner.gui.UIFrame;
import com.kamesuta.mc.modspawner.gui.dl.IDLCloser;
import com.kamesuta.mc.modspawner.gui.dl.IDLProgress;

public class Loader {
	// private static ByteBuffer downloadBuffer = ByteBuffer.allocateDirect(1 <<
	// 23);
	private static final String owner = "ModSpawner";
	private static final LogManager logger = LogManager.getLogger(owner);

	private File modsDir;
	private Status status;
	private UIFrame gui;

	public Loader() {
		gui = new UIFrame();
		gui.makeGUI();
		status = new Status();

		// File mcDir = (File) FMLInjectionData.data()[6];
		File mcDir = new File("./");

		modsDir = new File(mcDir, "mods");
	}

	private void download(String url) {
		try {
			URL libDownload = new URL(url);
			// downloadMonitor .updateProgressString("Downloading file %s",
			// libDownload.toString());
			logger.info("Downloading file " + libDownload.toString());
			URLConnection connection = libDownload.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.setRequestProperty("User-Agent", "" + owner + " Downloader");
			download(connection.getInputStream(), connection.getContentLength());
			// downloadMonitor.updateProgressString("Download complete");
			logger.info("Download complete");
		} catch (Exception e) {
			installError(e, "download");
		}
	}

	private void installError(Exception e, String s) {
		IDLCloser closer = gui.getCalculate();
		if (closer.shouldStopIt()) {
			logger.error("You have stopped the " + s + " before it could complete");
			MdspCorePlugin.exit(1);
		}
		// closer.showErrorDialog(dep.file.filename, dep.repo + '/' +
		// dep.file.filename);
		throw new RuntimeException(s + " error", e);
	}

	private void download(InputStream is, int sizeGuess) throws Exception {
		File target = new File(modsDir, "newFile.png");

		int read, fullLength = 0;

		IDLCloser closer = gui.getCalculate();
		IDLProgress progress = gui.gui;
		status.narrowLength = sizeGuess;
		progress.update(status);

		if (!target.exists())
			target.createNewFile();
		BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(target));
		try {
			closer.setPokeThread(Thread.currentThread());
			byte[] buffer = new byte[1024];
			while ((read = is.read(buffer)) >= 0) {
				fos.write(buffer, 0, read);
				fullLength += read;

				if (closer.shouldStopIt())
					break;

				status.update(read, fullLength);
				progress.update(status);
			}
			is.close();
			closer.setPokeThread(null);
		} catch (InterruptedIOException e) {
			// We were interrupted by the stop button. We're stopping now..
			// clear interruption flag.
			Thread.interrupted();
			throw new Exception("Stop");
		} finally {
			fos.close();
		}

	}

	public static void main(String[] args) {
		//new Loader().download("http://k54.offliberty.com/P_ZafsauELQ.mp4");
		new Loader().download("http://modspawner.mc.kamesuta.com/experimental/f41df44e-3757-402d-b011-3f39de937ea8.zip");
	}
}

class LogManager {
	String owner;

	public LogManager(String owner) {
		this.owner = owner;
	}

	public void info(String log) {
		System.out.println(String.format("[INFO][%s]%s", owner, log));
	}

	public void error(String log) {
		System.err.println(String.format("[ERROR][%s]%s", owner, log));
	}

	public static LogManager getLogger(String owner) {
		return new LogManager(owner);
	}
}
