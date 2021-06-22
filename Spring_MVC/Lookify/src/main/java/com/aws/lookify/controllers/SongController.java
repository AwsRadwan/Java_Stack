package com.aws.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aws.lookify.models.Song;
import com.aws.lookify.services.SongService;

@Controller
public class SongController {
	
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String main(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "main.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addNew(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "new.jsp";
	}
	
	@RequestMapping("/topten")
	public String topten(Model model) {
		List<Song> songs = songService.topTenSongs();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
	
	@RequestMapping(value="/searsh", method = RequestMethod.POST)
	public String serash(Model model, @RequestParam(value = "artist") String artist) {
		List<Song> songs = songService.artistSongs(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "searsh.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String thisSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "details.jsp";
	}
	
	@RequestMapping("/songs/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		songService.deleteSong(song);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/addnew", method = RequestMethod.POST)
    public String addlang(@Valid @ModelAttribute("song") Song song, BindingResult result) {
    	if (result.hasErrors()) {
			return "/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
    }

}
