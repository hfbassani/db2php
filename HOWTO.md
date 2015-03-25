NetBeans plugin to generate PHP entity classes from database tables.
Currently tested with NetBeans 6.7 ;)

## Here we go! ##
**File -> New**

![http://db2php.googlecode.com/files/db2php0.png](http://db2php.googlecode.com/files/db2php0.png)

### Tables ###
Choose the tables for which you want to generate entity classes.

Only for tables with a primary key the code will be safe without modification,
as rows in UPDATE/DELETE queries will be identified by those.

In case a table has no primary key, the table is highlighted in orange and the guessed identifier(s) that will be used are shown in the tooltip when you hover the table name.

![http://db2php.googlecode.com/files/db2php1.png](http://db2php.googlecode.com/files/db2php1.png)

### Options ###
Simply select the Database Layer you like and the identifier quote.

If your fields don't contain special characters like whitespaces and aren't SQL keywords (which hopefully is the case anyway ;) ) you should select no identifier quote as they differ from DB system to DB system and leaving it enables you to use the class with every driver PDO supports.
Fluent Interface allows you to chain setter calls.

![http://db2php.googlecode.com/files/db2php2.png](http://db2php.googlecode.com/files/db2php2.png)

If you choose "Simple Interface" as Database Layer (maybe because PDO isn't available) you have to implement the SimpleDatabaseInterface as described in http://db2php.googlecode.com/files/SimpleDatabaseInterface.class.php
.

Use PDO whenever possible.


## Use it! ##
```
<?php
include_once 'SituMembersModel.class.php';
$db=new PDO('mysql:dbname=situ;host=localhost', 'user', 'password');

// query all members with dexterity=12 and reasoning=4 (query by example currently only available for PDO!)
$example=new SituMembersModel();
$example->setDexterity(12)->setReasoning(4);
foreach (SituMembersModel::findByExample($db, $example) as $member) {
	echo $member->getId() . ':' . $member->getName() . "\n";
}

// get single member for PK
$member=SituMembersModel::findById($db, 1);
var_dump($member->toArray());
$member->setMight(100);
$member->setMagic(100);
$member->updateToDatabase($db);


// a bit more flexible filters (currently only available for PDO!)
include_once 'DFC.class.php';
$filter=array(
	new DFC(SituMembersModel::FIELD_NAME, 's', DFC::BEGINS_WITH), // value of field name begins with s
	new DFC(SituMembersModel::FIELD_PHYSIQUE, 10, DFC::GREATER) // value of field physique is greater 10
);
foreach (SituMembersModel::findByFilter($db, $filter) as $member) {
	echo $member->getId() . ':' . $member->getName() . ':' . $member->getPhysique() . "\n";
}
?>
```

## And from here ... ##

For a overview of the generated methods, have a look at [GeneratedMethods](GeneratedMethods.md).

If you are looking for examples, try this:

http://db2php.googlecode.com/files/example.tar.bz2

It also includes a small test.db for you to play with.

**Warning:**
If you generate classes for tables without a primary key, the guessed identifiers **WILL PROBABLY NOT BE SAFE!**

Thats all folks `(^_^)`