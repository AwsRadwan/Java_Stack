package com.aws.products.controllers;

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

import com.aws.products.models.Category;
import com.aws.products.models.Product;
import com.aws.products.services.MainService;

@Controller
public class MainController {
	
	private final MainService ser;
	

	
	
	public MainController(MainService ser) {
		
		this.ser = ser;
	}

	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("parr", ser.findAllPro());
		model.addAttribute("carr", ser.findAllCate());
		return "index.jsp";
	}
	


	@RequestMapping("/product")
	public String pro(@ModelAttribute("product") Product pro) {
		return "pro.jsp";
	}
	@RequestMapping("/category")
	public String pro(@ModelAttribute("category") Category cate) {
		return "cate.jsp";
	}
	
	@RequestMapping(value="/addpro", method = RequestMethod.POST)
    public String addpro(@Valid @ModelAttribute("product") Product pro, BindingResult result) {
    	if (result.hasErrors()) {
			return "/pro.jsp";
		} else {
			ser.creatProduct(pro);
			return "redirect:/";
		}
    }
	
	@RequestMapping(value="/addcate", method = RequestMethod.POST)
    public String addninja(@Valid @ModelAttribute("category") Category cate, BindingResult result) {
    	if (result.hasErrors()) {
			return "/cate.jsp";
		} else {
			ser.creatCategory(cate);
			return "redirect:/";
		}
    }
	
	@RequestMapping(value="/deletep/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		Product x = ser.findPro(id);
		ser.deletePro(x);
		return "redirect:/";
	}
	@RequestMapping(value="/deletec/{id}", method = RequestMethod.DELETE)
	public String deleted(@PathVariable("id") Long id) {
		Category x = ser.findCate(id);
		ser.deleteCate(x);
		return "redirect:/";
	}
	
	@RequestMapping(value="/add_pro/{id}")
	public String add_pro(Model model, @PathVariable("id") Long id) {
		Category c = ser.findCate(id);
		model.addAttribute("pro", c.getProducts());
		model.addAttribute("pros", ser.otherPro(id));
		model.addAttribute("c", c);
		return "add_pro.jsp";
	}
	@RequestMapping("/add_cate/{id}")
	public String add_cate(Model model, @PathVariable("id") Long id) {
		Product p = ser.findPro(id);
		model.addAttribute("cate", p.getCategories());
		model.addAttribute("cates", ser.otherCate(id));
		model.addAttribute("p", p);
		return "add_cate.jsp";
	}
	
	@RequestMapping(value="/setcate/{id}", method = RequestMethod.POST)
	public String setCate(@RequestParam("cate") Long id, @PathVariable("id") Long p_id) {
		Product p = ser.findPro(p_id);
		Category c = ser.findCate(id);
		p.setCategories(c);
		ser.savePro(p);
		return "redirect:/add_cate/"+p_id;
	}
	
	@RequestMapping(value="/setpro/{id}", method = RequestMethod.POST)
	public String setPro(@RequestParam("pro") Long id, @PathVariable("id") Long c_id) {
		Product p = ser.findPro(id);
		Category c = ser.findCate(c_id);
		c.setProducts(p);
		ser.saveCate(c);
		return "redirect:/add_pro/"+c_id;
	}

}
