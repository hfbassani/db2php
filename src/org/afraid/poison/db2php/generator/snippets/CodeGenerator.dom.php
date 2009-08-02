

	/**
	 * get element as DOM Document
	 *
	 * @return DOMDocument
	 */
	public function toDOM() {
		$doc=new DOMDocument();
		$root=$doc->createElement(__CLASS__);
		foreach ($this->toHash() as $fieldName=>$value) {
			$fElem=$doc->createElement($fieldName);
			$fElem->appendChild($doc->createTextNode($value));
			$root->appendChild($fElem);
		}
		$doc->appendChild($root);
		return $doc;
	}

	/**
	 * get single <type> instance from a DOMElement
	 *
	 * @param DOMElement $node
	 * @return <type>
	 */
	public static function fromDOMElement(DOMElement $node) {
		if (__CLASS__!=$node->nodeName) {
			return new InvalidArgumentException('expected: ' . __CLASS__ . ', got: ' . $node->nodeName, 0);
		}
		$result=array();
		foreach (self::$FIELD_NAMES as $fieldName) {
			$n=$node->getElementsByTagName($fieldName)->item(0);
			if (!is_null($n)) {
				$result[$fieldName]=$n->nodeValue;
			}
		}
		$o=new AsShopBasketModel();
		$o->assignByHash($result);
		return $o;
	}

	/**
	 * get all instances of <type> from the passed DOMDocument
	 *
	 * @param DOMDocument $doc
	 * @return <type>[]
	 */
	public static function fromDOMDocument(DOMDocument $doc) {
		$instances=array();
		foreach ($doc->getElementsByTagName(__CLASS__) as $node) {
			$instances[]=self::fromDOMElement($node);
		}
		return $instances;
	}

