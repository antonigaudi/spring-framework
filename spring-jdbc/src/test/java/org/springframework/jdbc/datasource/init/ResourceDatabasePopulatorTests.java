/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.jdbc.datasource.init;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.junit.Assert.*;

/**
 * Unit tests for {@link ResourceDatabasePopulator}.
 *
 * @author Sam Brannen
 * @since 4.1
 * @see AbstractDatabasePopulatorTests
 */
public class ResourceDatabasePopulatorTests {

	private static final Resource script1 = resource("script1");
	private static final Resource script2 = resource("script2");


	@Test(expected = IllegalArgumentException.class)
	public void constructWithNullResource() {
		new ResourceDatabasePopulator((Resource) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructWithNullResourceArray() {
		new ResourceDatabasePopulator((Resource[]) null);
	}

	@Test
	public void constructWithResource() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(script1);
		assertEquals(1, databasePopulator.getScripts().size());
	}

	@Test
	public void constructWithMulipleResources() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(script1, script2);
		assertEquals(2, databasePopulator.getScripts().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addScriptsWithNullResource() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScripts((Resource) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addScriptsWithNullResourceArray() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScripts((Resource[]) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setScriptsWithNullResource() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setScripts((Resource) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setScriptsWithNullResourceArray() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setScripts((Resource[]) null);
	}

	private static Resource resource(String path) {
		return new ClassPathResource(path);
	}

}