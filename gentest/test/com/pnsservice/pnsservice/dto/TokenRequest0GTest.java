package com.pnsservice.pnsservice.dto;

import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.TokenRequest;
import java.lang.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Permission;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TokenRequest0GTest {

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
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:22.227", TargetClass="com.pnsservice.pnsservice.dto.TokenRequest", TestSuiteSize="6", TestCaseLength="2")
    TokenRequest var0 = null;
    Token var1 = var0.getToken();
  }

  @Test
  public void test001() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:22.227", TargetClass="com.pnsservice.pnsservice.dto.TokenRequest", TestSuiteSize="6", TestCaseLength="3")
    TokenRequest var0 = new TokenRequest();
    Token var1 = var0.getToken();
    assertNull(var1);
  }

  @Test
  public void test002() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:22.227", TargetClass="com.pnsservice.pnsservice.dto.TokenRequest", TestSuiteSize="6", TestCaseLength="3")
    TokenRequest var0 = new TokenRequest();
    Token var1 = var0.getTokens();
    assertNull(var1);
  }

  @Test
  public void test003() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:22.227", TargetClass="com.pnsservice.pnsservice.dto.TokenRequest", TestSuiteSize="6", TestCaseLength="5")
    TokenRequest var0 = new TokenRequest();
    Token var1 = var0.getTokens();
    TokenRequest var2 = new TokenRequest();
    var2.setTokens(var1);
    assertNull(var1);
  }

  @Test
  public void test004() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:22.228", TargetClass="com.pnsservice.pnsservice.dto.TokenRequest", TestSuiteSize="6", TestCaseLength="3")
    String var0 = "\uD484\u13FE\u9422\u4147";
    TokenRequest var1 = new TokenRequest();
    var1.setCredencial(var0);
  }

  @Test
  public void test005() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:26:22.228", TargetClass="com.pnsservice.pnsservice.dto.TokenRequest", TestSuiteSize="6", TestCaseLength="137")
    TokenRequest var0 = new TokenRequest();
    String var1 = var0.getCredencial();
    String var2 = var0.getCredencial();
    String var3 = var0.getCredencial();
    String var4 = var0.getCredencial();
    String var5 = var0.getCredencial();
    String var6 = var0.getCredencial();
    String var7 = var0.getCredencial();
    String var8 = var0.getCredencial();
    String var9 = var0.getCredencial();
    String var10 = var0.getCredencial();
    String var11 = var0.getCredencial();
    String var12 = var0.getCredencial();
    String var13 = var0.getCredencial();
    String var14 = var0.getCredencial();
    String var15 = var0.getCredencial();
    String var16 = var0.getCredencial();
    String var17 = var0.getCredencial();
    String var18 = var0.getCredencial();
    String var19 = var0.getCredencial();
    String var20 = var0.getCredencial();
    String var21 = var0.getCredencial();
    String var22 = var0.getCredencial();
    String var23 = var0.getCredencial();
    String var24 = var0.getCredencial();
    String var25 = var0.getCredencial();
    String var26 = var0.getCredencial();
    String var27 = var0.getCredencial();
    String var28 = var0.getCredencial();
    String var29 = var0.getCredencial();
    String var30 = var0.getCredencial();
    String var31 = var0.getCredencial();
    String var32 = var0.getCredencial();
    String var33 = var0.getCredencial();
    String var34 = var0.getCredencial();
    String var35 = var0.getCredencial();
    String var36 = var0.getCredencial();
    String var37 = var0.getCredencial();
    String var38 = var0.getCredencial();
    String var39 = var0.getCredencial();
    String var40 = var0.getCredencial();
    String var41 = var0.getCredencial();
    String var42 = var0.getCredencial();
    String var43 = var0.getCredencial();
    String var44 = var0.getCredencial();
    String var45 = var0.getCredencial();
    String var46 = var0.getCredencial();
    String var47 = var0.getCredencial();
    String var48 = var0.getCredencial();
    String var49 = var0.getCredencial();
    String var50 = var0.getCredencial();
    String var51 = var0.getCredencial();
    String var52 = var0.getCredencial();
    String var53 = var0.getCredencial();
    String var54 = var0.getCredencial();
    String var55 = var0.getCredencial();
    String var56 = var0.getCredencial();
    String var57 = var0.getCredencial();
    String var58 = var0.getCredencial();
    String var59 = var0.getCredencial();
    String var60 = var0.getCredencial();
    String var61 = var0.getCredencial();
    String var62 = var0.getCredencial();
    String var63 = var0.getCredencial();
    String var64 = var0.getCredencial();
    String var65 = var0.getCredencial();
    String var66 = var0.getCredencial();
    String var67 = var0.getCredencial();
    String var68 = var0.getCredencial();
    assertNull(var1);
    assertNull(var2);
    assertNull(var3);
    assertNull(var4);
    assertNull(var5);
    assertNull(var6);
    assertNull(var7);
    assertNull(var8);
    assertNull(var9);
    assertNull(var10);
    assertNull(var11);
    assertNull(var12);
    assertNull(var13);
    assertNull(var14);
    assertNull(var15);
    assertNull(var16);
    assertNull(var17);
    assertNull(var18);
    assertNull(var19);
    assertNull(var20);
    assertNull(var21);
    assertNull(var22);
    assertNull(var23);
    assertNull(var24);
    assertNull(var25);
    assertNull(var26);
    assertNull(var27);
    assertNull(var28);
    assertNull(var29);
    assertNull(var30);
    assertNull(var31);
    assertNull(var32);
    assertNull(var33);
    assertNull(var34);
    assertNull(var35);
    assertNull(var36);
    assertNull(var37);
    assertNull(var38);
    assertNull(var39);
    assertNull(var40);
    assertNull(var41);
    assertNull(var42);
    assertNull(var43);
    assertNull(var44);
    assertNull(var45);
    assertNull(var46);
    assertNull(var47);
    assertNull(var48);
    assertNull(var49);
    assertNull(var50);
    assertNull(var51);
    assertNull(var52);
    assertNull(var53);
    assertNull(var54);
    assertNull(var55);
    assertNull(var56);
    assertNull(var57);
    assertNull(var58);
    assertNull(var59);
    assertNull(var60);
    assertNull(var61);
    assertNull(var62);
    assertNull(var63);
    assertNull(var64);
    assertNull(var65);
    assertNull(var66);
    assertNull(var67);
    assertNull(var68);
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