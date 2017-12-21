package com.tamber.types;

public enum TamberFilterFunction {
	AND("and"),
	OR("or"),
	NOT("not"),
	EQ("eq"),
	NEQ("neq"),
	GT("gt"),
	GTE("gte"),
	LT("lt"),
	LTE("lte"),
	CONTAINS("contains"),
	OVERLAPS("overlaps")
	;

	public String function;

	TamberFilterFunction(String function) {
		this.function = function;
	}

	public String getFunction() {
		return function;
	}
}