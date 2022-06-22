package com.devapp.hub.mobile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devapp.hub.mobile.dto.Mobile;

@Component
public class MobileDAOService {

	private static List<Mobile> mobiles = new ArrayList<>();

	private static int mobileCount = 4;

	static {
		mobiles.add(new Mobile(1, "Samsung", new Date()));
		mobiles.add(new Mobile(2, "Nokia", new Date()));
		mobiles.add(new Mobile(3, "Lenovo", new Date()));
		mobiles.add(new Mobile(4, "One Plus", new Date()));
	}

	// find all
	public List<Mobile> findAll() {
		return mobiles;
	}

	// add
	public Mobile save(Mobile mobile) {
		if (mobile.getId() == null) {
			mobile.setId(++mobileCount);
		}
		mobiles.add(mobile);
		return mobile;
	}

	// findone
	public Mobile findOne(int id) {
		for (Mobile mobile : mobiles) {
			if (mobile.getId() == id) {
				return mobile;
			}
		}
		return null;
	}

	// delete record
	public Mobile deleteById(int id) {
		Iterator<Mobile> iterator = mobiles.iterator();
		while (iterator.hasNext()) {
			Mobile mob = iterator.next();
			if (mob.getId() == id) {
				iterator.remove();
				return mob;
			}
		}

		return null;
	}
}
