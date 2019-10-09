package com.pnsservice.pnsservice;

import com.pnsservice.pnsservice.PnsServiceApplication;
import java.lang.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Permission;
import java.util.LinkedHashSet;
import java.util.Set;

public class PnsServiceApplication0GTest {

  @Before
  public void setUp(){
    GentestSecurityManager securityManager = new GentestSecurityManager();
    System.setSecurityManager(securityManager);
  }

  @After
  public void tearDown(){
    System.setSecurityManager(null);
  }

  @Test(expected = java.security.AccessControlException.class)
  public void test000() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:25:48.737", TargetClass="com.pnsservice.pnsservice.PnsServiceApplication", TestSuiteSize="2", TestCaseLength="15")
    String var0 = null;
    String var1 = "\u076F\u21BD";
    String var2 = "\uA216\u8F2F\u0585\uA63E";
    String var3 = "\u6ED2";
    String var4 = "\u7DB3\uCF0D\uC1AB\u5550";
    String var5 = "\uD616";
    String var6 = "\uE75E";
    String var7 = null;
    String var8 = "\u3F4D";
    String var9 = "\uA2D8\u0716\u50BE\uD889";
    String var10 = "\u2439\u0F4A\u88A0";
    String var11 = "\u4AD0\u9888\u76BA\u3F1A";
    String var12 = "\u8DCE\uB67A\u60E3\u4657";
    String[] var13 = new String[13];
    var13[0] = var0;
    var13[1] = var1;
    var13[2] = var2;
    var13[3] = var3;
    var13[4] = var4;
    var13[5] = var5;
    var13[6] = var6;
    var13[7] = var7;
    var13[8] = var8;
    var13[9] = var9;
    var13[10] = var10;
    var13[11] = var11;
    var13[12] = var12;
    com.pnsservice.pnsservice.PnsServiceApplication.main(var13);
  }

  @Test
  public void test001() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:25:48.737", TargetClass="com.pnsservice.pnsservice.PnsServiceApplication", TestSuiteSize="2", TestCaseLength="1")
    PnsServiceApplication var0 = new PnsServiceApplication();
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