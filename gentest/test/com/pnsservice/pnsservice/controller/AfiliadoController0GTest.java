package com.pnsservice.pnsservice.controller;

import java.lang.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Permission;
import java.util.LinkedHashSet;
import java.util.Set;

public class AfiliadoController0GTest {

  @Before
  public void setUp(){
    GentestSecurityManager securityManager = new GentestSecurityManager();
    System.setSecurityManager(securityManager);
  }

  @After
  public void tearDown(){
    System.setSecurityManager(null);
  }

  @Test(expected = java.lang.NullPointerException.class)
  public void test000() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:27:35.432", TargetClass="com.pnsservice.pnsservice.controller.AfiliadoController", TestSuiteSize="1", TestCaseLength="3")
    String var0 = "\u0C9D\uC951\u3144";
    AfiliadoController var1 = new AfiliadoController();
    var1.deleteAfiliado(var0);
  }

  private static class GentestSecurityManager extends SecurityManager {

    private Set<String> blackList;
  
    public GentestSecurityManager() {
      super();
      chargeBlackList();
    }
  
    @Override
    public void checkPermission(Permission perm) {
  
      if (blackList.contains(perm.getActions())) {
        super.checkPermission(perm);
      }
    }
  
    private void chargeBlackList() {
      blackList = new LinkedHashSet<>();
      blackList.add("write");
      blackList.add("delete");
    }
  }
}