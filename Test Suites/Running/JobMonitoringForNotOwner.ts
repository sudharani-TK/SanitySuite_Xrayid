<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>JobMonitoringForNotOwner</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>046dafbf-d7f5-45da-b37c-a88117008021</testSuiteGuid>
   <testCaseLink>
      <guid>794a907e-0520-4120-bd63-e645608d5309</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/JobMonitoring/JobDetails_NotJobOwner</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>0c08933b-719f-4cf4-9276-6c6719bcdfad</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>1-15</value>
         </iterationEntity>
         <testDataId>Data Files/Regression/TestDataForJobDetails</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>0c08933b-719f-4cf4-9276-6c6719bcdfad</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobState</value>
         <variableId>d20876b7-405d-46aa-8050-d90d8e283486</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>0c08933b-719f-4cf4-9276-6c6719bcdfad</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobAction</value>
         <variableId>096b1b3c-93a3-4759-bda4-00680435ede9</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>0c08933b-719f-4cf4-9276-6c6719bcdfad</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>TestCaseName</value>
         <variableId>68222694-cc5d-4cd4-8d4e-910f01944955</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>19cd4b2a-63b7-4ff8-aa1b-d7382d10b0f7</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>0c08933b-719f-4cf4-9276-6c6719bcdfad</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>userChoice</value>
         <variableId>4a80381d-71bf-40aa-8ca2-2702cda3b7be</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>51aded17-db62-4027-bfd0-77dac17d5180</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/XRepeated_TC/JobActions_ForJobStates_Topmenu_Icon_NotJobOwner</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>db2a179e-363b-49ab-a7bb-22cfe5090a90</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value>6</value>
         </iterationEntity>
         <testDataId>Data Files/Regression/TestDataJobActionsTopMenuNotOwner</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>db2a179e-363b-49ab-a7bb-22cfe5090a90</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobState</value>
         <variableId>eebf0263-f70f-401d-8ede-31b5d0e1c904</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>db2a179e-363b-49ab-a7bb-22cfe5090a90</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobAction</value>
         <variableId>3a33fa3e-5fca-4f4e-8849-51fba2ae93af</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>db2a179e-363b-49ab-a7bb-22cfe5090a90</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>TestCaseName</value>
         <variableId>4040756d-7905-420e-9245-19d8969a9a44</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>13a08161-d189-465b-950e-263fc1cae465</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
