package be.shop.repository.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.shop.exception.RepositoryException;
import be.shop.repository.GenericRepository;

public abstract class GenericRepositoryJpa<T> implements GenericRepository<T> {

	// Initialisation implicite de l'EntityManager (voir définition dans
	// persistence.xml)
	@PersistenceContext(unitName = "shopOnline-persistence")
	protected EntityManager entityManager;

	private Class<T> persistenceClass;

	@SuppressWarnings("unchecked")
	public GenericRepositoryJpa() {
		// Exemple avec Category
		// getClass() => CategoryRepositoryJpa
		// getGenericSuperclass() => GenericRepositoryJpa
		// getActualTypeArguments() => <T>
		// [0] => T
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		if (entityManager == null)
			throw new java.lang.IllegalStateException("Unknown EntityManager");

		return entityManager;
	}

	@Override
	public T findById(Long id) {
		return getEntityManager().find(persistenceClass, id);
	}

	@Override
	public List<T> findAll() {
		return getEntityManager().createNamedQuery(
				persistenceClass.getSimpleName() + "findAll", persistenceClass)
				.getResultList();
	}

	@Override
	public void save(T t) {
		if (t == null)
			throw new RepositoryException("Invalid entity");
		getEntityManager().merge(t);

	}

	@Override
	public void delete(T t) {
		if (t == null)
			throw new RepositoryException("Invalid entity");

		// faire getEntityManager().remove(getEntityManager().merge(achat));,
		// c'est mieux que getEntityManager().remove(achat); parce que si jamais
		// achat a été modifié avant le remove, il ne serait pas supprimé de la
		// DB sans le merge
		getEntityManager().remove(getEntityManager().merge(t));

	}

	@Override
	public void delete(Long id) {
		T entity = getEntityManager().find(persistenceClass, id);
		if (entity == null)
			throw new RepositoryException("Invalid entity");
		getEntityManager().remove(entity);

	}

}
