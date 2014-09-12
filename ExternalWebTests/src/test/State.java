package test;

public enum State{
	NONE, AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI,
	ID, IL, IN,IA, KS, KY, LA, ME, MD, MA, MI, MN, MS,
	MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR,
	PA, RI, SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY;

	public String toString(){
		if(this.equals(NONE)){
			return "--";
		}
		return name();
	}
}
