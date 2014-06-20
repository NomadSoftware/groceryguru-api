package biz.nomadsoftware.groceryguru.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(LowerCaseWithUnderscoresStrategy.class)
@JsonInclude(Include.NON_EMPTY)
public class Item extends DatedVersionedEntity {

	private Long aisleId;

	public Item() {
		super();
	}

	public Item(Long id) {
		super(id);
	}

	public Long getAisleId() {
		return aisleId;
	}

	public void setAisleId(Long aisleId) {
		this.aisleId = aisleId;
	}

}
