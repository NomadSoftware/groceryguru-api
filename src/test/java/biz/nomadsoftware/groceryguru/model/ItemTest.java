package biz.nomadsoftware.groceryguru.model;

import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.dt;
import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.mapper;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import biz.nomadsoftware.hamcrest.ReadableInstantMatcher;

public class ItemTest {

	@Test
	public void test_serialize() throws Exception {
		Item i = new Item(1L);
		i.setAisleId(2L);
		i.setCreated(dt);
		i.setUpdated(dt);
		i.setVersion(3);
		String json = mapper.writeValueAsString(i);
		assertThat(json, is(fixture("fixtures/item.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Item i = mapper.readValue(fixture("fixtures/item.json"), Item.class);
		assertThat(i.getId(), is(1L));
		assertThat(i.getAisleId(), is(2L));
		assertThat(i.getCreated(), ReadableInstantMatcher.equals(dt));
		assertThat(i.getUpdated(), ReadableInstantMatcher.equals(dt));
		assertThat(i.getVersion(), is(3));
	}

}
