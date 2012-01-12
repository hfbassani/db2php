

	/**
	 * get element as DOM Document
	 *
	 * @return DOMDocument
	 */
	public function toDOM() {
		return self::hashToDomDocument($this->toHash(), '<type>');
	}

	/**
	 * get single <type> instance from a DOMElement
	 *
	 * @param DOMElement $node
	 * @return <type>
	 */
	public static function fromDOMElement(DOMElement $node) {
		$o=new <type>();
		$o->assignByHash(self::domNodeToHash($node, self::$FIELD_NAMES, self::$DEFAULT_VALUES, self::$FIELD_TYPES));
<pristine>		return $o;
	}

	/**
	 * get all instances of <type> from the passed DOMDocument
	 *
	 * @param DOMDocument $doc
	 * @return <type>[]
	 */
	public static function fromDOMDocument(DOMDocument $doc) {
		$instances=array();
		foreach ($doc->getElementsByTagName('<type>') as $node) {
			$instances[]=self::fromDOMElement($node);
		}
		return $instances;
	}

