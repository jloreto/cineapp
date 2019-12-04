package net.itinajero.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.services.IBannersService;
import net.itinajero.app.util.Utilitis;

@Controller
@RequestMapping("/banners")
public class BannerController {

	
	@Autowired
	IBannersService bannerService;
	
	
	@GetMapping("/index")
	public String showIndex(Model model) {
		
		List<Banner> list = bannerService.getAll();
		model.addAttribute("banners", list);
		
		return "/banners/bannerList";
	}
	
	
	
	@GetMapping("/create")
	public String create() {
		
		return "/banners/bannerForm";
	}
	
	@PostMapping("/save")
	public String save(Banner banner, BindingResult result, RedirectAttributes attributes,
			@RequestParam("imageFile") MultipartFile multipart, HttpServletRequest request) {
		
		
		
		if (result.hasErrors()) {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "movies/bannerForm";
		}
		
		
		if(!multipart.isEmpty()) {
			banner.setFile(Utilitis.saveImage("banners", multipart, request));
		}
		
		System.out.println("creating banner and add in list");
		bannerService.insert(banner);
		
		attributes.addFlashAttribute("messageInfo", "The Banners is saved");
		
		return "redirect:/banners/index";
	}	
	
	
	
	
}
