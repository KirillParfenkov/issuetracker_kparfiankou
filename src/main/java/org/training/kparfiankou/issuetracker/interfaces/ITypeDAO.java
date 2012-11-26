package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Type;

/**
 * @author theparf
 *
 */
public interface ITypeDAO {

	/**
	 * @return List of types.
	 */
	List<Type> getListType();

	/**
	 * @param id Unique object identifier.
	 * @return Object of class Type.
	 */
	Type getType(int id);

	/**
	 * @param nameType name of type
	 * @return Object of class Type
	 */
	Type getType(String nameType);

	/**
	 * @param type object of class Type
	 */
	void updateType(Type type);

	/**
	 * Close connection with Database.
	 */
	void close();

	/**
	 * @param id of type
	 */
	void removeType(int id);

	/**
	 * @param nameType name of type
	 */
	void insertType(String nameType);
}