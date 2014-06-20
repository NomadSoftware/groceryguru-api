package biz.nomadsoftware.groceryguru.model;

import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.dt;
import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.mapper;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import biz.nomadsoftware.hamcrest.ReadableInstantMatcher;

public class AccountTest {

	@Test
	public void test_serialize() throws Exception {
		Account a = new Account(1L);
		a.setParentAccountId(2L);
		a.setCreated(dt);
		a.setUpdated(dt);
		a.setVersion(3);
		String json = mapper.writeValueAsString(a);
		assertThat(json, is(fixture("fixtures/account.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Account a = mapper.readValue(fixture("fixtures/account.json"), Account.class);
		assertThat(a.getId(), is(1L));
		assertThat(a.getParentAccountId(), is(2L));
		assertThat(a.getCreated(), ReadableInstantMatcher.equals(dt));
		assertThat(a.getUpdated(), ReadableInstantMatcher.equals(dt));
		assertThat(a.getVersion(), is(3));
	}

}
