//package com.unir.laboratorio.service;
//
//import com.unir.laboratorio.data.DataAccessRepository;
//import com.unir.laboratorio.model.db.Estacion;
//import com.unir.laboratorio.model.request.CreateEstacionRequest;
//import com.unir.laboratorio.model.response.EstacionesServicioQueryResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//@Service
//@RequiredArgsConstructor
//public class EstacionesServiceImpl implements EstacionesService {
//
//	private final DataAccessRepository repository;
//
//	@Override
//	public EstacionesServicioQueryResponse getEstaciones(String name, String description, String country, Boolean aggregate) {
//		return repository.findEstaciones(name, description, country, aggregate);
//	}
//
//	@Override
//	public Estacion getEstacion(String estacionId) {
//		return repository.findById(estacionId).orElse(null);
//	}
//
//	@Override
//	public Boolean removeEstacion(String estacionId) {
//
//		Estacion estacion = repository.findById(estacionId).orElse(null);
//		if (estacion != null) {
//			repository.delete(estacion);
//			return Boolean.TRUE;
//		} else {
//			return Boolean.FALSE;
//		}
//	}
//
//	@Override
//	public Estacion createEstacion(CreateEstacionRequest request) {
//
//		if (request != null && StringUtils.hasLength(request.getName().trim())
//				&& StringUtils.hasLength(request.getDescription().trim())
//				&& StringUtils.hasLength(request.getCountry().trim()) && request.getVisible() != null) {
//
//			Estacion estacion = Estacion.builder().name(request.getName()).description(request.getDescription())
//					.country(request.getCountry()).visible(request.getVisible()).build();
//
//			return repository.save(estacion);
//		} else {
//			return null;
//		}
//	}
//
//}
