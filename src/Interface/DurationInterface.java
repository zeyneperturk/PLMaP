package Interface;

import Classes_HasA.Duration;

public interface DurationInterface {
	
	public abstract void calculateDuration(int sec, int min, int hr);
	
	public abstract String toStringDuration(Duration dur);
}
