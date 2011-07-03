package com.dynamo.cr.web2.client;

import com.dynamo.cr.web2.client.ui.DashboardView;
import com.dynamo.cr.web2.client.ui.GoodbyeView;
import com.dynamo.cr.web2.client.ui.HelloView;
import com.dynamo.cr.web2.client.ui.LoginView;
import com.dynamo.cr.web2.client.ui.ProductInfoView;
import com.dynamo.cr.web2.client.ui.ProjectView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory
{
    void setDefold(Defold defold);
    Defold getDefold();
	EventBus getEventBus();
	PlaceController getPlaceController();
	HelloView getHelloView();
	GoodbyeView getGoodbyeView();
    LoginView getLoginView();
    ProductInfoView getProductInfoView();
    DashboardView getDashboardView();
    ProjectView getProjectView();
}
