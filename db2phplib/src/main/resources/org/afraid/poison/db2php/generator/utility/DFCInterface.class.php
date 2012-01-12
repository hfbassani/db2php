<?php

/**
 *
 * @author Andreas Schnaiter <as@euro-solutions.de>
 */
interface DFCInterface {

	/**
	 * get unqiq id of filter
	 *
	 * @return string
	 */
	public function getUniqId();

	/**
	 * set unqiq id of filter
	 *
	 * @param string $uniqId
	 */
	public function setUniqId($uniqId);

	/**
	 * build sql WHERE statement
	 *
	 * @param Db2PhpEntity $entity
	 * @param bool $fullyQualifiedNames
	 * @param bool $prependWhere
	 * @return string
	 */
	public function buildSqlWhere(Db2PhpEntity $entity, $fullyQualifiedNames=true, $prependWhere=false);

	/**
	 * bind values to statement
	 *
	 * @param Db2PhpEntity $entity
	 * @param PDOStatement $stmt
	 */
	public function bindValuesForFilter(Db2PhpEntity $entity, PDOStatement &$stmt);

}

?>