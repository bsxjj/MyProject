package com.ecjtu.jy.utils;

import java.sql.Timestamp;
import java.util.Comparator;

import com.ecjtu.jy.pojo.Notification;

public class ComparatorByDate  implements Comparator{

	@Override
	public int compare(Object ob0, Object ob1) {
		Notification bo=(Notification) ob0;
		Notification b1=(Notification) ob1;
		long time1 = bo.getComm_time().getTime();
		long time2 = b1.getComm_time().getTime();
		int i = ( time1 < time2 ? 1 :(time1 == time2 ? 0 : -1));
		return i;
	}

}
