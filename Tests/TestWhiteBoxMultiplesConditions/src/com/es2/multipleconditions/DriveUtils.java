package com.es2.multipleconditions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DriveUtils {
	public static void assertConditionsToDrive(Person p) throws PersonCannotDriveException{
		if(p == null)
			throw new PersonCannotDriveException();

		if(p.getAge() < 18) {
			throw new PersonCannotDriveException();
		}
	}
}
