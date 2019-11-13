package net.itinajero.app.services;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.News;

@Service
public class NewsServiceImpl implements INewsService {

	public NewsServiceImpl() {
		System.out.println("Create News Service Imple ");
	}

	@Override
	public void save(News news) {
		// TODO Auto-generated method stub
		System.out.println(news);
	}

}
