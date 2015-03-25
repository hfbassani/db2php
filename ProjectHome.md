NetBeans plugin to generate PHP entity classes from database tables.
Requires NetBeans 7.0 or later.

## Here we go! ##
![http://db2php.googlecode.com/files/db2php0.png](http://db2php.googlecode.com/files/db2php0.png)
![http://db2php.googlecode.com/files/db2php1.png](http://db2php.googlecode.com/files/db2php1.png)
![http://db2php.googlecode.com/files/db2php2.png](http://db2php.googlecode.com/files/db2php2.png)

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

**Warning:**
If you generate classes for tables without a primary key, the guessed identifiers **WILL PROBABLY NOT BE SAFE!**

See the [HOWTO](HOWTO.md) for a bit more detailed description.

In case you feel like donating, here's my bitcoin address:
12YhXBMV24FHNKr2YVajakBi7V4eCA53Er

Thats all folks `(^_^)`