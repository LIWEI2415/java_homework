package control_Subway;

import control_Subway.NotFoundException;
import control_Subway.subwayDA;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subwayDA.initialize();
		try {
			subwayDA.findTarget();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subwayDA.terminate();
	}

}
