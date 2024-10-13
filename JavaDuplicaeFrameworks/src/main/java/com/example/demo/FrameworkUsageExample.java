
package com.example.demo;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import javax.annotation.security.RolesAllowed;
import javax.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import io.dropwizard.auth.Auth;

public class FrameworkUsageExample {

    @RequiresAuthentication
    @RequiresRoles("admin")
    @RequiresPermissions("document:read")
    public void shiroExample() {
        System.out.println("Executing Apache Shiro example.");
    }

    @RolesAllowed("user")
    @PermitAll
    public void jaxRsExample() {
        System.out.println("Executing JAX-RS example.");
    }

    @PreAuthorize("hasRole('USER')")
    @Secured("ROLE_ADMIN")
    @RegisteredOAuth2AuthorizedClient
    public void springSecurityExample() {
        System.out.println("Executing Spring Security example.");
    }

    @Auth
    public void dropWizardExample() {
        System.out.println("Executing DropWizard Auth example.");
    }
}
