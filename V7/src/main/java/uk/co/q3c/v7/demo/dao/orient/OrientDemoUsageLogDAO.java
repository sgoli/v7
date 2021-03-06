/*
 * Copyright (C) 2013 David Sowerby
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package uk.co.q3c.v7.demo.dao.orient;

import javax.inject.Inject;

import uk.co.q3c.v7.demo.dao.DemoUsageLogDAO;
import uk.co.q3c.v7.demo.usage.DemoUsageLog;
import uk.co.q3c.v7.persist.orient.dao.OrientDAOBase;
import uk.co.q3c.v7.persist.orient.db.OrientDbConnectionProvider;

public class OrientDemoUsageLogDAO extends OrientDAOBase<DemoUsageLog> implements DemoUsageLogDAO {

	@Inject
	protected OrientDemoUsageLogDAO(OrientDbConnectionProvider dbPro) {
		super(dbPro);
	}

	@Override
	protected Class<DemoUsageLog> entityClass() {
		return DemoUsageLog.class;
	}

}
