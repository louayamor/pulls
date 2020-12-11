package com.example.pulls.entities;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "nomProd", types = { Pull.class })
public interface PullProjection {
	public String getNomPull();
}