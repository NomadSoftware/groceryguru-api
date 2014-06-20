package biz.nomadsoftware.groceryguru.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(LowerCaseWithUnderscoresStrategy.class)
@JsonInclude(Include.NON_EMPTY)
public class Account extends DatedVersionedEntity {

	private Long parentAccountId;

	public Account() {
		super();
	}

	public Account(Long id) {
		super(id);
	}

	public Long getParentAccountId() {
		return parentAccountId;
	}

	public void setParentAccountId(Long parent) {
		this.parentAccountId = parent;
	}

}
