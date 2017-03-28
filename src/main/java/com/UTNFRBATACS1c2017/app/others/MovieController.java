package com.UTNFRBATACS1c2017.app.others;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

	@RequestMapping("/movie")
	public String busquedaPelicula(@RequestParam(value = "id", required = true) String id, Model model)
			throws Exception {
		Movie movie = new Movie(id);
		model.addAttribute(movie);
		return "movie";
	}

}