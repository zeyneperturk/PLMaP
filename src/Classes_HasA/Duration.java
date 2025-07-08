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

	@Override
	public String toString() {
		String str= "";
		if(hr>0)
			str+= hr + " hour(s) ";
		
		if(min>0)
			str+= min + " minute(s) ";
		if(sec>0)
			str+= sec + " second(s)";
		if(hr == 0 && min == 0 && sec == 0)
			str += "n/a";
		return str;
	}

}
