package net.explorviz.eaas.frontend.component;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import net.explorviz.eaas.frontend.view.ChangePasswordView;
import net.explorviz.eaas.security.Authorities;
import net.explorviz.eaas.security.SecurityConfiguration;
import net.explorviz.eaas.security.SecurityUtils;

public class NavbarActions extends HorizontalLayout {
    private static final long serialVersionUID = 812136038394838713L;

    // TODO: Fix navbar icons overlaying on logo on small width screens

    public NavbarActions() {
        setId("navbar-actions");

        Anchor homepage = IconAnchor.createFromImage("https://www.explorviz.net", "icons/icon-48x48.png",
            "explorviz.net");
        homepage.setTarget("_blank");
        add(homepage);

        if (SecurityUtils.isUserLoggedIn()) {
            if (SecurityUtils.hasAuthority(Authorities.CHANGE_PASSWORD_AUTHORITY)) {
                // TODO: Change this to a RouterLink instead of an Anchor
                add(IconAnchor.createFromIcon("/" + ChangePasswordView.ROUTE, VaadinIcon.PASSWORD.create(), "Change " +
                    "password"));
            }

            add(IconAnchor.createFromIcon(SecurityConfiguration.LOGOUT_URL, VaadinIcon.SIGN_OUT.create(), "Logout"));
        } else {
            add(IconAnchor.createFromIcon(SecurityConfiguration.LOGIN_URL, VaadinIcon.SIGN_IN.create(), "Login"));
        }
    }
}
