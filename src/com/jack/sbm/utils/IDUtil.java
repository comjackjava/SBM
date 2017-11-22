/**
 * 
 */
package com.jack.sbm.utils;

import java.util.UUID;

/**
 * @author admin
 * 2017年11月17日
 */
public class IDUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
