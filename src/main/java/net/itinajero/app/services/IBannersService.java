package net.itinajero.app.services;

import java.util.List;

import net.itinajero.app.model.Banner;

public interface IBannersService {
	List<Banner> getAll();
	void insert(Banner banner);
}
