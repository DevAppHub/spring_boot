package com.devapp.hub.mobile.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devapp.hub.exception.MobileNotFoundException;
import com.devapp.hub.mobile.dto.Mobile;
import com.devapp.hub.mobile.service.MobileDAOService;

@RestController
public class MobileResource {

	@Autowired
	private MobileDAOService daoService;

	// retrieve all mobile
	@GetMapping("/mobiles")
	public List<Mobile> retrieveAllMobile() {
		return daoService.findAll();
	}

	@GetMapping("/mobile/{id}")
	public EntityModel<Mobile> retrieveMobile(@PathVariable int id) {
		Mobile mobile = daoService.findOne(id);
		if(mobile==null) {
			throw new MobileNotFoundException("id-->"+id);
		}
		
		//basically we are returning link dynamically in the response
		EntityModel<Mobile> model=EntityModel.of(mobile);
		WebMvcLinkBuilder linkToMobiles=linkTo(methodOn(this.getClass()).retrieveAllMobile());
		model.add(linkToMobiles.withRel("all-mobiles"));
		return model;
	}
	
	@DeleteMapping("/mobile/{id}")
	public void deleteById(@PathVariable int id) {
		Mobile mobile = daoService.deleteById(id);
		if(mobile==null) {
			throw new MobileNotFoundException("id-->"+id);
		}
	}

	@PostMapping("/mobile")
	public ResponseEntity<Object> addMobile(@Valid @RequestBody Mobile mobile) {
		Mobile savedMobile = daoService.save(mobile);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMobile.getId())
				.toUri();
		return ResponseEntity.created(location).build(); // it will return the url in headers section of response as
															// output
	}
}
