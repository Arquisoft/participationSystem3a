package pSystem.business.command;

import javax.persistence.*;

import pSystem.persistence.util.Jpa;
import pSystem.util.BusinessException;

public class CommandExecutor<T> {

	public T execute(Command<T> cmd) throws BusinessException {
		EntityManager entityManager = Jpa.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		try {
			T object = cmd.execute();

			entityTransaction.commit();
			return object;

		} catch (BusinessException e) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
			throw e;
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}
	}
}