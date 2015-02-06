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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ResponseView extends ViewWithUiHandlers<ResponseUiHandlers>
	implements ResponsePresenter.MyView {
    interface Binder extends UiBinder<Widget, ResponseView> {
    }

    @UiField
    SimpleLayoutPanel mainPanel;

    @UiField
    Button closeButton;

    @Inject
    ResponseView(Binder uiBinder) {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("closeButton")
    void onClose(ClickEvent event) {
	getUiHandlers().onClose();
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
	if (slot == ResponsePresenter.MAIN_SLOT) {
	    mainPanel.clear();
	    mainPanel.setWidget(content);
	} else {
	    super.setInSlot(slot, content);
	}
    }
}
