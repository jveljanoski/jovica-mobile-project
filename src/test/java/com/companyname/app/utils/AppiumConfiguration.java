package com.companyname.app.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppiumConfiguration {
    public static AppiumDriverLocalService service;

    // Update the values as per your environment.
    public static String NodeExePath = "C:\\Program Files\\nodejs\\node.exe";
    public static String AppiumPath = "C:\\Users\\jovicav\\AppData\\Roaming\\npm\\node_modules\\appium";
    public static String ServerAddress = "127.0.0.1";
    public static String Port = "4723";
    public static String ANDROID_HOME = "C:\\Users\\jovicav\\AppData\\Local\\Android\\Sdk";
    public static String JAVA_HOME = "C:\\Program Files\\Java\\jdk-11.0.8";

    public static void StartAppiumServer() {
        AppiumServiceBuilder appiumBuilder = new AppiumServiceBuilder();
        appiumBuilder.withIPAddress(ServerAddress);
        appiumBuilder.usingPort(Integer.parseInt(Port));
        appiumBuilder.usingDriverExecutable(new File(NodeExePath));
        appiumBuilder.withAppiumJS(new File(AppiumPath));
        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME", ANDROID_HOME);
        env.put("JAVA_HOME", JAVA_HOME);
        appiumBuilder.withEnvironment(env);
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(appiumBuilder);
        service.start();
    }

    public static void StopAppiumServer() {
        service.stop();
    }
}
