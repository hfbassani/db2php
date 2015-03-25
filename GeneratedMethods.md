**Please note:** this only applies to classes generated for the PDO Database Layer,
the Simple Database Layer is currently out of date (mainly because I don't use it and noone complained ;) ).

**IMPORTANT: With version 1.2.6 the name of some generated methods have been changed. All methods beginning with getBy are now named findBy. You should be able to fix it with a simple find&replace.**

# Introduction #
You can find examples in the test folder in the source package or here: http://db2php.googlecode.com/files/example.tar.bz2 .



```
<type> 
```
refers to the class name of the generated class.

# Hints #
  * Don't modify the generated classes directly. Extend from them or aggregate them if possible as with a new release you might want to regenerate them.



# Class Methods #

Theese serve fetching instances from the database.

## findById ##
```
/**
* Get element instance by it's primary key(s).
* Will return null if no row was matched.
*
* @param PDO $db
* @return <type>
*/
public static function findById(PDO $db,$productId);
```

## findByExample ##
```
/**
* Query by Example.
*
* Match by attributes of passed example instance and return matched rows as an array of <type> instances
*
* @param PDO $db a PDO Database instance
* @param <type> $example an example instance
* @param boolean $and
* @param array $sort
* @return <type>[]
*/
public static function findByExample(PDO $db,<type> $example, $and=true, $sort=null);
```

## findByFilter ##
```
/**
* Query by filter.
*
* The filter can be either an hash with the field id as index and the value as filter value,
* or a array of DFC instances.
*
* Will return matched rows as an array of <type> instances.
*
* @param PDO $db a PDO Database instance
* @param array $filter
* @param boolean $and
* @param array $sort
* @return <type>[]
*/
public static function findByFilter(PDO $db, $filter, $and=true, $sort=null);
```

## findBySql ##
```
/**
* Execute select query and return matched rows as an array of <type> instances.
*
* The query should of course be on the table for this entity class and return all fields.
*
* @param PDO $db a PDO Database instance
* @param string $sql
* @return <type>[]
*/
public static function findBySql(PDO $db, $sql);
```

## fromStatement ##
```
/**
 * Will execute the passed statement and return the result as an array of <type> instances
 *
 * @param PDOStatement $stmt
 * @return <type>[]
 */
public static function fromStatement(PDOStatement $stmt);
```

## fromExecutedStatement ##
```
/**
 * returns the result as an array of <type> instances without executing the passed statement
 *
 * @param PDOStatement $stmt
 * @return <type>[]
 */
public static function fromExecutedStatement(PDOStatement $stmt);
```

## fromDOMElement ##
```
/**
 * get single <type> instance from a DOMElement
 *
 * @param DOMElement $node
 * @return <type>
 */
public static function fromDOMElement(DOMElement $node);
```

## fromDOMDocument ##
```
/**
 * get all instances of <type> from the passed DOMDocument
 *
 * @param DOMDocument $doc
 * @return <type>[]
 */
public static function fromDOMDocument(DOMDocument $doc);
```

## deleteByFilter ##
```
/**
 * Delete rows matching the filter
 *
 * The filter can be either an hash with the field id as index and the value as filter value,
 * or a array of DFC instances.
 *
 * @param PDO $db
 * @param array $filter
 * @param bool $and
 * @return mixed
 */
public static function deleteByFilter(PDO $db, $filter, $and=true);
```

# Member Methods #

## insertIntoDatabase ##
```
/**
* Insert this instance into the database
*
* @param PDO $db
* @return mixed
*/
public function insertIntoDatabase(PDO $db);
```

## updateToDatabase ##
```
/**
* Update this instance into the database
*
* @param PDO $db
* @return mixed
*/
public function updateToDatabase(PDO $db);
```

## deleteFromDatabase ##
```
/**
* Delete this instance from the database
*
* @param PDO $db
* @return mixed
*/
public function deleteFromDatabase(PDO $db);
```

## assignDefaultValues ##
```
/**
 * Assign default values according to table
 * 
 */
public function assignDefaultValues();
```

## assignByHash ##
```
/**
* Assign values from hash where the indexes match the tables field names
*
* @param array $result
*/
public function assignByHash($result);
```

## assignByArray ##
```
/**
 * Assign values from array with the field id as index and the value as value
 *
 * @param array $array
 */
public function assignByArray($array);
```

## toHash ##
```
/**
 * return hash with the field name as index and the field value as value.
 *
 * @return array
 */
public function toHash();
```

## toArray ##
```
/**
* return array with the field id as index and the field value as value.
*
* @return array
*/
public function toArray();
```

## getPrimaryKeyValues ##
```
/**
* return array with the field id as index and the field value as value for the identifier fields.
*
* @return array
*/
public function getPrimaryKeyValues();
```

## toDOM ##
```
/**
 * get element as DOM Document
 *
 * @return DOMDocument
 */
public function toDOM();
```

## isChanged ##
```
/**
 * return true if this instance has been modified since the last notifyPristine() call
 *
 * @return bool
 */
public function isChanged();
```

## getOldInstance ##
```
/**
 * get old instance if this has been modified, otherwise return null
 *
 * @return <type>
 */
public function getOldInstance();
```

## getFieldsValuesChanged ##
```
/**
 * return array with the field id as index and the new value as value of values which have been changed since the last notifyPristine call
 *
 * @return array
 */
public function getFieldsValuesChanged();
```

## getFieldsChanged ##
```
/**
 * return array with the field ids of values which have been changed since the last notifyPristine call
 *
 * @return array
 */
public function getFieldsChanged();
```

## notifyPristine ##
```
/**
 * set this instance into pristine state
 */
public function notifyPristine();
```