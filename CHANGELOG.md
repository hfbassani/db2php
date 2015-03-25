# v1.3 (2009-08-16) #
  * ADD: prelimary support for pgsql serial columns.
  * ADD: improve index handling for code generation
  * ADD: use hash of tablename.fieldname as field identifiers to allow mixing tables in filters
  * ADD: BSD license header for utility PHP classes
(Sorry I forgot, their not under the GPLv3, you don't have to change your projects license. The generated classes are also not under the GPLv3.)

# v1.2.7 (2009-08-09) #
  * ADD: sorting
  * ADD: fromStatement/fromExecutedStatement convenience methods
  * ADD: getFieldsValuesChanged method

# v1.2.6.3 (2009-08-06) #
  * FIX: prevent NullPointerException in wizard window in case connection fails
  * FIX: don't execute delete statement twice in deleteByFilter
  * ADD: release scripts

# v1.2.6.2 (2009-08-04) #
  * FIX: add workaround for pgsql JDBC Driver not providing IS\_AUTOINCREMENT column in Meta Data rset

# v1.2.6.1 (2009-08-03) #
  * FIX: Don't use CLASS as it would make the DOM functions useless when inheriting-

# v1.2.6 (2009-08-02) #
**IMPORTANT: With version 1.2.6 the name of some generated methods have been changed. All methods beginning with getBy are now named findBy. You should be able to fix it with a simple find&replace.**
**IMPORTANT: The Simple DatabaseInterface is disabled. Vote for the Tickets if you want it back**
  * CHG: rename getBy to findBy
  * ADD: wizard for utility files
  * ADD: rename old files instead of refusing to overwrite
  * ADD: CamelCaseFairy :P
  * ADD: deleteByFilter
  * ADD: applyDefaultValues method
  * ADD: assignByArray and toHash methods
  * ADD: DOM support
  * ...

# v1.2.5 (2009-07-20) #
  * ADD: NULL support for Filter Objects
  * ADD: getBySql to pass a complex query which can't be expressed in filters
  * CHG: preserve undercores in field id const names. If you already depend on the old names open a ticket and I'll make it an option.
NOTE: the Simple Interface is horribly out of date because I don't use it and noone complained. Please don't use it or vote for the tickets if you want it updated. Otherwise it might take a while.

# v1.2.4 (2009-07-17) #
  * ADD: Filter Objects

# v1.2.3 (2009-07-15) #
  * ADD: throw Exception on failed stmt execution
  * ADD: store options dialog value

# v1.2.2 (2009-07-09) #
  * ADD: Fluent Interface (setters can be chained)
  * ADD: simple query by example support for PDO
  * ADD: PHPDoc for accessors

# v1.2.1 (2009-07-02) #
  * FIX: getFieldsIndexesNonUnique() would return row identifiers
  * FIX: always return copy of fields and primary keys list
Source only release since it's only minor.

# v1.2 (2009-07-02) #
  * ADD: quote identifiers if selected
  * ADD: try harder to generate valid PHP identifiers (still not perfect - if you have fields where names only differ by whitespaces/case, expect missing fields)
  * ADD: "Simple Interface" Database layer which generates plain SQL queries in case PDO isn't available
  * ADD: guess best row identifiers in case table has no primary key