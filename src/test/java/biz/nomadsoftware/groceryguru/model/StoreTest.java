package biz.nomadsoftware.groceryguru.model;

import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.dt;
import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.mapper;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import biz.nomadsoftware.hamcrest.ReadableInstantMatcher;

public class StoreTest {

	@Test
	public void test_serialize() throws Exception {
		Store s = new Store(1L);
		s.setAccountId(2L);
		s.setOrderSequence(3);
		s.setCreated(dt);
		s.setUpdated(dt);
		s.setVersion(4);
		String json = mapper.writeValueAsString(s);
		assertThat(json, is(fixture("fixtures/store.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Store s = mapper.readValue(fixture("fixtures/store.json"), Store.class);
		assertThat(s.getId(), is(1L));
		assertThat(s.getAccountId(), is(2L));
		assertThat(s.getOrderSequence(), is(3));
		assertThat(s.getCreated(), ReadableInstantMatcher.equals(dt));
		assertThat(s.getUpdated(), ReadableInstantMatcher.equals(dt));
		assertThat(s.getVersion(), is(4));
	}

}
