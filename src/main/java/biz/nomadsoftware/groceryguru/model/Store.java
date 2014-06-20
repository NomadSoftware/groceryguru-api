package biz.nomadsoftware.groceryguru.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(LowerCaseWithUnderscoresStrategy.class)
@JsonInclude(Include.NON_EMPTY)
public class Store extends DatedVersionedEntity {

	private Long accountId;
	private Integer orderSequence;

	public Store() {
		super();
	}

	public Store(Long id) {
		super(id);
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(Integer orderSequence) {
		this.orderSequence = orderSequence;
	}

}
