import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.Status

//====================================================================================
WebDriver driver = DriverFactory.getWebDriver()

EventFiringWebDriver eventFiring = ((DriverFactory.getWebDriver()) as EventFiringWebDriver)

WebDriver wrappedWebDriver = eventFiring.getWrappedDriver()

//RemoteWebDriver katalonWebDriver = ((wrappedWebDriver) as RemoteWebDriver)
RemoteWebDriver katalonWebDriver = (RemoteWebDriver) wrappedWebDriver

//==================================================================
def Browser = GlobalVariable.G_Browser
//===============================================================
def extentTest=GlobalVariable.G_ExtentTest
//===========================================================
CustomKeywords.'toLogin.ForLogin.Login'(extentTest)
//=============================================================

println('*****************************************************')

println(GlobalVariable.G_Platform)

println('*****************************************************')

def navLocation = CustomKeywords.'generateFilePath.filePath.execLocation'()

def location = navLocation + '/JobsModule/'

println('*****************************************************')

println(location)

println('*****************************************************')

TestObject newFileObj = null

try {
	WebUI.enableSmartWait()

	//def jobsTab = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('GenericObjects/JobsTab_disabled'),
	//20, extentTest, 'Jobs Tab')
	//if (jobsTab) {
	WebUI.click(findTestObject('GenericObjects/TitleLink_Jobs'))

	//}
	extentTest.log(Status.PASS, 'Navigated Jobs Tab')

	//WebUI.delay(2)
	println(AppName)

	//TestObject newAppObj = WebUI.modifyObjectProperty(findTestObject('LoginPage/NewJobPage/TestAppDef-AppComp'), 'data-automation-id','equals', AppName, true)
	
	WebUI.click(findTestObject('Object Repository/LoginPage/NewJobPage/TestAppDef-AppComp'))

	extentTest.log(Status.PASS, 'Navigated to Job Submission For for - ' + AppName)

	//WebUI.delay(2)
	/*def errorPanel = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('JobSubmissionForm/JS_ErrorModalPanel'),
			3, extentTest, 'Error Panel Close Icon')
	if (errorPanel) {
		WebUI.click(findTestObject('Object Repository/JobSubmissionForm/button_Close'))
	}*/
	WebUI.doubleClick(findTestObject('Object Repository/LoginPage/NewJobPage/GenericProfile'))

  /*  if (AppName.contains('InComplete')) {
		WebUI.doubleClick(findTestObject('Object Repository/JobSubmissionForm/TxtBox_ReqFiled_ToFill'))

		WebUI.setText(findTestObject('Object Repository/JobSubmissionForm/TxtBox_ReqFiled_ToFill'), 'testString')
	}
	
	CustomKeywords.'operations_JobsModule.JobSubmissions.JSAllFileds'(ToChange, ChangeValue, extentTest)

	if (ExecMode.equals('Array')) {
		WebUI.delay(2)

		extentTest.log(Status.PASS, 'No file required for Array Job') //WebUI.delay(2)
		//WebUI.delay(3)
		//WebUI.click(newFileObj)
		//WebUI.delay(2)
	} else {
		println('else')

		WebUI.scrollToElement(findTestObject('JobSubmissionForm/Link_Server'), 3)

		WebUI.disableSmartWait()

		println('ExecMode' + ExecMode)*/

		newFileObj = CustomKeywords.'operations_JobsModule.JobSubmissions.selectFile'(ExecMode, InputFile, extentTest)

		WebUI.rightClick(newFileObj)

		extentTest.log(Status.PASS, 'Right Clicked on Input file ' + InputFile)

		String idForCntxtMn = 'Add as ' + FileArg

		TestObject newRFBContextMnOption = WebUI.modifyObjectProperty(findTestObject('Object Repository/LoginPage/NewJobPage/ContextMenu_RFB_FilePicker'),
			'id', 'equals', idForCntxtMn, true)

		WebUI.click(newRFBContextMnOption)

		extentTest.log(Status.PASS, 'Clicked on context menu - ' + idForCntxtMn)
   // }
	
	def submitBtn = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(findTestObject('JobSubmissionForm/button_Submit_Job'),
		20, extentTest, 'Submit Button')

	if (submitBtn) {
		WebUI.click(findTestObject('JobSubmissionForm/button_Submit_Job'))

		extentTest.log(Status.PASS, 'Clicked on Submit Button ')
	}
	
	WebUI.waitForElementPresent(findTestObject('Notificactions/Notification_JobSubmission'), 5)

	def jobText = WebUI.getText(findTestObject('Notificactions/Notification_JobSubmission'))

	extentTest.log(Status.PASS, 'Notification Generated')

	GlobalVariable.G_JobID = CustomKeywords.'operations_JobsModule.GetJobRowDetails.getJobID'(jobText)

	extentTest.log(Status.PASS, 'Job ID - ' + GlobalVariable.G_JobID)

  //  WebUI.enableSmartWait()

   /* if (ToChange.equals('SetOutPutDir')) {
		WebUI.click(findTestObject('GenericObjects/TitleLink_Files'))

		extentTest.log(Status.PASS, 'Navigated to Files Tab')

		//WebUI.delay(2)
		CustomKeywords.'operations_FileModule.ChangeView.changePageView'(TestCaseName, extentTest)

		//WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/FilesPage/Icon_EditFilePath'))
		//WebUI.setText(findTestObject('Object Repository/FilesPage/textBx_FilePath'), location)
		//	WebUI.sendKeys(findTestObject('Object Repository/FilesPage/textBx_FilePath'), Keys.chord(Keys.ENTER))
		/*WebUI.click(findTestObject('Object Repository/FilesPage/FilesSearch_filter'))
		WebUI.setText(findTestObject('Object Repository/FilesPage/FilesSearch_filter'), location)
	WebUI.sendKeys(findTestObject('Object Repository/FilesPage/FilesSearch_filter'), Keys.chord(Keys.ENTER))*/
	  /*  CustomKeywords.'generateFilePath.filePath.navlocation'(location, extentTest)

		//	extentTest.log(Status.PASS, ('Navigated to ' + location) + ' in files tab')
		TestObject newFileObjJS = WebUI.modifyObjectProperty(findTestObject('FilesPage/RowItem_File_ListView'), 'data-automation-id',
			'equals', InputFile, true)

		def fileItem = CustomKeywords.'customWait.WaitForElement.WaitForelementPresent'(newFileObjJS, 20, extentTest, InputFile)

		println(fileItem)

		if (fileItem) {
			extentTest.log(Status.PASS, 'Output file - jobFile.out exists ')
		}
	}
	
	TestObject jobIdEle = CustomKeywords.'buildTestObj.CreateTestObjJobs.myTestObjJobRow'(GlobalVariable.G_JobID)

	WebUI.click(findTestObject('GenericObjects/TitleLink_Jobs'))

	//WebUI.delay(2)
	if (ExecMode.equals('Array')) {
		//WebUI.delay(2)
		CustomKeywords.'operations_JobsModule.GetJobRowDetails.checkSubJobs'(katalonWebDriver, 'JS', extentTest)
	}*/
	
	extentTest.log(Status.PASS, 'Verified - ' + TestCaseName)

//    WebUI.disableSmartWait()

	if (GlobalVariable.G_Browser == 'Edge') {
		WebUI.callTestCase(findTestCase('XRepeated_TC/Logout'), [:], FailureHandling.STOP_ON_FAILURE)
	}
}
catch (Exception ex) {
	println('From TC - ' + GlobalVariable.G_ReportFolder)

	String screenShotPath = (('ExtentReports/' + TestCaseName) + GlobalVariable.G_Browser) + '.png'

	WebUI.takeScreenshot(screenShotPath)

	String p = (TestCaseName + GlobalVariable.G_Browser) + '.png'

	extentTest.log(Status.FAIL, ex)

	extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(p).build())
}
catch (StepErrorException e) {
	String screenShotPath = (('ExtentReports/' + TestCaseName) + GlobalVariable.G_Browser) + '.png'

	WebUI.takeScreenshot(screenShotPath)

	String p = (TestCaseName + GlobalVariable.G_Browser) + '.png'

	extentTest.log(Status.FAIL, ex)

	extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(p).build())
}
finally {
	extentTest.log(Status.PASS, 'Closing the browser after executinge test case - ' + TestCaseName)
	
	
}



