package biz.nomadsoftware.groceryguru.model;

import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.dt;
import static biz.nomadsoftware.groceryguru.model.ModelTestUtil.mapper;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import biz.nomadsoftware.hamcrest.ReadableInstantMatcher;

public class DeviceTest {

	@Test
	public void test_serialize() throws Exception {
		Device d = new Device(1L);
		d.setAccountId(2L);
		d.setCreated(dt);
		d.setUpdated(dt);
		d.setVersion(3);
		String json = mapper.writeValueAsString(d);
		assertThat(json, is(fixture("fixtures/device.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Device d = mapper.readValue(fixture("fixtures/device.json"), Device.class);
		assertThat(d.getId(), is(1L));
		assertThat(d.getAccountId(), is(2L));
		assertThat(d.getCreated(), ReadableInstantMatcher.equals(dt));
		assertThat(d.getUpdated(), ReadableInstantMatcher.equals(dt));
		assertThat(d.getVersion(), is(3));
	}

}
