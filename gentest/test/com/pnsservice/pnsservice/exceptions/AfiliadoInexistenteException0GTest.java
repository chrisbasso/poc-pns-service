package com.pnsservice.pnsservice.exceptions;

import com.pnsservice.pnsservice.exceptions.AfiliadoInexistenteException;
import java.lang.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.security.Permission;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AfiliadoInexistenteException0GTest {

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
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:56.734", TargetClass="com.pnsservice.pnsservice.exceptions.AfiliadoInexistenteException", TestSuiteSize="3", TestCaseLength="4")
    String var0 = "";
    String var1 = "\u7CB1";
    AfiliadoInexistenteException var2 = null;
    HttpStatus var3 = var2.getHttpStatus();
  }

  @Test
  public void test001() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:56.734", TargetClass="com.pnsservice.pnsservice.exceptions.AfiliadoInexistenteException", TestSuiteSize="3", TestCaseLength="3")
    String var0 = null;
    HttpStatus var1 = null;
    AfiliadoInexistenteException var2 = new AfiliadoInexistenteException(var0, var1);
  }

  @Test
  public void test002() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:56.735", TargetClass="com.pnsservice.pnsservice.exceptions.AfiliadoInexistenteException", TestSuiteSize="3", TestCaseLength="5")
    String var0 = null;
    HttpStatus var1 = null;
    AfiliadoInexistenteException var2 = new AfiliadoInexistenteException(var0, var1);
    HttpStatus var3 = var2.getHttpStatus();
    assertNull(var3);
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