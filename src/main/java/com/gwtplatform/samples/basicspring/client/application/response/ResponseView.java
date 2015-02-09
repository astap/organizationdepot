/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.basicspring.client.application.response;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ActionCell.Delegate;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.IdentityColumn;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

public class ResponseView extends ViewWithUiHandlers<OrganizationsUiHandlers>
	implements ResponsePresenter.MyView {

    interface Binder extends UiBinder<Widget, ResponseView> {
    }

    @UiField
    CellTable<Organization> organizations;

    @Inject
    ResponseView(Binder uiBinder) {
	initCellTable();

	initWidget(uiBinder.createAndBindUi(this));
    }

    private void initCellTable() {
	CellTable<Organization> table = getOrganizations();

	// Create name column.
	TextColumn<Organization> nameColumn = new TextColumn<Organization>() {
	    @Override
	    public String getValue(Organization organization) {
		return organization.getName();
	    }
	};

	Cell<Organization> editCell = new ActionCell<Organization>("Edit",
		new Delegate<Organization>() {
		    @Override
		    public void execute(Organization organization) {
			getUiHandlers().onEdit(organization);
		    }
		});

	Cell<Organization> deleteCell = new ActionCell<Organization>("Delete",
		new Delegate<Organization>() {
		    @Override
		    public void execute(Organization organization) {
			Boolean confirm = Window
				.confirm("Are you sure you want to delete "
					+ organization.getName() + "?");

			if (confirm) {
			    getUiHandlers().onDelete(organization);
			}
		    }
		});

	IdentityColumn<Organization> editColumn = new IdentityColumn<Organization>(
		editCell);
	IdentityColumn<Organization> deleteColumn = new IdentityColumn<Organization>(
		deleteCell);

	// Add the columns.
	table.addColumn(nameColumn, "Name");
	table.addColumn(editColumn, "Edit");
	table.addColumn(deleteColumn, "Delete");

	final NoSelectionModel selectionModel = new NoSelectionModel();
	table.setSelectionModel(selectionModel);
    }

    @Override
    public CellTable<Organization> getOrganizations() {
	return organizations;
    }

}
