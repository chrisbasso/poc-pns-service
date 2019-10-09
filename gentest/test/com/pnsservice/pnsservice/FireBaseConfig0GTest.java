package com.pnsservice.pnsservice;

import com.google.firebase.FirebaseApp;
import com.pnsservice.pnsservice.FireBaseConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Permission;
import java.util.LinkedHashSet;
import java.util.Set;

public class FireBaseConfig0GTest {

  @Before
  public void setUp(){
    GentestSecurityManager securityManager = new GentestSecurityManager();
    System.setSecurityManager(securityManager);
  }

  @After
  public void tearDown(){
    System.setSecurityManager(null);
  }

  @Test(expected = java.io.FileNotFoundException.class)
  public void test000() throws java.lang.Throwable {
    // @Gentest(Version="0.5.2", CreationTimeTamps="2019-10-09T14:25:16.849", TargetClass="com.pnsservice.pnsservice.FireBaseConfig", TestSuiteSize="1", TestCaseLength="2")
    FireBaseConfig var0 = new FireBaseConfig();
    FirebaseApp var1 = var0.createFireBaseApp();
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