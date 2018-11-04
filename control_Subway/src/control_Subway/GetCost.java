package control_Subway;
public class GetCost {
	//对于给定路径，计算其对应的乘车费用（普通单程票，武汉通和日票）
		public static String getCost(String a) throws NotFoundException {
			String str=null;
			int coat = 0;
			if(FindShortLine.minDistance<=9) {
				coat=2;
			}
			if(9<FindShortLine.minDistance&&FindShortLine.minDistance<=14) {
				coat=3;
			}
			if(14<FindShortLine.minDistance&&FindShortLine.minDistance<=21) {
				coat=4;
			}
			if(21<FindShortLine.minDistance&&FindShortLine.minDistance<=30) {
				coat=5;
			}
			if(30<FindShortLine.minDistance) {
				coat=6;
			}
			if(a.equals("普通单程票"))
				str=("需要"+coat+"元");
			if(a.equals("武汉通"))
				str=("需要"+coat*0.9+"元");
			if(a.equals("日票"))
				str=("购买日票可免费");
			return str;
		}
}
