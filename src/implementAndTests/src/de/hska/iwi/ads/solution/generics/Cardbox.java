package de.hska.iwi.ads.solution.generics;

import de.hska.iwi.ads.generics.Box;

public class Cardbox<T> extends Box<T> {

	public Cardbox(int volume, T content) {
		super(volume, content);
	}

	@Override
	public int compareTo(Box<T> o) {
		int value;
		if (this.volume < o.getVolume()) {
			value = -1;
		} else if (this.volume == o.getVolume()) {
			value = 0;
		} else {
			value = 1;
		}
		return value;
	}

}
