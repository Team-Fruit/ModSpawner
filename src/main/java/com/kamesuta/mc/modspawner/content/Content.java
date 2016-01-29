package com.kamesuta.mc.modspawner.content;

import com.kamesuta.mc.modspawner.download.status.ContentStatus;

public class Content {

	public String name;
	public String repo;
	public final ContentStatus status;

	public Content(String name, String repo, long size, String hash) {
		this.name = name;
		this.repo = repo;
		this.status = new ContentStatus();
	}

	public void set(Content content) {
		this.name = content.name;
		this.repo = content.repo;
	}
}
