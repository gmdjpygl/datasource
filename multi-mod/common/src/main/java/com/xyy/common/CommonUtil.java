package com.xyy.common;

public class CommonUtil {
    public static boolean isNull(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
			return false;
		}


	}

}
