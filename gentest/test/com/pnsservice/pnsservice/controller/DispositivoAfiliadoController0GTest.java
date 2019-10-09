package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.controller.DispositivoAfiliadoController;
import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.TokenRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.security.Permission;
import java.util.LinkedHashSet;
import java.util.Set;

public class DispositivoAfiliadoController0GTest {

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
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:28:08.181", TargetClass="com.pnsservice.pnsservice.controller.DispositivoAfiliadoController", TestSuiteSize="2", TestCaseLength="2")
    TokenRequest var0 = null;
    Token var1 = var0.getTokens();
  }

  @Test(expected = java.lang.NullPointerException.class)
  public void test001() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:28:08.181", TargetClass="com.pnsservice.pnsservice.controller.DispositivoAfiliadoController", TestSuiteSize="2", TestCaseLength="24")
    TokenRequest var0 = new TokenRequest();
    Token var1 = var0.getTokens();
    Token var2 = var0.getTokens();
    Token var3 = var0.getTokens();
    Token var4 = var0.getTokens();
    Token var5 = var0.getTokens();
    Token var6 = var0.getTokens();
    Token var7 = var0.getTokens();
    Token var8 = var0.getTokens();
    Token var9 = var0.getTokens();
    Token var10 = var0.getTokens();
    Token var11 = var0.getTokens();
    Token var12 = var0.getTokens();
    Token var13 = var0.getTokens();
    Token var14 = var0.getTokens();
    Token var15 = var0.getTokens();
    Token var16 = var0.getTokens();
    Token var17 = var0.getTokens();
    Token var18 = var0.getTokens();
    Token var19 = var0.getTokens();
    Token var20 = var0.getTokens();
    Token var21 = var0.getTokens();
    DispositivoAfiliadoController var22 = new DispositivoAfiliadoController();
    ResponseEntity var23 = var22.deleteToken(var21);
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