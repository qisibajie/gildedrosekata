package ir4.arp.length;

import java.util.Objects;

public class Length {

	public int value;
	public String unit;

	public Length(int length, String unit) {
		if (length < 0) {
			throw new RuntimeException("The Length is invalid");
		}
		this.value = length;
		this.unit = unit;
	}

	public Length(int length) {
		if (length < 0) {
			throw new RuntimeException("The Length is invalid");
		}
		this.value = length;
	}

	public int getvalue() {
		return this.value;
	}
	
	public String getUnit() {
		return this.unit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Length) {
			return Objects.equals(this.getvalue(), ((Length) obj)
					.getvalue() /*
								 * && Objects.equals(this.getUnit(), ((Length)
								 * obj).getvalue()
								 */);
		}
		return false;
	}

	public int compare(Length lengthB) {
		Integer valueB = UnitConvertTool.convertToMM(lengthB.getvalue(), lengthB.getUnit());
		Integer valueA = UnitConvertTool.convertToMM(this.value, this.unit);
		return valueA.compareTo(valueB);
	}

}
