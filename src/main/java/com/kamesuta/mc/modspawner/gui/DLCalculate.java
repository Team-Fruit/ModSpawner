package com.kamesuta.mc.modspawner.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class DLCalculate implements IDLCloser
{
	private Thread pokeThread;
	private boolean stopIt = false;

	@Override
	public void setPokeThread(Thread currentThread) {
		this.pokeThread = currentThread;
	}

	@Override
	public void requestClose() {
		stopIt = true;
		if (pokeThread != null)
			pokeThread.interrupt();
	}

	@Override
	public boolean shouldStopIt() {
		return stopIt;
	}

	public final IDLProgress progressAll = new DLProgress();
	public final IDLProgress progressOne = new DLProgress();

	private static class DLProgress implements IDLProgress
	{
		private JProgressBar progress;

		@Override
		public void setProgressBar(JProgressBar p)
		{
			progress = p;
		}

		@Override
		public void updateGuess(int sizeGuess) {
			if (progress != null)
			{
				progress.setIndeterminate(false);
				//progress.getModel().setRangeProperties(0, 0, 0, sizeGuess, false);
				progress.setMaximum(sizeGuess);
			}
		}

		@Override
		public void updateProgress(int fullLength) {
			if (progress != null)
				//progress.getModel().setValue(fullLength);
				progress.setValue(fullLength);
		}

		@Override
		public void updateString(String string) {
			if (progress != null)
			{
				progress.setIndeterminate(true);
				progress.setString(string);
			}
		}
	}

	public final DLDetails details = new DLDetails();

	public static class DLDetails implements ActionListener {
		private Timer tm = new Timer(1000, this);
		private DLDetailsGraph detailsGraph;
		private JTextArea detailsText;

		public DLDetails()
		{
			initialize();
		}

		private void initialize()
		{
			tm.restart();
		}

		public static final double NANOS_PER_SECOND = 1000000000.0;
		private int oldCount;
		private int newCount;
		private long newTime;
		private long oldTime;

		public void setDetailsGraph(DLDetailsGraph d)
		{
			detailsGraph = d;
		}

		public void setDetailsTable(JTextArea t)
		{
			detailsText = t;
		}

		public void countUp(int size)
		{
			newCount += size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Calculate Speed
			int count = newCount-oldCount;
			newTime = System.nanoTime();
			int time = (int) ((newTime>oldTime && oldTime>0) ? (newTime-oldTime) : NANOS_PER_SECOND);
			double speed = NANOS_PER_SECOND * count / time;
			oldCount = newCount;
			oldTime = newTime;

			if (detailsGraph != null)
			{
				detailsGraph.addObj((int)speed);
			}


			tm.start();
		}
	}
}
