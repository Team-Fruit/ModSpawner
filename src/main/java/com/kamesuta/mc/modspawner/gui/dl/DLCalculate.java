package com.kamesuta.mc.modspawner.gui.dl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.kamesuta.mc.modspawner.util.SizeUnit;
import com.kamesuta.mc.modspawner.util.Speed;

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

		/** 速度計算機 */
		private Speed speed = new Speed(20);

		private Timer tm = new Timer(1000, this);
		private DLDetailsGraph detailsGraph;
		private DLDetailsText detailsText;

		public DLDetails()
		{
			initialize();
		}

		private void initialize()
		{
			tm.restart();
		}

		public void setDetailsGraph(DLDetailsGraph d)
		{
			detailsGraph = d;
		}

		public void setDetailsText(DLDetailsText t)
		{
			detailsText = t;
		}

		public void upcount(int size)
		{
			// increase count
			speed.counter += size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Calculate Speed
			speed.update();
			double speedsize = speed.getSpeed();
			int avefull = speed.getAverageFull(1000000000l);

			if (detailsGraph != null)
			{
				detailsGraph.addSpeed(speed).repaint();
			}

			if (detailsText != null)
			{
				detailsText.FieldTimeRemaining.setText(avefull>0 ? String.valueOf(avefull) : "計算中");
				detailsText.FieldSpeed.setText(speedsize>0 ? SizeUnit.SPEED.getFormatSizeString(speedsize, 2) : "計算中");
			}

			tm.start();
		}
	}
}
