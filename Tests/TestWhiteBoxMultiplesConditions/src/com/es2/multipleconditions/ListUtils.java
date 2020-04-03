package com.es2.multipleconditions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListUtils {
	public static int findName(ArrayList<String> list, String name) {
		if(list.size() == 0)
			return -1;

		return list.indexOf(name);
	}
}
