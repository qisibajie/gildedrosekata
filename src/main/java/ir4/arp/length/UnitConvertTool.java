package ir4.arp.length;

public class UnitConvertTool {


	public static Integer convertToMM(int valueA, String unitA) {
		Integer basic = LengthUnit.mapUnit.get(unitA);
		if (basic == null) {
			throw new RuntimeException("The unit " + unitA + " is not supported");
		}
		return valueA * basic;
	}
}
