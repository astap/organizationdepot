package com.gwtplatform.samples.basicspring.client.application.organiztions;

import javax.inject.Inject;

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
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.samples.basicspring.client.application.response.OrganizationsUiHandlers;
import com.gwtplatform.samples.basicspring.shared.object.Organization;

class OrganiztionsView extends ViewWithUiHandlers<OrganizationsUiHandlers>
	implements OrganiztionsPresenter.MyView {

    interface Binder extends UiBinder<Widget, OrganiztionsView> {
    }

    @UiField
    CellTable<Organization> organizations;

    @Inject
    OrganiztionsView(Binder uiBinder) {
	initCellTable();
	initWidget(uiBinder.createAndBindUi(this));
    }

    private void initCellTable() {
	organizations = new CellTable<Organization>();

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
	organizations.addColumn(nameColumn, "Name");
	organizations.addColumn(editColumn, "Edit");
	organizations.addColumn(deleteColumn, "Delete");

	organizations.setSelectionModel(new NoSelectionModel<Organization>());
    }

    // @Override
    // public void setInSlot(Object slot, IsWidget content) {
    // if (slot == OrganiztionsPresenter.SLOT_Organiztions) {
    // main.setWidget(content);
    // } else {
    // super.setInSlot(slot, content);
    // }
    // }
}