package com.hampcode.model.repository;

import java.io.Serializable;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.hampcode.model.entity.Usuario;
@Named
public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;

	public Usuario findByUsuarioAndContrasenia(String nombre, String clave) throws Exception {
		Usuario usuarioFound;

		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u WHERE u.nombre=?1 AND u.clave=?2", Usuario.class);
		query.setParameter(1, nombre);
		query.setParameter(2, clave);

		usuarioFound=query.getSingleResult();

		return usuarioFound;
	}
}