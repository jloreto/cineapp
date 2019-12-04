package net.itinajero.app.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> list = null;

	public BannersServiceImpl() {
		System.out.println("Creating instance BannerService");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

		try {
			
			list =  new LinkedList<Banner>();

			Banner banner = new Banner();
			banner.setId(1);
			banner.setTitle("Kong");
			banner.setFile("slide1.jpg");
			banner.setDate(fmtDate.parse("2017-08-23"));
			list.add(banner);

			banner = new Banner();
			banner.setId(2);
			banner.setTitle("Beaty and the Beast");
			banner.setFile("slide2.jpg");
			banner.setDate(fmtDate.parse("2017-07-23"));
			list.add(banner);

			banner = new Banner();
			banner.setId(3);
			banner.setTitle("Spiderman");
			banner.setFile("slide3.jpg");
			banner.setDate(fmtDate.parse("2017-06-23"));
			list.add(banner);

			banner = new Banner();
			banner.setId(4);
			banner.setTitle("Cars");
			banner.setFile("slide4.jpg");
			banner.setDate(fmtDate.parse("2017-05-23"));
			list.add(banner);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	@Override
	public List<Banner> getAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void insert(Banner banner) {
		list.add(banner);
	}

}
