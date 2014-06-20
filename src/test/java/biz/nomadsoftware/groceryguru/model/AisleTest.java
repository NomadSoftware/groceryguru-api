package biz.nomadsoftware.groceryguru.model;

import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.dt;
import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.mapper;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import biz.nomadsoftware.hamcrest.ReadableInstantMatcher;

public class AisleTest {

	@Test
	public void test_serialize() throws Exception {
		Aisle a = new Aisle(1L);
		a.setStoreId(2L);
		a.setOrderSequence(3);
		a.setCreated(dt);
		a.setUpdated(dt);
		a.setVersion(4);
		String json = mapper.writeValueAsString(a);
		assertThat(json, is(fixture("fixtures/aisle.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Aisle a = mapper.readValue(fixture("fixtures/aisle.json"), Aisle.class);
		assertThat(a.getId(), is(1L));
		assertThat(a.getStoreId(), is(2L));
		assertThat(a.getOrderSequence(), is(3));
		assertThat(a.getCreated(), ReadableInstantMatcher.equals(dt));
		assertThat(a.getUpdated(), ReadableInstantMatcher.equals(dt));
		assertThat(a.getVersion(), is(4));
	}

}
