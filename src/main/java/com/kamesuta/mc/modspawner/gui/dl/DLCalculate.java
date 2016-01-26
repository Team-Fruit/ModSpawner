package com.kamesuta.mc.modspawner.gui.dl;

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
}
