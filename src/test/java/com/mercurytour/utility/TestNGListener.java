package com.mercurytour.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    /**
     * ************************************************************************************************
     * @author sakhter
     * Class Name: Utility
     * Description: This class will capture the screenshot after the test execution
     * Date: 1/6/2022
     * ************************************************************************************************
     **/

    public class TestNGListener implements ITestListener {
        @Override
        public void onFinish(ITestContext result) {
            System.out.println("TestCases failed and details are "+result.getName());
        }
        @Override
        public void onStart(ITestContext result) {
            System.out.println("TestCases skipped and details are "+result.getName());
        }
        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            System.out.println("TestCases skipped and details are "+result.getName());
        }
        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("TestCases failed and details are "+result.getName());
        }
        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("TestCases skipped and details are "+result.getName());
        }
        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("TestCases started and details are "+result.getName());
        }
        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("TestCases succeed and details are "+result.getName());
        }

/**
 *********************************************************************************************************
 >>>>>>>>>>>>>> End of the File <<<<<<<<<<<<<<<<<
 *********************************************************************************************************
 **/
    }

