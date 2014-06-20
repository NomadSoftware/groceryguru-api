package biz.nomadsoftware.groceryguru.model;

import java.util.Objects;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

public abstract class DatedVersionedEntity {

	private Long id;
	private DateTime created;
	private DateTime updated;
	private Integer version;

	protected DatedVersionedEntity() {
		//
	}

	protected DatedVersionedEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DatedVersionedEntity other = (DatedVersionedEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
