package com.es2.multipleconditions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CourseUtils {
	public static boolean approved(Marks record) {
		if( record.getWrittenTest() >= 9.5 && record.getAttendance() > 0.66 && record.getWork() >= 10)
			return true;
		else
			return false;
	}


}
