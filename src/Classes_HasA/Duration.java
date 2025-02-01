package Classes_HasA;

public class Duration {
	
	private int sec;
	private int min;
	private int hr;
	
	public Duration(int sec, int min, int hr) {
		this.sec = sec;
		this.min = min;
		this.hr = hr;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

}
