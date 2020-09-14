package com.edutecno.dao;

import java.util.List;

public interface InterfaceCRUD <Cualquiera>{

	public List<Cualquiera> findAll();
	
	public Cualquiera findById(Object id);
	
	public boolean create(Cualquiera objeto);
	
	public boolean update(Cualquiera objeto);
	
	public boolean detele(Cualquiera objeto);
}
