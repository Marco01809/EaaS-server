package net.explorviz.eaas.frontend.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;
import net.explorviz.eaas.frontend.component.ExplorVizBanner;
import net.explorviz.eaas.frontend.component.NavbarActions;
import net.explorviz.eaas.frontend.view.MainView;

/**
 * Basic layout for all views without a navigation sidebar. Only has the top navbar.
 */
@CssImport("./style/layout.css")
public class BaseLayout extends AppLayout {
    private static final long serialVersionUID = 6416207502947013549L;

    public BaseLayout() {
        this(false);
    }

    /**
     * @param hasSidebar Whether the drawer should be opened; this should be {@code true} for layouts without a
     *                   navigation sidebar.
     */
    protected BaseLayout(boolean hasSidebar) {
        if (!hasSidebar) {
            setDrawerOpened(false);
        }

        buildNavbar();
    }

    /**
     * Add all items to the top navigation bar. Can be overwritten in child classes and called at any time to add the
     * items in a specific place.
     */
    public void buildNavbar() {
        RouterLink homeBanner = new RouterLink();
        homeBanner.setRoute(MainView.class);
        homeBanner.add(new ExplorVizBanner(false));
        addToNavbar(homeBanner);
        addToNavbar(new NavbarActions());
    }
}
